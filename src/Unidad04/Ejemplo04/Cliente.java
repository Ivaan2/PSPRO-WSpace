package Unidad04.Ejemplo04;

import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.util.Scanner;


public class Cliente {
    private Socket socket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    private static Scanner teclado = new Scanner(System.in);
    final String DESPEDIDA = "ADIÓS";



    public void conectarConServidor(String ip, int puerto) {
        Thread hilo = new Thread(() -> {
            try {
                socket = new Socket(ip, puerto);
                System.out.println("Estableciendo conexión con :" + socket.getInetAddress().getHostName());


                bufferDeEntrada = new DataInputStream(socket.getInputStream());
                bufferDeSalida = new DataOutputStream(socket.getOutputStream());
                bufferDeSalida.flush();


                String cadena;
                do {
                    cadena = bufferDeEntrada.readUTF();
                    //He cambiado cosas
                    System.out.print("\n[Servidor] (" + obtenerHora() + ") --> " + cadena + "\n[Usted] --> ");
                } while (!(cadena).equalsIgnoreCase(DESPEDIDA));

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Conexión terminada");
            } finally {
                try {
                    bufferDeEntrada.close();
                    bufferDeSalida.close();
                    socket.close();
                    System.out.println("Conexión terminada");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        hilo.start();
    }

    private String obtenerHora(){
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        return h + ":" + min + ":" + s;
    }

    public void mandarMensaje() {
        String entrada;
        while (true) {
            try {
                System.out.print("\n[Usted] (" + obtenerHora() + ") --> ");
                entrada = teclado.nextLine();
                bufferDeSalida.writeUTF(entrada);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] argumentos) {
        Cliente cliente = new Cliente();
        String ip = "localhost";
        int puerto = 9999;
        cliente.conectarConServidor(ip, puerto);
        cliente.mandarMensaje();
    }
}
