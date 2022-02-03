package Unidad3;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Ejercicio06 {
    private static int contador = 0;
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;

        try {
            url = new URL("http://idocentic.website/servicios_para_explotar/obtener_ip.php");
            urlCon = url.openConnection();

            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            String ip = null;

             if ((inputLine = in.readLine()) != null) {
                ip = inputLine;
             }
            System.out.println("La ip es: " + ip);

            String nombreMaquinaLocal = InetAddress.getLocalHost().getHostName();
            InetAddress dir = InetAddress.getByName(nombreMaquinaLocal);;
            System.out.println("\tMetodo getHostName(): " + dir.getHostName());
            System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
            System.out.println("\tMetodo toStringO: " + dir.toString());
            System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
