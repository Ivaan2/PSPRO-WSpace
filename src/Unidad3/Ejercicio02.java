package Unidad3;
/*
Usar los distintos constructores de la clase URL y pintar por pantalla los valores de los métodos vistos
 (los que devuelven int y String) para las direcciones siguientes:
 */

import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio02 {
    public static void main(String[] args) {
        URL url, url2;
        try {
            url = new URL("https://docs.oracle.com/javase/8/docs/api/");
            url2 = new URL("http://idocentic.website/mayusculas.php?FRASE=hola&HOLA=frase");
            mostrarDatos(url);
            System.out.println("\n");
            mostrarDatos(url2);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarDatos(URL url) {
        System.out.println("Authority: " + url.getAuthority() +
                "\nHost " + url.getHost() +
                "\nDefault Port " + url.getDefaultPort() +
                "\nPort " + url.getPort() +
                "\nUser info " + url.getUserInfo() +
                "\nPath " + url.getPath() +
                "\nQuery " + url.getQuery());
    }
}
