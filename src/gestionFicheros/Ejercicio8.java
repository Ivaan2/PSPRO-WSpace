//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package gestionFicheros;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Ejercicio8 {
    public Ejercicio8() {
    }

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        Map<String, String> map = pb.environment();
        Iterator var4 = map.entrySet().iterator();

        while(var4.hasNext()) {
            Entry<String, String> entry = (Entry)var4.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}