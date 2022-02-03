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
        List<String> cmd2 = new ArrayList<>();
        cmd.add("cmd");
        cmd.add("/c");
        cmd.add("echo");
        cmd.add("%USERNAME%" + "\n");

        cmd2.add("cmd");
        cmd2.add("/c");
        cmd2.add("SET");
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();

        ProcessBuilder pb2 = new ProcessBuilder(cmd2);
        pb2.inheritIO();

        try {
            pb.start();
            System.out.println("\n");
            pb2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}