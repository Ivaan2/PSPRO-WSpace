package Unidad3.ProyectoPizzeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Ejercicio2 {

    private static final String cod_productoCarbonara = "CARBONARA";
    private static final String cod_productoBBQ = "BARBACOA";
    private static final String cod_productoCasa = "CASA";
    private static final String cod_productoMargarita = "MARGARITA";
    private static final String cod_productoXQueso = "EXTRAQUESO";
    private static final String cod_producto4Estaciones = "4ESTACION";
    private static final String nombreTienda = "A la carta";


    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ClienteServicio cs = new ClienteServicio();
        Tienda tienda = crearTienda(cs);
        registroPedido(tienda);
    }

    private static Tienda crearTienda(ClienteServicio cs) {
        return new Tienda(cs, nombreTienda);
    }

    private static void registroPedido(Tienda t) {
        System.out.println("Pizzería \""+ nombreTienda + "\"");
        if(preguntarRegistroPedido().equalsIgnoreCase("s")){
            System.out.println("Iniciando su pedido.");
            Pedido pedido = crearPedido();
            solicitarArticulos(pedido, t);
        }else{
            System.out.println("No se registran pedidos.");
        }
    }

    private static void solicitarArticulos(Pedido pedido, Tienda t) {
        int numero;
        String[] listaPizzas = {cod_producto4Estaciones, cod_productoBBQ, cod_productoCarbonara, cod_productoMargarita, cod_productoXQueso, cod_productoCasa};
        String[] nombrePizzas = {"Cuatro Estaciones", "Barbacoa", "Carbonara", "Margarita", "Extra de queso", "De la casa"};

        annadirProducto(pedido, listaPizzas, nombrePizzas);
        while(solicitarFin().equalsIgnoreCase("N")){
            annadirProducto(pedido, listaPizzas, nombrePizzas);
        }
        mostrarPedido(pedido, t);
    }

    private static void annadirProducto(Pedido pedido, String[] listaPizzas, String[] nombrePizzas) {
        int numero;
        numero = solicitarPizza();
        String codPizza = listaPizzas[numero-1];
        String nombrePizza = nombrePizzas[numero-1].replaceAll(" ", "%20");
        Producto p = crearProducto(codPizza, nombrePizza);
        pedido.annadirProducto(p);
    }

    private static Pedido crearPedido() {
        return new Pedido();
    }

    private static Producto crearProducto(String codPizza, String nombrePizza) {
        return new Producto(codPizza, nombrePizza);
    }

    private static void mostrarPedido(Pedido p, Tienda t) {
        System.out.println("Pedido pendiente de registrar.");
        System.out.println(p);
        registraPedido(p, t);
    }

    private static void registraPedido(Pedido p, Tienda t) {
        String r;
        do {
            System.out.println("¿Registrar pedido? (S/N)");
            r = sc.nextLine();
        }while(!r.equalsIgnoreCase("s") && !r.equalsIgnoreCase("n"));
        if(r.equalsIgnoreCase("s")){
            procesarPedido(p, t);
        }
    }

    private static void procesarPedido(Pedido p, Tienda t) {
        inicializarPizzeria(t);
        insertarPedido(t, p);
    }

    private static void insertarPedido(Tienda t, Pedido p) {
        int idPedido = t.cs.nuevoPedido(t.getIdTienda());
        for (int i = 0; i < p.getProductosPedido().size(); i++) {
            t.getCs().annadirProducto(t.getIdTienda(), idPedido, p.getProductosPedido().get(i).getCodProducto());
        }
    }

    private static void insertarProductoAPedido(int idPedido, Tienda t, Producto p) {
        t.getCs().annadirProducto(t.getIdTienda(), idPedido, p.getCodProducto());
    }

    private static void inicializarPizzeria(Tienda t) {
        int id = t.getCs().nuevoEstablecimiento(t.getNombreEstablecimiento());
        t.setIdTienda(id);
    }

    private static String solicitarFin() {
        String r;
        do{
            System.out.println("¿Finalizar pedido? (S/N)");
            r = sc.nextLine();
        }while(!r.equalsIgnoreCase("S") && !r.equalsIgnoreCase("N"));
        return r;
    }

    private static int solicitarPizza() {
        int n;
        do {
            System.out.println("¿Qué artículos desea? " +
                    "1. Cuatro Estaciones" +
                    "2. Barbacoa" +
                    "3. Carbonara" +
                    "4. Margarita" +
                    "5. Extra de Queso" +
                    "6. De la Casa");
            n = Integer.parseInt(sc.nextLine());
        }while(n < 1 || n > 6);
        return n;
    }

    private static String preguntarRegistroPedido() {
        String r;
        do {
            System.out.println("¿Desea registrar un pedido? (s/n)");
            r = sc.nextLine();
        }while(!r.equalsIgnoreCase("s") && !r.equalsIgnoreCase("n"));
        return r;
    }
}

