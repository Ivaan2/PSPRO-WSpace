package pruebas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcesosDirectorios {
    public static void main(String[] args) {
        List<String> cmd = new ArrayList<String>();
        cmd.add("cmd");
        cmd.add("/C");
        cmd.add("echo");
        cmd.add("dirr");
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.environment();
        Process p;
        pb.redirectError(new File(""));
        int error = 0;
        try{
            p = pb.start();
            error = p.waitFor(); //Si devuelve distinto a 0 es correcto el lanzamiento
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((error!=0)?"Incorrecto":"Correcto");
    }
}
