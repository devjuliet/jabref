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
package net.sf.jabref.imports;

import net.sf.jabref.JabRefFrame;
import net.sf.jabref.Globals;
import net.sf.jabref.JabRef;
import net.sf.jabref.export.AutoSaveManager;

import javax.swing.*;
import java.io.File;
import java.util.*;
import net.sf.jabref.BasePanel;

/**
 * Runnable task that prompts the user for what to do about files loaded at startup,
 * where an autosave file was found. The task should be run on the EDT after startup.
 */
public class AutosaveStartupPrompter implements Runnable {

    private final JabRefFrame frame;
    private final List<File> files;


    public AutosaveStartupPrompter(JabRefFrame frame, List<File> files) {

        this.frame = frame;
        this.files = files;
    }

    @Override
    public void run() {
        boolean first = frame.baseCount() == 0;
        List<ParserResult> loaded = new ArrayList<ParserResult>();
        Map<ParserResult, Integer> location = new HashMap<ParserResult, Integer>();
        for (File file : files) {
            File fileToLoad = file;
            boolean tryingAutosave;
            if (Globals.prefs.getBoolean("promptBeforeUsingAutosave")) {
                int answer = JOptionPane.showConfirmDialog(null, "<html>" +
                        Globals.lang("An autosave file was found for this database. This could indicate ")
                        + Globals.lang("that JabRef didn't shut down cleanly last time the file was used.") + "<br>"
                        + Globals.lang("Do you want to recover the database from the autosave file?") + "</html>",
                        Globals.lang("Autosave of file '%0'", file.getName()), JOptionPane.YES_NO_OPTION);
                tryingAutosave = answer == JOptionPane.YES_OPTION;
            } else {
                tryingAutosave = true;
            }

            if (tryingAutosave) {
                fileToLoad = AutoSaveManager.getAutoSaveFile(file);
            }
            boolean done = false;
            ParserResult pr = null;
            while (!done) {
                pr = JabRef.openBibFile(fileToLoad.getPath(), true);
                if ((pr != null) && !pr.isInvalid()) {
                    loaded.add(pr);
                    BasePanel panel = frame.addTab(pr.getDatabase(), file,
                            pr.getMetaData(), pr.getEncoding(), first);
                    location.put(pr, frame.baseCount() - 1);
                    if (tryingAutosave) {
                        panel.markNonUndoableBaseChanged();
                    }

                    first = false;
                    done = true;
                } else {
                    if (tryingAutosave) {
                        JOptionPane.showMessageDialog(frame,
                                Globals.lang("Error opening autosave of '%0'. Trying to load '%0' instead.", file.getName()),
                                Globals.lang("Error opening file"), JOptionPane.ERROR_MESSAGE);
                        tryingAutosave = false;
                        fileToLoad = file;
                    } else {
                        String message;
                        if (pr != null) {
                            message = "<html>" + pr.getErrorMessage() + "<p>" +
                                    Globals.lang("Error opening file '%0'.", file.getName()) + "</html>";
                        }
                        else {
                            message = Globals.lang("Error opening file '%0'.", file.getName());
                        }
                        JOptionPane.showMessageDialog(frame,
                                message, Globals.lang("Error opening file"), JOptionPane.ERROR_MESSAGE);
                        done = true;
                    }

                }
            }

            if ((pr != null) && !pr.isInvalid()) {
                if (Globals.prefs.getBoolean("displayKeyWarningDialogAtStartup") && pr.hasWarnings()) {
                    String[] wrns = pr.warnings();
                    StringBuilder wrn = new StringBuilder();
                    for (int j = 0; j < wrns.length; j++) {
                        wrn.append(j + 1).append(". ").append(wrns[j]).append("\n");
                    }
                    if (wrn.length() > 0) {
                        wrn.deleteCharAt(wrn.length() - 1);
                    }
                    frame.showBaseAt(location.get(pr));
                    JOptionPane.showMessageDialog(frame, wrn.toString(),
                            Globals.lang("Warnings"),
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        /*for (int i = 0; i < loaded.size(); i++) {
            ParserResult pr = loaded.get(i);
            
        }*/

    }
}
