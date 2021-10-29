package gestionFicheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actividad11 {
    public static void main(String[] args) {
        String ruta = "gestionFicheros.Actividad10";
        List<String> cmd = new ArrayList<>();
        cmd.add("java");
        cmd.add(ruta);
        ProcessBuilder pb = new ProcessBuilder(cmd);
        System.out.println("-------------- " + Actividad10.class.getCanonicalName());
        System.out.println("-------------- " + Actividad10.class.getResource("").getPath());
        String classpath = "C:/Users/Alumno/IdeaProjects/PSPRO-WS/out/production/PSPRO-WS/gestionFicheros/";

        pb.environment().put("CLASSPATH", classpath);
        pb.inheritIO();

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
