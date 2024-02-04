package es.cipfpbatoi.dam.psp.examen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIMEOUT_SECONDS = 5;
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder(Arrays.asList(args));
        pb.redirectInput(new File("input.txt"));

        try {
            Process p = pb.start();
            int i = 0;

            if (!p.waitFor(TIMEOUT_SECONDS, TimeUnit.SECONDS)){
                System.err.println("El programa no ha finalizado en el tiempo esperado");
                p.destroy();
            }

            if ( 0 == p.waitFor() ){

                try(Scanner sc = new Scanner(p.getInputStream());
                    PrintWriter pw = new PrintWriter(new FileWriter("output.txt"),true);){

                    String linea;
                    while ( sc.hasNextLine()){
                        linea = sc.nextLine();

                        System.out.println(linea);
                        pw.printf("%02d.%s",++i,linea);
                        pw.println();
                    }

                }

            } else {

                try (Scanner sc = new Scanner(p.getErrorStream())){

                    while ( sc.hasNextLine()){
                        System.err.println(sc.nextLine());
                    }

                    System.exit(1);

                }

            }
        } catch (IOException|InterruptedException e) {
            System.err.println(e.getLocalizedMessage());
            System.exit(1);
        }

    }
}