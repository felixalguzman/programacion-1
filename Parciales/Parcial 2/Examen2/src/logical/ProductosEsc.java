package logical;

public class ProductosEsc extends Productos {

	public ProductosEsc(String codigo, String nombre, int pcompra, int pventa, int indice, int dias) {
		super(codigo, nombre, pcompra, pventa, indice, dias);
		// TODO Auto-generated constructor stub
	}

	public ProductosEsc() {
		// TODO Auto-generated constructor stub
	}

	public int precioV()
	{
		int preciov = 0;
		
		if(indice >= 1 && indice <=3)
		{
			if(indice == 1)
			{
				preciov = (int) ((pcompra*(dias/2)) + (0.1*50));	
			}
			else if(indice == 2)
			{
				preciov = (int) ((pcompra*(dias/2)) + (0.2*50));
			}
			else if(indice == 3)
			{
				preciov = (int) ((pcompra*(dias/2)) + (0.3*50));
			}
			
		}
		
		return preciov;
	}
}
