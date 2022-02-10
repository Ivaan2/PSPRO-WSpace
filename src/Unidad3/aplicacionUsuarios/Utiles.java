package Unidad3.aplicacionUsuarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Utiles {
    protected static final String link = "http://idocentic.website/servicios_para_explotar/aplicacion_usuarios/";

    public void borrar_usuarios(String u){
        URL url;
        URLConnection urlCon;
        int idTienda = 0;
        try {
            url = new URL(link + "borraUsuario.php?USUARIO=" + u);
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String input;

            while( (input = br.readLine()) != null ){
                System.out.println(input);
                idTienda = Integer.parseInt(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void comprueba_usuario(String u){
        URL url;
        URLConnection urlCon;
        int idTienda = 0;
        try {
            url = new URL(link + "compruebaUsuario.php?USUARIO=" + u);
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String input;

            while( (input = br.readLine()) != null ){
                System.out.println(input);
                idTienda = Integer.parseInt(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void inserta_usuario(String nombre){
        URL url;
        URLConnection urlCon;
        int idTienda = 0;
        try {
            url = new URL(link + "insertaUsuario.php?NOMBRE=" + nombre);
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String input;

            while( (input = br.readLine()) != null ){
                System.out.println(input);
                idTienda = Integer.parseInt(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrar_aplicacion(String u){
        URL url;
        URLConnection urlCon;
        int idTienda = 0;
        try {
            url = new URL(link + "borraUsuario.php");
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String input;

            while( (input = br.readLine()) != null ){
                System.out.println(input);
                idTienda = Integer.parseInt(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
