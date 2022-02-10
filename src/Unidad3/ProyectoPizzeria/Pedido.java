/**
 * 
 */
package Unidad3.ProyectoPizzeria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JESUS
 *
 */
public class Pedido {
	private List<Producto> productosPedido;

	public Pedido() {
		this.productosPedido = new ArrayList<>();
	}

	public List<Producto> getProductosPedido() {
		return productosPedido;
	}

	public void annadirProducto(Producto p){
		this.productosPedido.add(p);
	}

	@Override
	public String toString() {
		return "Pedidos -->" + productosPedido;
	}
}