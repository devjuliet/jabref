/*  Copyright (C) 2012 JabRef contributors.
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

/**
 * Container class for lists with keywords where the case should be kept independent of bibstyle
 * 
 */
public class CaseKeeperList {

    // Common words in IEEE Xplore that should always be in the given case
    public final String[] wordListIEEEXplore = new String[] {
            "1-D",
            "1D",
            "2-D",
            "2D",
            "3-D",
            "3D",
            "3G",
            "3GPP",
            "4-D",
            "4D",
            "4G",
            "4H",
            "6H",
            "A/D",
            "ACM",
            "AC",
            "ADC",
            "ADI",
            "ADSL",
            "ADP",
            "ADPLL",
            "AES",
            "AFE",
            "AGC",
            "AI",
            "AIQ",
            "ALU",
            "AMPS",
            "AM",
            "AND",
            "ANOVA",
            "ANSI",
            "API",
            "ARMA",
            "ARQ",
            "ASIC",
            "ASIP",
            "ASK",
            "ATE",
            "ATM",
            "ATP",
            "ATPG",
            "ATSC",
            "ATV",
            "AVC",
            "AWGN",
            "Alamouti",
            "AlGaAs",
            "AlGaN",
            "AlN",
            "Altera",
            "BCD",
            "BCH",
            "BCJR",
            "BDD",
            "BER",
            "BGA",
            "BIBO",
            "BIST",
            "BJT",
            "BLAST",
            "BPSK",
            "BP",
            "BT",
            "Baum",
            "Bayes",
            "Berlekamp",
            "Bessel",
            "BiCMOS",
            "Blackwell",
            "Bluetooth",
            "Booth",
            "Bose",
            "Bragg",
            "Butterworth",
            "CAD",
            "CAS",
            "CATV",
            "CBR",
            "CCD",
            "CDMA",
            "CD",
            "CDC",
            "CDR",
            "CERN",
            "CFAR",
            "CIC",
            "CLB",
            "CMFB",
            "CMOS",
            "CMRR",
            "CMS",
            "CNF",
            "CNN",
            "CO2",
            "CORDIC",
            "COTS",
            "CP",
            "CPE",
            "CPM",
            "CPLD",
            "CPU",
            "CRC",
            "CRM",
            "CSD",
            "CSE",
            "CSIT",
            "CSI",
            "CSMA",
            "CSP",
            "CT",
            "CUDA",
            "CW",
            "Carlo",
            "Cauer",
            "Chebychev",
            "Chebyshev",
            "Chien",
            "Cooley",
            "D/A",
            "DAB",
            "DAC",
            "DBMS",
            "DCT",
            "DC",
            "DDC",
            "DDFS",
            "DDR",
            "DDSM",
            "DDS",
            "DDoS",
            "DECT",
            "DEM",
            "DFE",
            "DFT",
            "DGPS",
            "DHT",
            "DIMM",
            "DLL",
            "DMT",
            "DNA",
            "DNL",
            "DOA",
            "DOCSIS",
            "DOI",
            "DPSK",
            "DRAM",
            "DRM",
            "DS",
            "DSP",
            "DST",
            "DTMB",
            "DTTB",
            "DTV",
            "DUC",
            "DVB-C",
            "DVB-H",
            "DVB-S",
            "DVB-T",
            "DVB",
            "DVD",
            "DVFS",
            "DVI",
            "DWT",
            "Dadda",
            "Daubechies",
            "Doppler",
            "ECC",
            "ECG",
            "ECL",
            "EDGE",
            "EEG",
            "EJB",
            "EKF",
            "EKG",
            "EMC",
            "EMG",
            "EMI",
            "ENOB",
            "EPROM",
            "ESD",
            "ESPRIT",
            "EV",
            "EVM",
            "Einstein",
            "Euclid",
            "Euler",
            "FBAR",
            "FDE",
            "FDI",
            "FDMA",
            "FDTD",
            "FEC",
            "FEM",
            "FER",
            "FET",
            "FFT",
            "FIFO",
            "FIR",
            "FMCW",
            "FM",
            "FP",
            "FPAA",
            "FPGA",
            "FPU",
            "FRM",
            "FSK",
            "FSM",
            "FTTC",
            "FTTH",
            "Farrow",
            "FinFET",
            "Fokker",
            "Fourier",
            "Frobenius",
            "GALS",
            "GCM",
            "GF",
            "GIS",
            "GM",
            "GMD",
            "GNSS",
            "GNU",
            "GPGPU",
            "GPRS",
            "GPS",
            "GPU",
            "GSM",
            "GSPS",
            "GaAs",
            "GaN",
            "Gabor",
            "Galileo",
            "Galois",
            "Gauss",
            "Gram-Schmidt",
            "H.264",
            "HARQ",
            "HBM",
            "HBT",
            "HDMI",
            "HDTV",
            "HD",
            "HDD",
            "HDI",
            "HDL",
            "HEMT",
            "HEVC",
            "HF",
            "HMM",
            "HPC",
            "HRV",
            "HSPA",
            "HSDPA",
            "HTML",
            "HVAC",
            "HVDC",
            "HW",
            "Haar",
            "Hadamard",
            "Hamming",
            "Hankel",
            "Hartley",
            "Hermit", // Hermitian, Hermite, Hermit
            "Hilbert",
            "I-V",
            "I/O",
            "I/Q",
            "IBM",
            "ICA",
            "IC",
            "ICI",
            "ICT",
            "IDCT",
            "IDFT",
            "IEC",
            "IEE",
            "IEEE",
            "IET",
            "IFFT",
            "IFIR",
            "IF",
            "IGBT",
            "II-VI",
            "II/VI",
            "III-V",
            "III/V",
            "IIR",
            "ILP",
            "IMDCT",
            "IMDST",
            "IMT-A", // IMT-Advanced
            "IMU",
            "INL",
            "IO",
            "IPTV",
            "IP",
            "IQ",
            "IR",
            "IS-95",
            "ISDN",
            "ISI",
            "ISM",
            "ISO",
            "ISS",
            "ITE",
            "InGaAs",
            "InGaN",
            "InP",
            "InSAR",
            "J2EE",
            "JEDEC",
            "JFET",
            "JIT",
            "JPEG",
            "JTAG",
            "Josephson",
            "Kalman",
            "Karatsuba",
            "LAN",
            "LC",
            "LCD",
            "LCG",
            "LDA",
            "LDD",
            "LDI",
            "LDPC",
            "LED",
            "LFSR",
            "LHC",
            "LIDAR",
            "LiDAR",
            "LLC",
            "LLR",
            "LMDS",
            "LMI",
            "LMS",
            "LNA",
            "LNS",
            "LS",
            "LSB",
            "LTCC",
            "LTE-A",
            "LTE",
            "LTI",
            "LUT",
            "LVDC",
            "LVDS",
            "LZW",
            "Laplace",
            "Lempel",
            "Lyapunov",
            "M2M",
            "MAC",
            "MANET",
            "MAP",
            "MASH",
            "MBE",
            "MC",
            "MCE",
            "MCM",
            "MCMC",
            "MCU",
            "MDCT",
            "MDST",
            "MEMS",
            "MESFET",
            "MILP",
            "MIMO",
            "MISO",
            "MIT",
            "ML",
            "MLSD",
            "MMIC",
            "MMS",
            "MMSE",
            "MOSFET",
            "MOS",
            "MP3",
            "MPC",
            "MPEG",
            "MPI",
            "MPPC",
            "MPSoC",
            "MQW",
            "MRC",
            "MRI",
            "MRTD",
            "MSB",
            "MSD",
            "MSE",
            "MSPS",
            "MTCMOS",
            "MTD",
            "MTI",
            "MV",
            "MVC",
            "Maclaurin",
            "Manchester",
            "Markov",
            "Massey",
            "Maxwell",
            "McClellan",
            "Miller",
            "Monte",
            "Montgomery",
            "Msps",
            "NAND",
            "NOR",
            "NF",
            "NMOS",
            "NRZ",
            "NTSC",
            "Newton",
            "NoC",
            "Nyquist",
            "OCR",
            "OFDMA",
            "OFDM",
            "OLED",
            "OOP",
            "OR",
            "OSR",
            "OTA-C",
            "OTA",
            "Ofman",
            "P2P",
            "PAL",
            "PAM",
            "PAPR",
            "PBGA",
            "PCA",
            "PCB",
            "PCI",
            "PCM",
            "PCMCIA",
            "PC",
            "PDF",
            "PDP",
            "PET",
            "PFA",
            "PHD",
            "PHY",
            "PIC",
            "PID",
            "PIN",
            "PLC",
            "PLL",
            "PMOS",
            "PN",
            "PON",
            "POTS",
            "PQFP",
            "PRPG",
            "PSK",
            "PSNR",
            "PSO",
            "PSRR",
            "PTL",
            "PV",
            "PWB",
            "PWM",
            "Parks-McClellan", // Only Parks will give lots of incorrect hits
            "Pb",
            "Planck",
            "PowerPC",
            "QAM",
            "QC-LDPC",
            "QCA",
            "QDI",
            "QFP",
            "QMF",
            "QNN",
            "QO",
            "QP",
            "QPSK",
            "QR",
            "QRD",
            "QRS",
            "QoS",
            "RAD",
            "RAKE",
            "RAM",
            "RBF",
            "RC",
            "RCS",
            "RFDAC",
            "RFE",
            "RFIC",
            "RFID",
            "RF",
            "RFS",
            "RISC",
            "RLC",
            "RLS",
            "RMS",
            "RNS",
            "ROM",
            "RRC",
            "RS",
            "RSA",
            "RT",
            "RTL",
            "RTOS",
            "RX",
            "RZ",
            "Rao",
            "Raphson",
            "Rayleigh",
            "Reed",
            "Remez",
            "Riccati",
            "SAR",
            "SAT",
            "SAW",
            "SC",
            "SDF",
            "SDH",
            "SDP",
            "SDRAM",
            "SDR",
            "SDRE",
            "SEU",
            "SFDR",
            "SIC",
            "SIMD",
            "SIMO",
            "SINAD",
            "SINR",
            "SINS",
            "SISO",
            "SLAM",
            "SMD",
            "SME",
            "SMS",
            "SNDR",
            "SNR",
            "SOCP",
            "SOI",
            "SONET",
            "SPS",
            "SPT",
            "SRAM",
            "SQL",
            "SQNR",
            "STBC",
            "SVD",
            "SVM",
            "SW",
            "Schottky",
            "SerDes",
            "Shannon",
            "SiC",
            "SiGe",
            "SoC",
            "SoP",
            "Solomon",
            "SystemC",
            "TCP",
            "TDC",
            "TDM",
            "TDMA",
            "TDS",
            "TETRA",
            "TFT",
            "THD",
            "THz",
            "TLM",
            "TLP",
            "TPG",
            "TQFP",
            "TSOP",
            "TSPC",
            "TTL",
            "TV",
            "TX",
            "Taylor",
            "Toeplitz",
            "Tukey",
            "UAV",
            "UHF",
            "UKF",
            "ULSI",
            "UML",
            "UMTS",
            "UPS",
            "USB",
            "USRP",
            "UV",
            "UWB",
            "V-BLAST",
            "VBLAST",
            "VBR",
            "VCO",
            "VDD",
            "VDSL",
            "VGA",
            "VHDL",
            "VHF",
            "VLIW",
            "VLSI",
            "VOD",
            "VQ",
            "VSB",
            "VTOL",
            "Vdd",
            "Verilog-AMS",
            "Verilog-A",
            "Verilog",
            "Viterbi",
            "VoD",
            "VoIP",
            "Volterra",
            "WCDMA",
            "WDF",
            "WDM",
            "WFTA",
            "WLAN",
            "WLS",
            "WPAN",
            "WSN",
            "WWW",
            "Wallace",
            "Watt",
            "Welch",
            "WiFi",
            "WiMAX",
            "Wiener",
            "Winograd",
            "XML",
            "XNOR",
            "XOR",
            "Xilinx",
            "ZCS",
            "ZF",
            "ZVS",
            "ZigBee",
            "Ziv",
            "xDSL"
    };

