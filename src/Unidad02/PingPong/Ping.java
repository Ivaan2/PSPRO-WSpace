package Unidad02.PingPong;

public class Ping extends Thread{
    String mensajePing;
    String mensajePong;
    boolean disponible;

    public Ping(){
        mensajePing = "PING";
        mensajePong = "PONG";
        disponible = true;
    }

    public synchronized void golpeoPing(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(mensajePing);
        disponible = false;
    }

    public synchronized void golpeoPong(){
        while(disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(mensajePong);
        disponible = true;
        notifyAll();
    }

    @Override
    public void run(){
        golpeoPing();
        golpeoPong();
    }
}
