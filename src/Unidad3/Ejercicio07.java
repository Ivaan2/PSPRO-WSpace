package Unidad3;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
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
        int anyo, mes, dia;
        String link = "https://www.timeanddate.com/scripts/sunmap.php?iso=AAAAMMDDTHHMM";

        try {
            link = link.replace("AAAAMMDD", AAAAMMDD.toString());
            link = link.replace("HHMM", HHMM.toString());
            url = new URL("https://www.timeanddate.com/scripts/sunmap.php?iso=200210101010");
            urlCon = url.openConnection();

            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            String ip = null;
            FileWriter fw = new FileWriter("imagen.jpg");

            if ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
