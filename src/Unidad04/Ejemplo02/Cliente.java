package Unidad04.Ejemplo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {
        try {
            String Host = "localhost";
            int Puerto = 9999;// puerto remoto
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            Socket cliente;
            cliente = new Socket(Host, Puerto);

            // CREO FLUJO DE SALIDA AL SERVIDOR
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            // ENVIO UN SALUDO AL SERVIDOR
            flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

            // CREO FLUJO DE ENTRADA AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            // EL SERVIDOR ME ENVIA UN MENSAJE
            System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());
            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
