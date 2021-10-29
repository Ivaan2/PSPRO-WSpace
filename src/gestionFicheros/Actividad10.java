package gestionFicheros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Actividad10 {

    public Actividad10() {
    }

    public static void main(String[] args) {
        System.out.println("Entrooooooooooooo");
        List<String> cmd = new ArrayList();
        cmd.add("cmd");
        cmd.add("/c");
        cmd.add("echo");
        cmd.add("%USERNAME%");
        //cmd.add("set");
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();

        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}