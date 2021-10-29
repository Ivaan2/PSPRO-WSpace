package pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class lanzarChrome {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        try (BufferedReader br = new BufferedReader(new FileReader("archivo"))){
            rt.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            String linea;
            int status;



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
