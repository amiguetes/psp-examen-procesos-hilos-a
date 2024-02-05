package es.cipfpbatoi.dam.psp.examen;

public class CarreraDeSeries {
    public static void main(String[] args) {

        Thread series[] = new Thread[10];
        System.out.println("¡Comienza la Gran Carrera Anime de los 80!");
        for (int i = 0; i < series.length; i++) {

            String nombreCorredor = obtenerNombreAnime80s(i);
            SerieThread corredor = new SerieThread();

            series[i] = new Thread(corredor, nombreCorredor);
            series[i].start();

        }

        for (int i = 0; i < series.length; i++) {

            try {
                series[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private static String obtenerNombreAnime80s(int indice) {
        String[] nombresAnime80s = {
                "Bola de Drac",
                "Caballeros del Zodíaco",
                "Transformers",
                "Robotech",
                "Akira",
                "Ghost in the Shell",
                "Neon Genesis Evangelion",
                "Mobile Suit Gundam",
                "Cobra: Space Adventure",
                "Oliver y Benji"
        };
        if (indice < nombresAnime80s.length) {
            return nombresAnime80s[indice];
        } else {
            return "Corredor" + String.format("%02d", indice);
        }
    }
}