package logical;

public class QuesoCilindricoHueco extends QuesoCilindrico {


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
	
	
	public float volumenCilindricoHueco()
	{
		float vol = super.volumenEsferico();
		
		vol = (float) ( (3.14) * longitud *( (radio*radio) - (radioInterior*radioInterior)) );

		
		return vol;
	}

	public float precio()
	{
		float precioTotal = super.precio();
			
		
		precioTotal+= (precioBase+precioUnitario);
		precioTotal*= volumenCilindricoHueco();
			
		return precioTotal;
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
