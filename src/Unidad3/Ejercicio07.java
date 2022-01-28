package Unidad3;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//er con el URL
//https://www.timeanddate.com/scripts/sunmap.php?iso=AAAAMMDDTHHMM
//La parte variable

/*
Crea un programa que, dada una fecha en formato AAAAMMDD, y una hora en formato
HHMM, pasados por línea de comandos, descargue un fichero con el mapa de la luz solar en la
Tierra para la fecha y hora dadas.
 */
public class Ejercicio07 {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        Date AAAAMMDD = new Date(2000, 10, 10);
        DateFormat HHMM = new SimpleDateFormat("HHmm");
        String anyo, mes, dia, hora, minutos;
        String link = "https://www.timeanddate.com/scripts/sunmap.php?iso=AAAAMMDDHHMM";

        try {
            anyo = solicitarAnyo();
            mes = "08";
            dia = "16";
            hora = "12";
            minutos = "45";

            link = link.replace("AAAAMMDDHHMM", anyo + mes + dia + hora + minutos);
            System.out.println("Link : " + link);
            url = new URL(link);
            urlCon = url.openConnection();


            InputStream inputStream = urlCon.getInputStream();
            String inputLine;
            FileOutputStream fos = new FileOutputStream("imagenMapa.jpeg");
            int TAM = 1024;
            byte[] buffer = new byte[TAM];
            BufferedInputStream bin = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int cantidadBytes = 0;

            System.out.println(url);
            while ((cantidadBytes = bin.read(buffer, 0 , TAM)) != -1) {
                bos.write(buffer, 0 , cantidadBytes);
            }
            bos.close();
            bin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solicitarAnyo() {
        String anyo = "2";
        System.out.println("Introduzca un año:");
        reutrn anyo;
    }
}
