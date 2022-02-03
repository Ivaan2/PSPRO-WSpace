package Unidad02.HilosSimples;

public class HiloSimple extends Thread{

    private int c;
    private int hilo;

    public HiloSimple(int hilo){
        this.hilo = hilo;
        System.out.println("Craendo hilo: " + hilo);
    }

    @Override
    public void run() {
        c = 0;
        while(c < 5){
            System.out.println("Hilo: " + hilo + " c = " + c);
            c++;
        }
    }

    public static void main(String[] args) {
        HiloSimple hs = null;
        int i;
        for (i = 0; i < 3; i++) {
            hs = new HiloSimple(i+1);
            hs.start();
        }
        System.out.println(i + " HILOS CREADOS");
    }
}
