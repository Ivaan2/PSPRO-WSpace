package Unidad04.Ejemplo04;

import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.util.Scanner;



public class Servidor {

    private Socket cliente;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    private static Scanner sc = new Scanner(System.in);
    final String DESPEDIDA = "ADIÓS";


    public void escribirMensaje() {
        while (true) {
            try {
                System.out.print("[Usted] (" + obtenerHora() + ") --> ");
                String msj = sc.nextLine();
                bufferDeSalida.writeUTF(msj);
                //bufferDeSalida.flush();
            } catch (IOException e) {
                System.out.println("Error en enviar(): " + e.getMessage());
            }
        }
    }

    private String obtenerHora(){
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        return h + ":" + min + ":" + s;
    }


    public void conectarCliente(int puerto) {
        Thread hilo = new Thread(() -> {
            while (true) {
                try {
                    ServerSocket serverSocket = new ServerSocket(puerto);
                    System.out.println("MONROY CHAT");
                    System.out.println("Conexión con en el puerto " + puerto);
                    cliente = serverSocket.accept();
                    System.out.println("Estableciendo conexión con: " + cliente.getInetAddress().getHostName() + "\n\t");

                    System.out.print("[Usted] (" + obtenerHora() + ") --> ");

                    bufferDeEntrada = new DataInputStream(cliente.getInputStream());
                    bufferDeSalida = new DataOutputStream(cliente.getOutputStream());
                    bufferDeSalida.flush();

                    String cadena;

                    do {
                        cadena = bufferDeEntrada.readUTF();
                        System.out.println("\n[Cliente] (" + obtenerHora() + ") --> " + cadena);
                        System.out.print("\n[Usted] --> ");
                    } while (!(cadena).equalsIgnoreCase(DESPEDIDA));

                } catch (IOException e) {
                    System.out.println("Conexión terminada");
                } finally {
                    try {
                        bufferDeEntrada.close();
                        bufferDeSalida.close();
                        cliente.close();
                        System.out.println("Conexión terminada");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) throws IOException {
        Servidor server = new Servidor();

        int puerto = 9999;
        server.conectarCliente(puerto);
        server.escribirMensaje();
    }
}