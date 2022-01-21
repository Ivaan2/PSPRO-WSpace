package Unidad3;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Ejercicio06 {
    private static int contador = 0;
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        int PARAM_A, PARAM_B;


        try {
            PARAM_A = solicitarNumero();
            PARAM_B = solicitarNumero();
            url = new URL("http://idocentic.website/servicios_para_explotar/suma_parametros.php?PARAM_A=" + PARAM_A + "&PARAM_B=" + PARAM_B);
            urlCon = url.openConnection();
            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;

             while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine.replace("<resultado>", ""));
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solicitarNumero() {
        Scanner sc = new Scanner(System.in);
        //Operador ternario para ahorrar codigo y utilizar el mismo metodo para pedir los dos valores de la operacion
        String resultado = (contador==0)?"Introduce el primer parametro: ":"Introduce el segundo parametro: ";
        System.out.println(resultado);
        contador++;
        if (contador == 2) {contador = 0;};
        return Integer.parseInt(sc.nextLine());
    }
}
