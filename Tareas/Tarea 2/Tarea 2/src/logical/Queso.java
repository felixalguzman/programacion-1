package logical;

public abstract class Queso {

	

	protected float precioBase;
	protected float precioUnitario;
	protected float radio;
	protected String id;
	protected boolean iscomp;
	protected Tipos tipo;
	
	public Queso(float precioBase, float precioUnitario, float radio, String id, boolean iscomp, Tipos tipo) {
		super();
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		this.radio = radio;
		this.id = id;
		this.iscomp = iscomp;
		this.tipo = tipo;
	}
	
	public Queso() {
		super();
	}
	

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public float precio()
	{
		float precioTotal = 0;
			
		
		precioTotal = (precioBase+precioUnitario) * volumenEsferico();
			
		return precioTotal;
	}
	
	public float volumenEsferico()
	{
		float vol=0;
		
		vol = (float) ((4/3) * (3.14) * radio*radio*radio);
		
		return vol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isSelected() {
		return iscomp;
	}

	public void setSelected(boolean isSelected) {
		this.iscomp = isSelected;
	}

	public boolean isIscomp() {
		return iscomp;
	}

	public void setIscomp(boolean iscomp) {
		this.iscomp = iscomp;
	}

	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}
	

	public float getlongitu()
	{
		float lon = 0;
		
		
		return lon;
	}
	
	public float getRadInter()
	{
		float radin = 0;
		
		
		return radin;
	}
	
}
