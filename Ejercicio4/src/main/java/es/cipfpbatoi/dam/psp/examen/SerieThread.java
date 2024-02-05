package es.cipfpbatoi.dam.psp.examen;

public class SerieThread implements Runnable{

    private final int DISTANCIA_TOTAL_METROS;
    private final int PASO_METROS;
    private final int DESCANSO_MS;

    public SerieThread(int paso, int descanso, int distanciaTotal) {
        this.PASO_METROS = paso;
        this.DESCANSO_MS = descanso;
        this.DISTANCIA_TOTAL_METROS = distanciaTotal;
    }

    public SerieThread() {
        this(100, 200, 5000);
    }

    @Override
    public void run() {

        try {
            int distanciaRestante = DISTANCIA_TOTAL_METROS;
            while (distanciaRestante > 0) {
                distanciaRestante -= PASO_METROS;
                System.out.println(Thread.currentThread().getName() + ": " + distanciaRestante + "m para llegar");
                Thread.sleep(DESCANSO_MS);
            }
            System.out.println(Thread.currentThread().getName() + ": ¡Ha llegado a la meta!");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " fue interrumpido.");
        }

    }
}
