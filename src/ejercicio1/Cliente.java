/**
 * 
 */
package ejercicio1; /**

import ejercicio1.Taxi;

/**
 * @author JESUS
 *
 */
public class Cliente extends Thread{
	String nombreCliente;
	int numKmCarrera;
	private Taxi taxi;

	public Cliente(String nombreCliente, int numKmCarrera, Taxi taxi){
		this.nombreCliente = nombreCliente;
		this.numKmCarrera = numKmCarrera;
		this.taxi = taxi;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getNumKmCarrera() {
		return numKmCarrera;
	}

	public void setNumKmCarrera(int numKmCarrera) {
		this.numKmCarrera = numKmCarrera;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	@Override
	public void run(){
		this.taxi.iniciarTrayecto(this);

		this.taxi.finalizarTrayecto(this);

	}
}
