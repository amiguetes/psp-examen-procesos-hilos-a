// ProcesoA.java
package es.cipfpbatoi.dam.psp.examen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("java","-jar","out/artifacts/SumMe_jar/SumMe.jar");
        pb.redirectErrorStream(true);
        Process process = pb.start();

        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(process.getOutputStream()), true);
             Scanner pr = new Scanner(process.getInputStream());
             Scanner scanner = new Scanner(System.in);){

            System.out.println("Hola, introduce un número. Escribe 'stop' para finalizar.");

            pr.nextLine(); //Descartamos el mensaje de bienvenida

            String userInput;
            while (true) {
                userInput = scanner.nextLine(); // Leer entrada del usuario

                pw.println(userInput); // Enviar la entrada al Proceso B

                if ("stop".equalsIgnoreCase(userInput)) {
                    process.destroy();
                    break; // Salir del bucle si el usuario escribe 'stop'
                }

                System.out.println("La suma de los números es: " + pr.nextLine());
            }

            int exitValue = process.waitFor();
            System.out.println("Proceso SumaMe finalizado con código: " + exitValue);

        }

        System.exit(0 );

    }
}
