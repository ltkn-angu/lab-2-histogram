import java.io.*;

public class Histogram {

    /**
     * Zählt die Häufigkeiten der Buchstaben A–Z im Reader
     * @param reader liefert Zeichen
     * @return Array der Länge 26 mit den Häufigkeiten
     */
    public static int[] count(Reader reader) throws IOException {
        int[] counts = new int[26];
        try (BufferedReader br = new BufferedReader(reader)) {
            int ch;
            while ((ch = br.read()) != -1) {
                if (ch == '\r' || ch == '\n') continue;
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    if (ch >= 'a' && ch <= 'z') {
                        ch = ch - ('a' - 'A');
                    }
                    counts[ch - 'A']++;
                }
            }
        }
        return counts;
    }

    /**
     * Ermittelt den am häufigsten vorkommenden Buchstaben.
     * @param counts Häufigkeits-Array der Buchstaben A–Z.
     * @return Der Buchstabe mit der höchsten Häufigkeit.
     */
    public static char mostFrequent(int[] counts) {
        int max = -1;
        char letter = 'A';
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                letter = (char) ('A' + i);
            }
        }
        return letter;
    }

    /**
     * Schreibt das Histogramm in eine Ausgabedatei im Format "Buchstabe: *****".
     * @param counts Häufigkeits-Array.
     * @param outputFile Pfad der Ausgabedatei.
     */
    public static void writeHistogram(int[] counts, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < counts.length; i++) {
                writer.write((char) ('A' + i) + ": ");
                for (int j = 0; j < counts[i]; j++) {
                    writer.write('*');
                }
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        String inputFile;
        String outputFile;

        if (args.length == 0) {
            System.out.println("Keine Programmargumente übergeben. Verwende Standarddateien:");
            System.out.println("  Eingabe: input.txt");
            System.out.println("  Ausgabe: histogram.txt");
            inputFile = "input.txt";
            outputFile = "histogram.txt";
        } else if (args.length == 1) {
            inputFile = args[0];
            outputFile = "histogram.txt";
        } else {
            inputFile = args[0];
            outputFile = args[1];
        }

        try {
            int[] counts = count(new FileReader(inputFile));
            writeHistogram(counts, outputFile);
            System.out.println("Histogramm geschrieben nach " + outputFile);
            System.out.println("Häufigster Buchstabe: " + mostFrequent(counts));
        } catch (IOException e) {
            System.err.println("Fehler bei Dateioperationen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
