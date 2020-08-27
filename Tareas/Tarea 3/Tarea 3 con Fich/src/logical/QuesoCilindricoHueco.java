package logical;

import java.io.Serializable;

public class QuesoCilindricoHueco extends QuesoCilindrico implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float radioInterior;
	
	public QuesoCilindricoHueco(float precioBase, float precioUnitario, float radio, float longitud, float radioInt, String id, boolean iscomp, Tipos tipo) {
		super(precioBase, precioUnitario, radio, longitud, id, iscomp, tipo);
		this.radioInterior = radioInt;
		
	}

	public float getRadioInterior() {
		return radioInterior;
	}

	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}
	
	public float precio()
	{
		float precioTotal = 0;
			
		
		precioTotal = (precioBase+precioUnitario)*volumen();
			
		return precioTotal;
	}
	
	public float volumen()
	{
		float vol =0;
		
		vol = (float) (  longitud *( (radio*radio) - (radioInterior*radioInterior)) );

		
		return vol;
	}

	
	
	public float getlongitu()
	{
		float lon = super.getlongitu();
		
		lon = longitud;
		
		return lon;
	}
	
	public float getRadInter()
	{
		float radin = super.getRadInter();
		
		radin = radioInterior;
		
		return radin;
	}
	
}
