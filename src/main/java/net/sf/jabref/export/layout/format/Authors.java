/*  Copyright (C) 2003-2011 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/
package net.sf.jabref.export.layout.format;

import net.sf.jabref.AuthorList;
import net.sf.jabref.export.layout.AbstractParamLayoutFormatter;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Versatile author name formatter that takes arguments to control the formatting style.
 */
public class Authors extends AbstractParamLayoutFormatter {

    /*
    AuthorSort = [FirstFirst | LastFirst | LastFirstFirstFirst]
    AuthorAbbr = [FullName | Initials | FirstInitial | MiddleInitial | InitialsNoSpace | LastName]
    AuthorSep = [Comma | And | Colon | Semicolon | Sep=<string>]
    AuthorLastSep = [And | Comma | Colon | Semicolon | Amp | Oxford | LastSep=<string>]
    AuthorPunc = [FullPunc | NoPunc | NoComma | NoPeriod]
    AuthorNumber = [inf | <number>]
    AuthorNumberEtAl = [ {1} | <number>]
    EtAlString = [ et al. | EtAl=<string>]
    */

    static final ArrayList<String>
            authorOrder = new ArrayList<String>();
    static final ArrayList<String> authorAbbr = new ArrayList<String>();
    static final ArrayList<String> authorPunc = new ArrayList<String>();
    static final ArrayList<String> separators = new ArrayList<String>();
    static final ArrayList<String> lastSeparators = new ArrayList<String>();

    static final Pattern numberPattern = Pattern.compile("[0-9]+");

    static {
        Authors.authorOrder.add("firstfirst");
        Authors.authorOrder.add("lastfirst");
        Authors.authorOrder.add("lastfirstfirstfirst");

        Authors.authorAbbr.add("fullname");
        Authors.authorAbbr.add("initials");
        Authors.authorAbbr.add("firstinitial");
        Authors.authorAbbr.add("middleinitial");
        Authors.authorAbbr.add("lastname");
        Authors.authorAbbr.add("initialsnospace");

        Authors.authorPunc.add("fullpunc");
        Authors.authorPunc.add("nopunc");
        Authors.authorPunc.add("nocomma");
        Authors.authorPunc.add("noperiod");

        Authors.separators.add("comma");
        Authors.separators.add("and");
        Authors.separators.add("colon");
        Authors.separators.add("semicolon");
        Authors.separators.add("sep");

        Authors.lastSeparators.add("and");
        Authors.lastSeparators.add("colon");
        Authors.lastSeparators.add("semicolon");
        Authors.lastSeparators.add("amp");
        Authors.lastSeparators.add("oxford");
        Authors.lastSeparators.add("lastsep");

    }

    final static int
            FIRST_FIRST = 0,
            LAST_FIRST = 1,
            LF_FF = 2;

    final static String
            COMMA = ", ",
            AMP = " & ",
            COLON = ": ",
            SEMICOLON = "; ",
            AND = " and ",
            OXFORD = ", and ";

    int flMode = Authors.FIRST_FIRST;

    boolean
            abbreviate = true,
            firstInitialOnly = false,
            middleInitial = false,
            lastNameOnly = false,
            abbrDots = true,
            abbrSpaces = true;

    boolean setSep = false;
    boolean setMaxAuthors = false;
    int maxAuthors = -1;
    int authorNumberEtAl = 1;

    final String
            firstFirstSeparator = " ";
    String lastFirstSeparator = ", ";
    String separator = Authors.COMMA;
    String lastSeparator = Authors.AND;
    String etAlString = " et al.";
    final String jrSeparator = " ";


    @Override
    public void setArgument(String arg) {
        String[] parts = AbstractParamLayoutFormatter.parseArgument(arg);
        for (String part : parts) {
            int index = part.indexOf("=");
            if (index > 0) {
                String key = part.substring(0, index);
                String value = part.substring(index + 1);
                handleArgument(key, value);
            } else {
                handleArgument(part, "");
            }

        }
    }

