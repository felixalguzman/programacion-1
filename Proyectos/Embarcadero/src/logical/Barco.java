package logical;

public class Barco {
	private String nombre;
	private int año;
	private int eslora;
	private Typeline tipo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		if(año >=1)
			this.año = año;
	}
	public int getEslora() {
		return eslora;
	}
	public void setEslora(int eslora) {
		if(eslora >=1)
			this.eslora = eslora;
	}
	public Typeline getTipo() {
		return tipo;
	}
	public void setTipo(Typeline tipo) {
		this.tipo = tipo;
	}
	
	public int factor(){
		int factor = 0;
		factor = this.eslora * 45;
		return factor;
	}
	
}
