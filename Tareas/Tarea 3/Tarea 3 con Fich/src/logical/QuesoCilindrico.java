package logical;

import java.io.Serializable;

public class QuesoCilindrico extends Queso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float longitud;
	public QuesoCilindrico(float precioBase, float precioUnitario, float radio, float longitud , String id, boolean iscomp, Tipos tipo) {
		super(precioBase, precioUnitario, radio, id, iscomp, tipo);
		this.longitud = longitud;
		
		// TODO Auto-generated constructor stub
	}

	public QuesoCilindrico() {
		// TODO Auto-generated constructor stub
	}


	
	
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	public float volumen()
	{
		float vol =0;
		
		vol = (float) ( longitud * (radio*radio) );

		
		return vol;
	}
	
	public float precio()
	{
		float precioTotal = 0;
			
		
		precioTotal = (precioBase+precioUnitario) * volumen();
			
		return precioTotal;
	}

	
	public float getlongitu()
	{
		float lon = super.getlongitu();
		
		lon = longitud;
		
		return lon;
	}
	
	
}
