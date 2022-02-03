package Unidad3;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class probandoInputStream {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        InputStream is;

        try {
            url = new URL("http://www.iescristobaldemonroy.es/wordpress/");
            is = url.openStream();
            //Tengo el flujo de bytes que quiero pasar a caracteres
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea = null;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            url = new URL("http://www.iescristobaldemonroy.es/wordpress");
            urlCon = url.openConnection();
            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
