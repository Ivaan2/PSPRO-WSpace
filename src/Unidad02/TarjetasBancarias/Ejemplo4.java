package Unidad02.TarjetasBancarias;

public class Ejemplo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CuentaBancaria cb = new CuentaBancaria(40);
		UsuarioCuentaBancaria hJesus = new UsuarioCuentaBancaria("Juan", cb);
		UsuarioCuentaBancaria hManuela = new UsuarioCuentaBancaria("Manuela", cb);
		
		hJesus.start();
		hManuela.start();		
	}
}