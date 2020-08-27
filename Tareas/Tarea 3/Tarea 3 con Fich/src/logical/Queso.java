package logical;

import java.io.Serializable;

public abstract class Queso implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float precioBase;
	protected float precioUnitario;
	protected float radio;
	protected String id;
	protected boolean iscomp;
	protected Tipos tipo;
	private float pi = (float) 3.14;
	
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

	public abstract float precio();
	
	public abstract float volumen();

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
