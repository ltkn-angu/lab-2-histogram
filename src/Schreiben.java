import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Schreiben {
    public static void main(String[] args) {
        String text = args;
        //Integer integerObj = 42;
        //int primitivInt = 7;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ausgabe.txt"))) {
            writer.write(text);
            writer.newLine();  // neue Zeile
            //writer.write("Integer-Objekt: " + integerObj.toString());
            //writer.newLine();
            //writer.write("Primitive int: " + primitivInt); // automatische Umwandlung in String
            System.out.println("Erfolgreich geschrieben.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