    // Weekdays and months
    public final String[] wordListDayMonth = new String[] {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    private final String[] wordListCountries = new String[] {
            "Andorra",
            "United Arab Emirates",
            "UAE",
            "Afghanistan",
            "Antigua and Barbuda",
            "Anguilla",
            "Albania",
            "Armenia",
            "Netherlands Antilles",
            "Angola",
            "Antarctica",
            "Argentina",
            "American Samoa",
            "Austria",
            "Australia",
            "Aruba",
            "Aland Islands",
            "Aland",
            "Azerbaijan",
            "Bosnia and Herzegovina",
            "Barbados",
            "Bangladesh",
            "Belgium",
            "Burkina Faso",
            "Bulgaria",
            "Bahrain",
            "Burundi",
            "Benin",
            "Saint Barthelemy",
            "Bermuda",
            "Brunei",
            "Bolivia",
            "British Antarctic Territory",
            "Brazil",
            "Bahamas",
            "Bhutan",
            "Bouvet Island",
            "Botswana",
            "Belarus",
            "Belize",
            "Canada",
            "Cocos Islands",
            "Keeling Islands",
            "Congo",
            "Congo - Kinshasa",
            "Central African Republic",
            "Congo - Brazzaville",
            "Democratic Republic of Congo",
            "Switzerland",
            "Cote d'Ivoire",
            "Cook Islands",
            "Chile",
            "Cameroon",
            "China",
            "Colombia",
            "Costa Rica",
            "Serbia and Montenegro",
            "Canton and Enderbury Islands",
            "Cuba",
            "Cape Verde",
            "Christmas Island",
            "Cyprus",
            "Czech Republic",
            "East Germany",
            "Germany",
            "Djibouti",
            "Denmark",
            "Dominica",
            "Dominican Republic",
            "Algeria",
            "Ecuador",
            "Estonia",
            "Egypt",
            "Western Sahara",
            "Eritrea",
            "Spain",
            "Ethiopia",
            "Finland",
            "Fiji",
            "Falkland Islands",
            "Micronesia",
            "Faroe Islands",
            "French Southern and Antarctic Territories",
            "France",
            "Metropolitan France",
            "Gabon",
            "United Kingdom",
            "Great Britain",
            "Britain",
            "England",
            "Wales",
            "Scotland",
            "Northern Ireland",
            "Grenada",
            "Georgia",
            "French Guiana",
            "Guernsey",
            "Ghana",
            "Gibraltar",
            "Greenland",
            "Gambia",
            "Guinea",
            "Guadeloupe",
            "Equatorial Guinea",
            "Greece",
            "South Georgia and the South Sandwich Islands",
            "Guatemala",
            "Guam",
            "Guinea-Bissau",
            "Guyana",
            "Hong Kong SAR China",
            "Heard Island and McDonald Islands",
            "Honduras",
            "Croatia",
            "Haiti",
            "Hungary",
            "Indonesia",
            "Ireland",
            "Israel",
            "Isle of Man",
            "India",
            "British Indian Ocean Territory",
            "Iraq",
            "Iran",
            "Iceland",
            "Italy",
            "Jersey",
            "Jamaica",
            "Jordan",
            "Japan",
            "Johnston Island",
            "Kenya",
            "Kyrgyzstan",
            "Cambodia",
            "Kiribati",
            "Comoros",
            "Saint Kitts and Nevis",
            "North Korea",
            "South Korea",
            "Kuwait",
            "Cayman Islands",
            "Kazakhstan",
            "Laos",
            "Lebanon",
            "Saint Lucia",
            "Liechtenstein",
            "Sri Lanka",
            "Liberia",
            "Lesotho",
            "Lithuania",
            "Luxembourg",
            "Latvia",
            "Libya",
            "Morocco",
            "Monaco",
            "Moldova",
            "Montenegro",
            "Saint Martin",
            "Madagascar",
            "Marshall Islands",
            "Midway Islands",
            "Macedonia",
            "Mali",
            "Myanmar",
            "Burma",
            "Mongolia",
            "Macau SAR China",
            "Northern Mariana Islands",
            "Martinique",
            "Mauritania",
            "Montserrat",
            "Malta",
            "Mauritius",
            "Maldives",
            "Malawi",
            "Mexico",
            "Malaysia",
            "Mozambique",
            "Namibia",
            "New Caledonia",
            "Niger",
            "Norfolk Island",
            "Nigeria",
            "Nicaragua",
            "Netherlands",
            "Norway",
            "Nepal",
            "Dronning Maud Land",
            "Nauru",
            "Neutral Zone",
            "Niue",
            "New Zealand",
            "Oman",
            "Panama",
            "Pacific Islands Trust Territory",
            "Peru",
            "French Polynesia",
            "Papua New Guinea",
            "Philippines",
            "Pakistan",
            "Poland",
            "Saint Pierre and Miquelon",
            "Pitcairn Islands",
            "Puerto Rico",
            "Palestinian Territories",
            "Portugal",
            "U.S. Miscellaneous Pacific Islands",
            "Palau",
            "Paraguay",
            "Panama Canal Zone",
            "Qatar",
            "Reunion",
            "Romania",
            "Serbia",
            "Russia",
            "Rwanda",
            "Saudi Arabia",
            "Solomon Islands",
            "Seychelles",
            "Sudan",
            "Sweden",
            "Singapore",
            "Saint Helena",
            "Slovenia",
            "Svalbard and Jan Mayen",
            "Svalbard",
            "Jan Mayen",
            "Slovakia",
            "Sierra Leone",
            "San Marino",
            "Senegal",
            "Somalia",
            "Suriname",
            "Sao Tome and Principe",
            "Union of Soviet Socialist Republics",
            "USSR",
            "El Salvador",
            "Syria",
            "Swaziland",
            "Turks and Caicos Islands",
            "Chad",
            "French Southern Territories",
            "Togo",
            "Thailand",
            "Tajikistan",
            "Tokelau",
            "Timor-Leste",
            "Turkmenistan",
            "Tunisia",
            "Tonga",
            "Turkey",
            "Trinidad and Tobago",
            "Tuvalu",
            "Taiwan",
            "Tanzania",
            "Ukraine",
            "Uganda",
            "U.S. Minor Outlying Islands",
            "United States",
            "USA",
            "Uruguay",
            "Uzbekistan",
            "Vatican City",
            "Saint Vincent and the Grenadines",
            "North Vietnam",
            "Venezuela",
            "British Virgin Islands",
            "U.S. Virgin Islands",
            "Vietnam",
            "Vanuatu",
            "Wallis and Futuna",
            "Wake Island",
            "Samoa",
            "People's Democratic Republic of Yemen",
            "Yemen",
            "Yugoslavia",
            "Mayotte",
            "South Africa",
            "Zambia",
            "Zimbabwe",
            "Asia",
            "Oceania",
            "Europe",
            "America",
            "Africa",
            "South America",
            "North America"
    };

    // List of all keyword lists
    private final String[][] allLists = new String[][] {
            wordListIEEEXplore,
            wordListDayMonth,
            wordListCountries
    };

    private final String[][] genericLists = new String[][] {
            wordListDayMonth,
            wordListCountries
    };


    public CaseKeeperList() {

    }

    /* Return all lists concatenated
     * Can be done faster once deciding on Java 6.0
     * see: http://stackoverflow.com/questions/80476/how-to-concatenate-two-arrays-in-java
     */
    public String[] getAll() {
        int lengh = 0;
        for (String[] array : allLists) {
            lengh += array.length;
        }
        String[] result = new String[lengh];
        int pos = 0;
        for (String[] array : allLists) {
            for (String element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }
}
