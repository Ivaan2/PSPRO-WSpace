package gestionFicheros;

import java.io.IOException;
import java.util.ArrayList;

public class LineaCommands {
    public static void main(String[] args) {
        String ruta = LineaCommands.class.getClassLoader().getResource("").getPath();
        String name = LineaCommands.class.getCanonicalName();
        System.out.println(ruta);
        System.out.println(name);
        System.out.println("Tengo " + args.length + " argumentos");
        for (int i = 0; i < args.length; i++){
            System.out.println("Argumento " + (i+1) + "º: " + args[i]);
        }
    }
}
