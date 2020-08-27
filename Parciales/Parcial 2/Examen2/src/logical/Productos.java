package logical;

public abstract class Productos {

	protected String codigo;
	protected String nombre;
	protected int pcompra;
	protected int pventa;
	protected int indice;
	protected int dias;
	
	public Productos(String codigo, String nombre, int pcompra, int pventa, int indice, int dias) {
		super();
	}

	

	public Productos() {
		// TODO Auto-generated constructor stub
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPcompra() {
		return pcompra;
	}

	public void setPcompra(int pcompra) {
		this.pcompra = pcompra;
	}

	public int getPventa() {
		return pventa;
	}

	public void setPventa(int pventa) {
		this.pventa = pventa;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	
	
	
}
