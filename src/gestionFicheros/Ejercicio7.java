//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package gestionFicheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio7 {
    public Ejercicio7() {
    }

    public static void main(String[] args) {
        String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String parametro = "iescristobaldemonroy.es";
        List<String> lista = new ArrayList();
        lista.add(rutaChrome);
        lista.add(parametro);

        try {
            ProcessBuilder pb = new ProcessBuilder(lista);
            pb.start();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
}
