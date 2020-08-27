package logical;

public class QuesoCilindrico extends Queso {

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
	
	public float volumenCilindrico()
	{
		float vol = 0;
		
		vol = (float) ( (3.14) * longitud * (radio*radio) );

		
		return vol;
	}
	
	public float precio()
	{
		float precioTotal = super.precio();
			
		
		precioTotal += (precioBase+precioUnitario);
		precioTotal*= volumenCilindrico();
			
		return precioTotal;
	}
	
	
	public float getlongitu()
	{
		float lon = super.getlongitu();
		
		lon = longitud;
		
		return lon;
	}
	
	
}
