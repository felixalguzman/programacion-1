package logical;

import java.io.Serializable;

public class QuesoEsferico extends Queso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuesoEsferico(float precioBase, float precioUnitario, float radio, String id, boolean iscomp, Tipos tipo) {
		super(precioBase, precioUnitario, radio, id, iscomp, tipo);
		// TODO Auto-generated constructor stub
	}

	public QuesoEsferico() {
		// TODO Auto-generated constructor stub
	}

	
	
	public float volumen()
	{
		float vol=0;
		
		vol = (float) ((4/3)  * (radio*radio*radio));
		
		return vol;
	}
	
	public float precio()
	{
		float precioTotal = 0;
			
		
		precioTotal = (precioBase+precioUnitario) * volumen();
			
		return precioTotal;
	}
}
