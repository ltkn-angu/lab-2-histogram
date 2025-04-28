import java.io.File;
import java.io.IOException;

public class DateiErstellen {
    public static void main(String[] args) {
        File datei = new File("ausgabe.txt");

        try {
            if (datei.createNewFile()) {
                System.out.println("Datei erstellt: " + datei.getName());
            } else {
                System.out.println("Datei existiert bereits.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Datei.");
            e.printStackTrace();
        }
    }
}
