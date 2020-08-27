package logical;

import java.util.ArrayList;


public class Complejo {

	private ArrayList<Queso>listaquesos;
	private ArrayList<Cliente>listaclientes;
	private ArrayList<Ventas>listaventas;
	
	private static Complejo miCompl;
	
	
	private Complejo()
	{
		super();
		this.listaclientes = new ArrayList<Cliente>();
		this.listaquesos = new ArrayList<Queso>();
	}
	
	public static Complejo getComplejo()
	{
		if(miCompl == null)
		{
			miCompl = new Complejo();
		}
		
		return miCompl;
	}
	
	public ArrayList<Queso> getListaquesos() {
		return listaquesos;
	}
	

	public void setListaquesos(ArrayList<Queso> listaquesos) {
		this.listaquesos = listaquesos;
	}
	public ArrayList<Cliente> getListaclientes() {
		return listaclientes;
	}
	public void setListaclientes(ArrayList<Cliente> listaclientes) {
		this.listaclientes = listaclientes;
	}
	
	public void registrarCliente(Cliente client)
	{
		listaclientes.add(client);
	}
	
	public void registrarQueso(Queso queso)
	{
		listaquesos.add(queso);
	}
	
	public void registrarVenta(Ventas vent)
	{
		
		listaventas.add(vent);
	}
	
	
	
	public Cliente findCliente(String cedula)
	{
		Cliente client = null;
		
		for(int i =0; i < listaclientes.size(); i++)
		{
			if(listaclientes.get(i).getCedula().equalsIgnoreCase(cedula))
			{
				client = listaclientes.get(i);
			}
		}
		return client;
	}
	
	
	
	
	public Queso findQueso(String id)
	{
		Queso ques = null;
		
		
		
		for(int i =0; i < listaquesos.size();i++)
		{
			if(listaquesos.get(i).getId().equalsIgnoreCase(id))
			{
				ques = listaquesos.get(i);
				
			}
		}
		
		return ques;
	}
	
	public Ventas findVenta(int e)
	{
		Ventas ven = null;
		
		
		for(int i =0; i < listaventas.size();i++)
		{
			if(listaventas.get(i).getId() == e)
			{
				ven = listaventas.get(i);
			}
		}
		return ven;
	}
	
	
	
	
	
	public void modificarClient (Cliente client)
	{
		int pos =-1;
		int real = -1;
		for (Cliente aux : listaclientes) {
			pos++;
			if(aux.getCedula().equalsIgnoreCase(client.getCedula()))
			{
				real = pos; 
			}
			
		}
		listaclientes.remove(real);
		listaclientes.add(real, client);
	}
	
	public void modificarQueso(Queso queso)
	{
		int pos = -1;
		int real = -1;
		
		for (Queso aux : listaquesos){
			pos++;
			if(aux.getId().equalsIgnoreCase(queso.getId()))
			{
				real = pos;
			}
	
		}
		listaquesos.remove(real);
		listaquesos.add(real, queso);
	}
	
	public void deleteClient(Cliente client) {
		  
		   listaclientes.remove(client);
			
	}
	
	public void deleteQueso(Queso queso)
	{
		listaquesos.remove(queso);
	}

	public ArrayList<Ventas> getListaventas() {
		return listaventas;
	}

	public void setListaventas(ArrayList<Ventas> listaventas) {
		this.listaventas = listaventas;
	}
	
	public float precioTotalfact(Ventas venta)
	{
		float ptotal = 0;
		int i=-1;
		
		for (Ventas vent: listaventas) {
			i++;
			if(vent.getClient().getCedula().equalsIgnoreCase(venta.getClient().getCedula()))
			{
				
					
					ptotal += listaventas.get(i).getListaquesosventa().get(i).precio();
				
			}
		}
		
		
		return ptotal;
	}
	
	


	public int cantQE()
	{
		int cant = 0;
		
		for (Queso q : listaquesos) {
			
			if( q instanceof QuesoEsferico)
			{
				cant++;
			}
		}
		
		
		return cant;
	}
	
	public int cantQCil()
	{
		int cant = 0;
		
		for (Queso q : listaquesos) {
			
			if( q instanceof QuesoCilindrico && q.getRadInter()==0)
			{
				cant++;
			}
		}
		
		
		return cant;
	}
	
	public int cantQCilHueco()
	{
		int cant = 0;
		
		for (Queso q : listaquesos) {
			
			if( q instanceof QuesoCilindricoHueco )
			{
				cant++;
			}
		}
		
		
		return cant;
	}
	
	public int cantQTodos()
	{
		int cant = 0;
		
		for (Queso q : listaquesos) {
			
			if( q instanceof QuesoCilindricoHueco)
			{
				cant++;
			}
			else if(q instanceof QuesoCilindrico)
			{
				cant++;
			}
			else if(q instanceof QuesoEsferico)
			{
				cant++;
			}
		}
		
		
		return cant;
	}
	
	
		

	
	
	
}
