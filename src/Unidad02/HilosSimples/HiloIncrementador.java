package Unidad02.HilosSimples;

public class HiloIncrementador extends Thread{
    private Contador contador;

    public HiloIncrementador(String n, Contador c){
        setName(n);
        this.contador = c;
    }
    public void run(){
        for (int i = 0; i < 300; i++) {
            contador.incrementa();
            try{
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}
