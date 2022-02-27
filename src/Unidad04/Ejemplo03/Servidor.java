package Unidad04.Ejemplo03;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int numeroPuerto = 9999;// Puerto
        ServerSocket servidor;
        try {
            servidor = new ServerSocket(numeroPuerto);
            System.out.println("Esperando al cliente ");
            Socket cliente = servidor.accept();

            // Se prepara un flujo de salida para objetos
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

            // Se prepara un objeto y se envia
            Usuario usu = new Usuario("user", "password");
            outObjeto.writeObject(usu); //enviando objeto
            System.out.println("Envio: " + usu.getUsuario() +"*"+ usu.getPassword());

            // Se obtiene un stream para leer objetos
            ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
            Usuario dato = (Usuario) inObjeto.readObject();

            System.out.println("Recibo: "+dato.getUsuario()+"*"+dato.getUsuario());

            // CERRAR STREAMS Y SOCKETS
            outObjeto.close();
            inObjeto.close();
            cliente.close ();
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
