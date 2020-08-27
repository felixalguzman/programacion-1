package logical;

public class QuesoEsferico extends Queso {

	public QuesoEsferico(float precioBase, float precioUnitario, float radio, String id, boolean iscomp, Tipos tipo) {
		super(precioBase, precioUnitario, radio, id, iscomp, tipo);
		// TODO Auto-generated constructor stub
	}

	public QuesoEsferico() {
		// TODO Auto-generated constructor stub
	}

	public float precio()
	{
		float precioTotal = super.precio();
			
		
		precioTotal = (precioBase+precioUnitario) * volumenEsferico();
			
		return precioTotal;
	}
	
	public float volumenEsferico()
	{
		float vol=super.volumenEsferico();
		
		vol = (float) ((4/3) * (3.14) * radio*radio*radio);
		
		return vol;
	}
}
