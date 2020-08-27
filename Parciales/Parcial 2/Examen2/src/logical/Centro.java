package logical;

import java.util.ArrayList;

public class Centro {
	
	private ArrayList<Productos>listaproductos;
	private static Centro miCentro;

	private Centro()
	{
		super();
		this.listaproductos = new ArrayList<Productos>();
	}
	public ArrayList<Productos> getListaproductos() {
		return listaproductos;
	}

	public void setListaproductos(ArrayList<Productos> listaproductos) {
		this.listaproductos = listaproductos;
	}
	
	public static Centro getCentro()
	{
		if(miCentro == null)
		{
			miCentro = new Centro();
		}
		
		return miCentro;
	}
	
	public void registrarProducto (Productos p)
	{
		listaproductos.add(p);
	}
	
	public int precioVenta()
	{
		
		int precioV =0;
		
		for (Productos productos : listaproductos) {
			
			if(productos instanceof ProductoNorm)
			{
				precioV = ((ProductoNorm) productos).precioVenta();
			}
			else if(productos instanceof ProductosEsc)
			{
				precioV = ((ProductosEsc) productos).precioV();
			}
			
		}
		
		
		return precioV;
	}
	
	public int cantEsc()
	{
		int cant =0;
		
		for (Productos productos : listaproductos) {
			
			if(productos instanceof ProductosEsc)
			{
				cant++;
			}
		}
		return cant;
	}

}
