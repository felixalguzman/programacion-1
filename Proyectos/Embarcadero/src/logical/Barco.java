package logical;

public class Barco {
	private String nombre;
	private int a�o;
	private int eslora;
	private Typeline tipo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		if(a�o >=1)
			this.a�o = a�o;
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
