package Unidad02.TarjetasBancarias;

public class CuentaBancaria {
	private int saldo;

	public CuentaBancaria(int s) {
		saldo = s;
	} // inicializa saldo actual

	public int getSaldo() {
		return saldo;
	} // devuelve el saldo

	public void restar(int cantidad) { // se resta la cantidad al saldo
		saldo = saldo - cantidad;
	}

	public void retirarDinero(int cant, String nom) {
		if (getSaldo() >= cant) {
			System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
			restar(cant);
			System.out.println(nom + " retira => " + cant + " ACTUAL(" + getSaldo() + ")");
		} else {
			System.out.println(nom + " No puede retirar dinero, NO HAY SALDO (" + getSaldo() + ")");
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO => " + getSaldo());
		}
	}
}