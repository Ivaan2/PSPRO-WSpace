package pruebas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class ProcesoEcho {
    public static void main(String[] args) {
        String ruta = "src/salida_echo.txt";
        escribirFichero(ruta);
    }

    private static void escribirFichero(String ruta) {
        List<String> cmd = new ArrayList<String>();
        cmd.add("cmd");
        cmd.add("/C");
        cmd.add("echo");
        cmd.add("%PATH%");
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.environment();
        File f = new File(ruta);

        //Internamente calcula que el fichero se cree en caso de que no exista
        pb.redirectOutput(new File(ruta));
        try{
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
