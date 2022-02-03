package pruebas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanzamientoDesdeClase {
    public static void main(String[] args) {
        String ruta = ProcesoEcho.class.getCanonicalName();
        List<String> cmd = new ArrayList<String>();
        cmd.add("java");
        cmd.add(ruta);
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.environment().put("CLASSPATH",ProcesoEcho.class.getClassLoader().getResource("").getPath());
        pb.inheritIO();

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
