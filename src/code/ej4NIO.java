package code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ej4NIO {
    public static void writeFiles() {
        Scanner sc = new Scanner(System.in);
        Path ruta = Path.of("src/resources/fileEj4.txt");
        String frase = "";

        if (Files.exists(ruta)) {
            try {
                Files.writeString(ruta, "");
                //problema a la hora de escribir las frases en el txt
                while (!frase.equals("fin")) {
                    System.out.println("Introduzca una frase (escribe fin para finalizar)");
                    frase = sc.nextLine();
                    if (!frase.equals("fin")) {
                        Files.writeString(ruta, frase+"\n", StandardOpenOption.APPEND);
                    }
                }
                Files.readAllLines(ruta).forEach((line)->{
                    System.out.println(line);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("El archivo introducido no existe");
        }
    }
}
