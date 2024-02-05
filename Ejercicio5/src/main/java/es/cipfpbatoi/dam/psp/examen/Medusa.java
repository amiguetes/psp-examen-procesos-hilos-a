package es.cipfpbatoi.dam.psp.examen;

import java.util.Random;

public class Medusa implements Runnable{

    private Thread[] personajes;
    boolean isKrilinInterrupted = false;
    private Random random = new Random();

    public Medusa(Thread[] personajes) {
        this.personajes = personajes;
    }

    public void run() {
        for (int j = 0; j< personajes.length; j++) {

            int indiceInterrupcion = random.nextInt(personajes.length);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrumpido");
                return;
            }

            if (isKrilinInterrupted){
                if (!personajes[indiceInterrupcion].getName().equals("Krilín")) {
                    if( personajes[indiceInterrupcion].isAlive() && !personajes[indiceInterrupcion].isInterrupted()){
                        personajes[indiceInterrupcion].interrupt();
                        mensajeInterrumpido(personajes[indiceInterrupcion].getName());
                    }

                }
            } else {
                // Asegúrate de "interrumpir" a Krilín
                for (int i = 0; i < personajes.length; i++) {
                    if (personajes[i].getName().equals("Krilín")
                            && personajes[i].isAlive() && !personajes[i].isInterrupted()) {
                        personajes[i].interrupt();
                        mensajeInterrumpido(personajes[i].getName());
                        isKrilinInterrupted = true;
                        break;
                    }
                }
            }

        }
    }

    private void mensajeInterrumpido(String nombre){
        System.err.println("¡" + Thread.currentThread().getName() + ": ha convertido en piedra a " + nombre +"!");
    }
}
