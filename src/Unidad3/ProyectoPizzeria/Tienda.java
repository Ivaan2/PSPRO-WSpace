/**
 * 
 */
package Unidad3.ProyectoPizzeria;


/**
 * @author JESUS
 *
 */
public class Tienda {
	private String nombreEstablecimiento;
	private Integer idTienda;
	public ClienteServicio cs;

	public Tienda(ClienteServicio cs, String nombreEstablecimiento) {
		this.cs = cs;
		this.nombreEstablecimiento = nombreEstablecimiento.replaceAll(" ", "%20");
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public ClienteServicio getCs() {
		return cs;
	}

	public boolean registraPedido(Pedido ped) {
		boolean insertadoConExito = false;
		return insertadoConExito;
	}
}
