package Unidad02.HilosSimples;

public class HiloSimple2 implements Runnable {

    public void main(String[] args){
        new HiloSimple(3);
        run();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("En el hilo...");
        }
    }


}
