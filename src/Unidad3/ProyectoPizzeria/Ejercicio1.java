package Unidad3.ProyectoPizzeria;

/*
    @author Ivan
IMORMEL2002
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        registrarDatos();
    }

    private static void registrarDatos() {
        //1
        String nombreTienda1 = "Establecimiento%20uno";
        String nombreTienda2 = "Establecimiento%20dos";
        String nombreTienda3 = "Establecimiento%20tres";
        int idTienda1, idTienda2, idTienda3;
        idTienda1 = ClienteServicio.nuevoEstablecimiento(nombreTienda1);
        idTienda2 = ClienteServicio.nuevoEstablecimiento(nombreTienda2);
        idTienda3 = ClienteServicio.nuevoEstablecimiento(nombreTienda3);

        //2
        int idPedido1, idPedido2, idPedido3, idPedido4;
        idPedido1 = ClienteServicio.nuevoPedido(idTienda1);
        idPedido2 = ClienteServicio.nuevoPedido(idTienda1);

        idPedido3 = ClienteServicio.nuevoPedido(idTienda2);

        idPedido4 = ClienteServicio.nuevoPedido(idTienda3);
        //3
        String cod_productoCarbonara = "CARBONARA";
        String cod_productoBBQ = "BARBACOA";
        String cod_productoCasa = "CASA";
        String cod_productoMargarita = "MARGARITA";
        String cod_productoXQueso = "EXTRAQUESO";
        String cod_producto4Estaciones = "4ESTACION";
        ClienteServicio.annadirProducto(idTienda1, idPedido1, cod_productoCarbonara);
        ClienteServicio.annadirProducto(idTienda1, idPedido1, cod_productoCarbonara);
        ClienteServicio.annadirProducto(idTienda1, idPedido1, cod_productoCarbonara);
        ClienteServicio.annadirProducto(idTienda1, idPedido1, cod_productoBBQ);
        ClienteServicio.annadirProducto(idTienda1, idPedido1, cod_productoBBQ);
        ClienteServicio.annadirProducto(idTienda1, idPedido1, cod_productoCasa);

        ClienteServicio.annadirProducto(idTienda1, idPedido2, cod_productoMargarita);

        ClienteServicio.annadirProducto(idTienda2, idPedido3, cod_productoXQueso);
        ClienteServicio.annadirProducto(idTienda2, idPedido3, cod_producto4Estaciones);

        //4
        ClienteServicio.consultarProductos();
    }
}
