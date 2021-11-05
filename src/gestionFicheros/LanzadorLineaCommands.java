package gestionFicheros;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class LanzadorLineaCommands {
    public static void main(String[] args) {
        String classpath = LineaCommands.class.getClassLoader().getResource("").getPath();
        String ruta = LineaCommands.class.getCanonicalName();

        List<String> cmd = new ArrayList<String>();
        int a = 5;
        int b = 3;
        int r = a + b;

        cmd.add("java");
        cmd.add(ruta);
        cmd.add(String.valueOf(a));
        cmd.add("+");
        cmd.add(String.valueOf(b));
        cmd.add("=");
        cmd.add(String.valueOf(r));
        ProcessBuilder pb = new ProcessBuilder(cmd);

        pb.environment().put("CLASSPATH", classpath);
        pb.inheritIO();

        try{
            pb.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
