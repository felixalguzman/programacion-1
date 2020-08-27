package logical;

public class ProductoNorm extends Productos {

	public ProductoNorm(String codigo, String nombre, int pcompra, int pventa, int indice, int dias) {
		super(codigo, nombre, pcompra, pventa, indice, dias);
		// TODO Auto-generated constructor stub
	}

	public ProductoNorm() {
		// TODO Auto-generated constructor stub
	}

	public int precioVenta()
	{
		int vent = 0;
		
		if(indice >= 1 && indice <=3)
		{
			vent = (pcompra*(dias/2)) + indice*50;	
		}	
		
		return vent;
	}
}
