package gestionFicheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actividad11 {
    public static void main(String[] args) {
        String ruta = ruta = Actividad10.class.getCanonicalName();
        String classpath = Actividad10.class.getClassLoader().getResource("").getPath();
        List<String> cmd = new ArrayList<>();
        cmd.add("java");
        cmd.add(ruta);
        ProcessBuilder pb = new ProcessBuilder(cmd);

        pb.environment().put("CLASSPATH", classpath);
        pb.inheritIO();

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
