import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharReader {

    private BufferedReader reader;

    public CharReader(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public int nextChar() throws IOException {
        int ch;
        while ((ch = reader.read()) != -1) {
            if (ch != '\r') { // \r ignorieren (z.B. bei Windows-Zeilenenden)
                return ch;
            }
        }
        return -1; // Ende der Datei
    }

    public void close() throws IOException {
        reader.close();
    }

    public static void main(String[] args) {
        try {
            CharReader charReader = new CharReader("beispiel.txt");
            Schreiben schreiben = new Schreiben();
            int ch;
            while ((ch = charReader.nextChar()) != -1) {
                String[] arguments = new String[]{"123"};
                DateiErstellen.main(arguments);

                String[] arguments2 = new String[]{"123"};
                Schreiben.main(arguments2);

                System.out.print((char) ch);
            }

            charReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
