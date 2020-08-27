package logical;

public class Alquiler {
	private int numeroAmarre;
	private int dias;
	private Barco barco;
	private Clientes cliente;
	public int getNumeroAmarre() {
		return numeroAmarre;
	}
	public void setNumeroAmarre(int numeroAmarre) {
		this.numeroAmarre = numeroAmarre;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		if(dias >=1)
			this.dias = dias;
	}
	public Barco getBarco() {
		return barco;
	}
	public void setBarco(Barco barco) {
		this.barco = barco;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	
	public int valor(){
		int valor = 0;
		if(barco.getTipo() == Typeline.yate)
			valor = (barco.factor() * dias) + 250;
		else if(barco.getTipo() == Typeline.motor)
			valor = (barco.factor() * this.dias) + 150;
		else if(barco.getTipo() == Typeline.velero)
			valor = (barco.factor() * this.dias) + 100;
		return valor;
		
	}
}
