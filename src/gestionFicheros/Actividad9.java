package gestionFicheros;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actividad9 {
    public Actividad9() {
    }

    public static void main(String[] args) {
        List<String> cmd = new ArrayList();
        cmd.add("cmd");
        cmd.add("/c");
        cmd.add("dir src");
        ProcessBuilder pb = new ProcessBuilder(cmd);
        File fInput = new File("src/archivos/salidaActividad9.txt");
        File fError = new File("src/archivos/errorActividad9.txt");
        pb.redirectInput(fInput);
        pb.redirectError(fError);

        try {
            fInput.createNewFile();
            fError.createNewFile();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        Process p = null;

        try {
            p = pb.start();
            System.out.println(p);
            int status = p.waitFor();
            if (status != 0) {
                System.out.println("waitFor --> -1. Ejecución erronea.");
            } else {
                System.out.println("waitFor --> 0. Ejecución correcta.");
            }
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }
}
