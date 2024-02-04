package es.cipfpbatoi.dam.psp.examen;

import java.util.Scanner;

public class SumMe {
    public static void main(String[] args) {

        double total = 0;

        System.out.println("Bienvenido a SumMe, este código leerá los valores introducidos en la terminal a " +
                "a razón de uno por línea, en caso de introducir un valor incorrecto, el resultado se mostrará por la " +
                " salida de error");

        try(Scanner sc = new Scanner(System.in)){

            String linea;

            while (!(linea = sc.nextLine()).equalsIgnoreCase("stop")){
                try {
                    total += Double.parseDouble(linea);
                    System.out.println(total);
                } catch (NumberFormatException e){
                    System.err.println("Error en la Entrada: "+linea);
                }
            }

            System.out.println("Total acumulado: " + total);
            System.out.println("Finalizando SumMe...");

        }

        System.exit(0);

    }
}