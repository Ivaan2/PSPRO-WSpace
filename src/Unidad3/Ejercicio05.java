package Unidad3;

/*
Se tiene definido un endpoint en la siguiente URL: http://idecentic.website/. El
nombre del servicio es mayusculas.php.
Este servicio se encarga de pasar a mayiscilas la ftase recibida en el parametro FRASE del WS.
Además, separará en lñíneas cada una de las palabras recibidas indicando en la primera línea el número de palabras.
Crear una clase Java que conecte con el servicio y envie como parametro una frase. Como resultado debe pintar por
pantalla la frase en mayusculas obtenida de la invocación del servicio e indicar entre paréntesis el número de palabras
que contiene. Es decir. PAra la llamada http://idecentic.website/mayusculas.php?FRASE=hola%20mundo
La respuesat del servicio ha de ser:
2
HOLA
MUNDO
Y la salida por consola "HOLA MUNDO (Esta frase tiene dos palabras)"
 */

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        String FRASE = null;

        try {
            FRASE = solicitarCadena().toUpperCase();
            FRASE = FRASE.replace(" ", "%20");
            url = new URL("http://idocentic.website/mayusculas.php?FRASE=" + FRASE);
            urlCon = url.openConnection();
            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            String[] palabras;

            inputLine = in.readLine();
            palabras = inputLine.split("<br/>");

            for (String p: palabras) {
                System.out.println(p);
            }

            for (int i = 0; i < palabras.length; i++){
                if(i != 0){
                    System.out.print(palabras[i] + " ");
                }
            }

            System.out.println("Esta frase tiene " + palabras[0] + " palabras");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String solicitarCadena() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase: ");
        return sc.nextLine();
    }
}
