/**
 * 
 */
package Unidad3.ProyectoPizzeria;

/**
 * @author JESUS
 *
 */
public class Producto {
	private String codProducto;
	private String nombreProducto;

	public Producto(String codProducto, String nombreProducto) {
		this.codProducto = codProducto;
		this.nombreProducto = nombreProducto;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	@Override
	public String toString() {
		return this.getNombreProducto();
	}
}
