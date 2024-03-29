package Unidad3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ejercicio01 {
    public static void main(String[] args) {
        {
            System.out.println("===========================================");
            System.out.println("SALIDA PARA LOCALHOST: ");
            try {
                String nombreMaquinaLocal = InetAddress.getLocalHost().getHostName();
                InetAddress dir;

                // LOCALHOST
                dir = InetAddress.getByName(nombreMaquinaLocal);
                pruebaMetodos(dir);//
                // URL www.google.es
                System.out.println("==========================================");
                System.out.println("SALIDA PARA UNA URL:");
                dir = InetAddress.getByName("www.google.es");
                pruebaMetodos(dir);
                // Array de tipo InetAddress con todas las direcciones IP
                // asignadas a google.es
                System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
                InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
                for (int i = 0; i < direcciones.length; i++)
                    System.out.println("\t\t" + direcciones[i].toString());
                System.out.println("==========================================");
            } catch (UnknownHostException el) {
                el.printStackTrace();
            }
        } // main

    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // USAMOS METODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toStringO: " + dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }
}