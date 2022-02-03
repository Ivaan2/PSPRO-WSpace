package ejercicio1; /**
 * 
 */

/**
 * @author JESUS
 *
 */
public class Taxi {
	private double precioKmCarrera;
	private double importeCarrera;
	private int numKmCarrera;
	private boolean disponible;

	public Taxi(){
		precioKmCarrera = 2.5;
		importeCarrera = 0;
		numKmCarrera = 0;
		disponible = true;
	}

	public double getPrecioKmCarrera() {
		return precioKmCarrera;
	}

	public void setPrecioKmCarrera(double precioKmCarrera) {
		this.precioKmCarrera = precioKmCarrera;
	}

	public double getImporteCarrera() {
		return importeCarrera;
	}

	public void setImporteCarrera(double importeCarrera) {
		this.importeCarrera = importeCarrera;
	}

	public int getNumKmCarrera() {
		return numKmCarrera;
	}

	public void setNumKmCarrera(int numKmCarrera) {
		this.numKmCarrera = numKmCarrera;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public synchronized void iniciarTrayecto(Cliente c) {
		while(!disponible){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Se ha subido " + c.getNombreCliente());
		setNumKmCarrera(this.getNumKmCarrera());
		setImporteCarrera(c.getNumKmCarrera() * this.precioKmCarrera);

		setDisponible(false);
	}

	public synchronized void finalizarTrayecto(Cliente c){
		while(disponible){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setDisponible(true);
		System.out.println("El importe del trayecto de " + c.getNombreCliente() + " es: " + getImporteCarrera());
		notifyAll();
	}
}
