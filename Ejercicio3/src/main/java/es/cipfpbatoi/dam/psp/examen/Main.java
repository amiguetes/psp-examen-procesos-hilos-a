package es.cipfpbatoi.dam.psp.examen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DIRECTORY_PATH = "/";

    private static final HashMap<String,ArrayList<String>> directorios = new HashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        String[] nombresDeArchivos = listarArchivos(DIRECTORY_PATH);

        for (String nombre : nombresDeArchivos) {
            directorios.put(nombre,new ArrayList<>());
        }

        contarLineasPorArchivo(nombresDeArchivos,DIRECTORY_PATH);

        for (String key : directorios.keySet().stream().sorted().toList()){
            System.out.println(key);
            for (String subdir:directorios.get(key).stream().sorted().toList()) {
                System.out.println("\t"+subdir);
            }
        }

    }

    public static String[] listarArchivos(String directorio) throws IOException, InterruptedException {
        // En Unix/Linux/Mac
        ProcessBuilder lsPB = new ProcessBuilder("ls", directorio);
        // En Windows: ProcessBuilder lsPB = new ProcessBuilder("cmd", "/c", "dir", "/B", directorio);

        Process proceso = lsPB.start();

        List<String> nombresDeArchivos = new ArrayList<>();
        try (Scanner scanner = new Scanner(proceso.getInputStream())) {
            while (scanner.hasNextLine()) {
                nombresDeArchivos.add(scanner.nextLine());
            }
        }
        proceso.waitFor();
        return nombresDeArchivos.toArray(new String[0]);
    }

    public static void contarLineasPorArchivo(String[] nombresDeArchivos, String directorio) throws IOException {
        ProcessBuilder pb[] = new ProcessBuilder[nombresDeArchivos.length];
        Process process[] = new Process[nombresDeArchivos.length];

        for (int i = 0; i < pb.length; i++) {
            String archivoCompleto = directorio + File.separator + nombresDeArchivos[i];
            // En Unix/Linux/Mac
            pb[i] = new ProcessBuilder("ls", archivoCompleto);


            try {
                process[i] = pb[i].start();
                try (Scanner scanner = new Scanner(process[i].getInputStream())) {
                    while (scanner.hasNextLine()) {
                        directorios.get(nombresDeArchivos[i]).add(scanner.nextLine());
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Process p: process) {

            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}