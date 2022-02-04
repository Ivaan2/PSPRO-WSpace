package Unidad3.ProyectoPizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ClienteServicio {
    protected static final String link = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/";
    public static String cod_autor = "IMORMEL2002";

    public static int nuevoEstablecimiento(String nombreEstablecimiento) {
        URL url;
        URLConnection urlCon;
        int idTienda = 0;
        try {
            url = new URL(link + "inicializaPizzeria.php?COD_AUTOR=" + cod_autor +"&NOMBRE_TIENDA="+nombreEstablecimiento);
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
        return idTienda;
    }

    public static int nuevoPedido(int idTienda) {
        URL url;
        URLConnection urlCon;
        int idPedido = 0;
        try {
            url = new URL(link + "insertaPedido.php?COD_AUTOR=" + cod_autor + "&ID_TIENDA="+ idTienda);
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while( (inputLine = br.readLine()) != null){
                System.out.println(inputLine);
                idPedido = Integer.parseInt(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idPedido;
    }

    public static void annadirProducto(int idTienda, int idPedido, String cod_producto) {
        URL url;
        URLConnection urlCon;
        try {
            url = new URL(link + "insertaProductoPedido.php?COD_AUTOR=" + cod_autor + "&ID_TIENDA=" + idTienda + "&ID_PEDIDO=" + idPedido + "&COD_PRODUCTO=" + cod_producto);
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while( (inputLine = br.readLine()) != null){
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void consultarProductos() {
        URL url;
        URLConnection urlCon;
        try {
            url = new URL(link + "consultaProductos.php");
            urlCon = url.openConnection();
            InputStream is = urlCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while( (inputLine = br.readLine()) != null){
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
