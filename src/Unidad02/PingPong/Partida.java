package Unidad02.PingPong;

import ejercicio1.Cliente;
import ejercicio1.Taxi;

public class Partida {
    public static void main(String[] args) {
        boolean turnoPing = true;
        Taxi taxi = new Taxi();

        Runnable ping = new Ping();
        Runnable pong = new Ping ();

        Thread tping = new Thread(ping);
        Thread tpong = new Thread(pong);

        tping.start();
        tpong.start();
    }
}