    private void handleArgument(String key, String value) {
        if (Authors.authorOrder.contains(key.trim().toLowerCase())) {
            if (comp(key, "FirstFirst")) {
                flMode = Authors.FIRST_FIRST;
            } else if (comp(key, "LastFirst")) {
                flMode = Authors.LAST_FIRST;
            } else if (comp(key, "LastFirstFirstFirst")) {
                flMode = Authors.LF_FF;
            }
        }
        else if (Authors.authorAbbr.contains(key.trim().toLowerCase())) {
            if (comp(key, "FullName")) {
                abbreviate = false;
            }
            else if (comp(key, "Initials")) {
                abbreviate = true;
                firstInitialOnly = false;
            }
            else if (comp(key, "FirstInitial")) {
                abbreviate = true;
                firstInitialOnly = true;
            }
            else if (comp(key, "MiddleInitial")) {
                abbreviate = true;
                middleInitial = true;
            }
            else if (comp(key, "LastName")) {
                lastNameOnly = true;
            }
            else if (comp(key, "InitialsNoSpace")) {
                abbreviate = true;
                abbrSpaces = false;
            }
        }
        else if (Authors.authorPunc.contains(key.trim().toLowerCase())) {
            if (comp(key, "FullPunc")) {
                abbrDots = true;
                lastFirstSeparator = ", ";
            }
            else if (comp(key, "NoPunc")) {
                abbrDots = false;
                lastFirstSeparator = " ";
            }
            else if (comp(key, "NoComma")) {
                abbrDots = true;
                lastFirstSeparator = " ";
            }
            else if (comp(key, "NoPeriod")) {
                abbrDots = false;
                lastFirstSeparator = ", ";
            }
        }

        // AuthorSep = [Comma | And | Colon | Semicolon | sep=<string>]
        // AuthorLastSep = [And | Comma | Colon | Semicolon | Amp | Oxford | lastsep=<string>]
        else if (Authors.separators.contains(key.trim().toLowerCase()) || Authors.lastSeparators.contains(key.trim().toLowerCase())) {
            if (comp(key, "Comma")) {
                if (!setSep) {
                    separator = Authors.COMMA;
                    setSep = true;
                } else {
                    lastSeparator = Authors.COMMA;
                }
            }
            else if (comp(key, "And")) {
                if (!setSep) {
                    separator = Authors.AND;
                    setSep = true;
                } else {
                    lastSeparator = Authors.AND;
                }
            }
            else if (comp(key, "Colon")) {
                if (!setSep) {
                    separator = Authors.COLON;
                    setSep = true;
                } else {
                    lastSeparator = Authors.COLON;
                }
            }
            else if (comp(key, "Semicolon")) {
                if (!setSep) {
                    separator = Authors.SEMICOLON;
                    setSep = true;
                } else {
                    lastSeparator = Authors.SEMICOLON;
                }
            }
            else if (comp(key, "Oxford")) {
                lastSeparator = Authors.OXFORD;
            }
            else if (comp(key, "Amp")) {
                lastSeparator = Authors.AMP;
            }
            else if (comp(key, "Sep") && (value.length() > 0)) {
                separator = value;
                setSep = true;
            }
            else if (comp(key, "LastSep") && (value.length() > 0)) {
                lastSeparator = value;
            }
        }
        else if (key.trim().toLowerCase().equals("etal") && (value.length() > 0)) {
            etAlString = value;
        }
        else if (Authors.numberPattern.matcher(key.trim()).matches()) {
            // Just a number:
            int num = Integer.parseInt(key.trim());
            if (!setMaxAuthors) {
                maxAuthors = num;
                setMaxAuthors = true;
            } else {
                authorNumberEtAl = num;
            }
        }

    }

    /**
     * Check for case-insensitive equality between two strings after removing
     * white space at the beginning and end of the first string.
     * @param one The first string - whitespace is trimmed
     * @param two The second string
     * @return true if the strings are deemed equal
     */
    public boolean comp(String one, String two) {
        return one.trim().equalsIgnoreCase(two);
    }

    @Override
    public String format(String fieldText) {
        StringBuilder sb = new StringBuilder();
        AuthorList al = AuthorList.getAuthorList(fieldText);

        if ((maxAuthors < 0) || (al.size() <= maxAuthors)) {
            for (int i = 0; i < al.size(); i++) {
                AuthorList.Author a = al.getAuthor(i);

                addSingleName(sb, a, (flMode == Authors.FIRST_FIRST) || ((flMode == Authors.LF_FF) && (i > 0)));

                if (i < (al.size() - 2)) {
                    sb.append(separator);
                } else if (i < (al.size() - 1)) {
                    sb.append(lastSeparator);
                }
            }
        }

        else {
            for (int i = 0; i < Math.min(al.size() - 1, authorNumberEtAl); i++) {
                if (i > 0) {
                    sb.append(separator);
                }
                addSingleName(sb, al.getAuthor(i), flMode == Authors.FIRST_FIRST);
            }
            sb.append(etAlString);
        }

        return sb.toString();
    }

    private void addSingleName(StringBuilder sb, AuthorList.Author a, boolean firstFirst) {
        String firstNamePart = a.getFirst();
        String lastNamePart = a.getLast();
        String von = a.getVon();
        if ((von != null) && (von.length() > 0)) {
            lastNamePart = von + " " + lastNamePart;
        }
        String jr = a.getJr();
        if ((jr != null) && (jr.length() > 0)) {
            lastNamePart = lastNamePart + jrSeparator + jr;
        }

        if (abbreviate && (firstNamePart != null)) {
            firstNamePart = a.getFirstAbbr();

            if (firstInitialOnly && (firstNamePart.length() > 2)) {
                firstNamePart = firstNamePart.substring(0, 2);
            } else if (middleInitial) {
                String abbr = firstNamePart;
                firstNamePart = a.getFirst();
                int index = firstNamePart.indexOf(" ");
                //System.out.println(firstNamePart);
                //System.out.println(index);
                if (index >= 0) {
                    firstNamePart = firstNamePart.substring(0, index + 1);
                    if (abbr.length() > 3) {
                        firstNamePart = firstNamePart + abbr.substring(3);
                    }
                }
            }
            if (!abbrDots) {
                firstNamePart = firstNamePart.replaceAll("\\.", "");
            }
            if (!abbrSpaces) {
                firstNamePart = firstNamePart.replaceAll(" ", "");
            }
        }

        if (lastNameOnly || (firstNamePart == null)) {
            sb.append(lastNamePart);
        }
        else if (firstFirst) {
            sb.append(firstNamePart).append(firstFirstSeparator);
            sb.append(lastNamePart);
        }
        else {
            sb.append(lastNamePart).append(lastFirstSeparator).append(firstNamePart);
        }

    }

    public static void main(String[] args) {
        Authors format = new Authors();
        format.setArgument("lastfirstfirstfirst , initials,  Nocomma,Amp,Semicolon,30 ,EtAl = m.fl.");
        System.out.println(format.format("Alfredsen, Jr, Jo Arve and Morten Omholt Alver and Yngvar von Olsen and Sebastian A. L. M. Kooijman"));
    }
}
