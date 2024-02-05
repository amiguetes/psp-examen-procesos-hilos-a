package es.cipfpbatoi.dam.psp.examen;

public class CarreraDeTramposos {
    public static void main(String[] args) {

        Thread personajes[] = new Thread[10];
        System.out.println("¡Comienza la Gran Carrera Anime de los 80!");
        for (int i = 0; i < personajes.length; i++) {

            String nombreCorredor = obtenerNombrePersonaje(i);
            Personaje corredor = new Personaje();

            personajes[i] = new Thread(corredor, nombreCorredor);
            personajes[i].start();

        }

        Thread medusa = new Thread(new Medusa(personajes),"Medusa");
        medusa.start();

        for (int i = 0; i < personajes.length; i++) {

            try {
                personajes[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            medusa.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static String obtenerNombrePersonaje(int indice) {
        String[] nombresAnime80s = {
                "Lina Inverse",
                "Ranma Saotome",
                "Nadia",
                "Shinji Ikari ",
                "Rei Ayanami",
                "Krilín",
                "Chicho Terremoto",
                "Bulma",
                "Mark Lenders",
                "Light Yagami"
        };
        if (indice < nombresAnime80s.length) {
            return nombresAnime80s[indice];
        } else {
            return "Corredor" + String.format("%02d", indice);
        }
    }
}