package logical;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Complejo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Queso>listaquesos;
	private ArrayList<Cliente>listaclientes;
	private ArrayList<Ventas>listaventas;
	private ArrayList<Queso>listaquesopventa;
	private ArrayList<Queso> lastques;
	private Ventas lastvent;
	private boolean borrado = false;
	
	private static Complejo miCompl;
	
	
	private Complejo()
	{
		super();
		this.lastques = new ArrayList<Queso>();
		this.listaventas = new ArrayList<Ventas>();
		this.listaclientes = new ArrayList<Cliente>();
		this.listaquesos = new ArrayList<Queso>();
		this.listaquesopventa = new ArrayList<Queso>();
		
	}
	
	public static Complejo getComplejo()
	{
		if(miCompl == null)
		{
			miCompl = new Complejo();
		}
		
		return miCompl;
	}
	
	public static void setComplejo(Complejo c)
	{
		miCompl = c;
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
	
	public Cliente findClienteFich(String cedula, ArrayList<Ventas> list)
	{
		Cliente client = null;
		
		for(int i =0; i < list.size(); i++)
		{
			if(list.get(i).getClient().getCedula().equalsIgnoreCase(cedula))
			{
				client = list.get(i).getClient();
			}
		}
		
		return client;
	}
	
	
	public boolean findmultplClients(Cliente c)
	{
		boolean find = false;
		int cont=0;
		
		for (Ventas v: listaventas) {
			
			if(v.getClient().getCedula().equalsIgnoreCase(c.getCedula()))
			{
				cont++;
			}
		}
		
		if(cont != 1)
		{
			find = true;
		}
		
		return find;
	}
	
	public boolean findmultplQuesos(Cliente c)
	{
		boolean find = false;
		int cont=0;
		
		for(int i =0; i < Complejo.getComplejo().getListaventas().size();i++)
		{
			if(Complejo.getComplejo().getListaventas().get(i).getClient().getCedula().equalsIgnoreCase(c.getCedula()))
			{
				if(!Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().isEmpty())
				{
					cont++;
				}
			}
		}
		
		if(cont > 1)
		{
			find = true;
		}
		
		return find;
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
	
	public Ventas findVenta(String cedula)
	{
		Ventas ven = null;
		
		
		for(int i =0; i < listaventas.size();i++)
		{
			if(listaventas.get(i).getClient().getCedula() == cedula)
			{
				ven = listaventas.get(i);
			}
		}
		return ven;
	}
	
	public Ventas findVentFich(String cedula, ArrayList<Ventas> list)
	{
		Ventas ven = null;
		
		for(int i =0; i < list.size(); i++)
		{
			if(list.get(i).getClient().getCedula().equalsIgnoreCase(cedula))
			{
				ven = list.get(i);
			}
		}
		
		return ven;
	}
	
	public ArrayList<Queso> findArrQuesoVent(Ventas v)
	{
		ArrayList<Queso> li = new ArrayList<Queso>();
		
		for(int i =0; i < Complejo.getComplejo().getListaventas().size();i++)
		{
			if(Complejo.getComplejo().getListaventas().get(i).getClient().getCedula().equalsIgnoreCase(v.getClient().getCedula()))
			{
				li = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa();
			}
		}
		
		
		return li;
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
	
	public void agregarpVent(Ventas venta)
	{
		int pos = -1;
		int real = -1;
		
		for (Ventas vent : listaventas) {
			pos++;
			if(vent.getClient().getCedula().equalsIgnoreCase(venta.getClient().getCedula()))
			{
				real = pos;
			}
		}
		
		listaventas.remove(real);
		listaventas.add(real, venta);
		
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
	
	public float precioTotalfact()
	{
		float ptotal = 0;
	
		
		
		for (Queso q: listaquesopventa) {
			
			ptotal += q.precio();
			
		}
	
		
		System.out.println("Precio total: " + ptotal);
		return ptotal;
	}
	
	public float precioTotalconitbi()
	{
		float sub = 0, itbi =0;
		
		
			
			sub = gananciassubTotal();
			itbi = (float) (sub * 0.18);
			sub += itbi;
			
			return sub;
		
	}
	
	public float gananciassubTotal()
	{
		float gan = 0;
		
		for (Queso q : listaquesopventa) {
			
			gan += q.precio();
		}
		
		return gan;
	}
	
	public float getGanancias()
	{
		float gan =0;
		
		gan = gananciassubTotal();
		
		return gan;
	}
	
	public float ganancFich() 
	{
		float gan = 0;
		
		
		
		for (Ventas ventas : listaventas) {
			
			gan += ventas.getPreciototal();
		}
		
		return gan;
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
	
	public int cantQuesoVent()
	{
		int cant =0;
		
		for (Queso q : listaquesopventa) {
		
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

	public ArrayList<Queso> getListaquesopventa() {
		return listaquesopventa;
	}

	public void setListaquesopventa(ArrayList<Queso> listaquesopventa) {
		this.listaquesopventa = listaquesopventa;
	}
	
	public void registrarQpventa(Queso q)
	{
		listaquesopventa.add(q);
	}
	public void lastq(Queso q)
	{
		lastques.add(q);
	}


	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}
	
	public void limplistapventas()
	{
		listaquesopventa.clear();
	}

	public ArrayList<Queso> getLastques() {
		return lastques;
	}

	public void setLastques(ArrayList<Queso> lastques) {
		this.lastques = lastques;
	}

	public Ventas getLastvent() {
		return lastvent;
	}

	public void setLastvent(Ventas lastvent) {
		this.lastvent = lastvent;
	}
		



	
	
}
