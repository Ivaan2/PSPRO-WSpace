package Unidad3;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Ejercicio04 {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        try {
            url = new URL("https://github.com/jesusrodenas/PROSE/tree/master/PSP/src/psp/UD03/progcomred");
            urlCon = url.openConnection();
            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;

            try(BufferedWriter bw = new BufferedWriter(new FileWriter("pruebaGit.html"))) {
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                    bw.write(inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
