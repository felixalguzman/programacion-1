package Logical;

import java.util.Random;

public class Vendedor {

	private Venta listaventa[];
	private Vehiculo listavehiculo[];
	private Clientes listaclientes[];
	private Suministrador listasuministrador[];
	private int cantSuministrador;
	private int cantClientes;
	private int cantVehiculo;
	private int cantVenta;
	
	public Vendedor()
	{
		super();
		this.listavehiculo = new Vehiculo[100];
		this.listaventa = new Venta[100];
		this.listaclientes = new Clientes[100];
		this.listasuministrador = new Suministrador[100];
		this.cantSuministrador = 0;
		this.cantClientes = 0;
		this.cantVehiculo = 0;
		this.cantVenta = 0;
	}
	
	public Venta[] getVenta() {
		return listaventa;
	}
	public void setVenta(Venta[] venta) {
		this.listaventa = venta;
	}
	public Vehiculo[] getVehiculo() {
		return listavehiculo;
	}
	public void setVehiculo(Vehiculo[] vehiculo) {
		this.listavehiculo = vehiculo;
	}
	public int getCantVehiculo() {
		return cantVehiculo;
	}
	public void setCantVehiculo(int cantVehiculo) {
		this.cantVehiculo = cantVehiculo;
	}
	public int getCantVenta() {
		return cantVenta;
	}
	public void setCantVenta(int cantVenta) {
		this.cantVenta = cantVenta;
	}
	
	public Venta[] getListaventa() {
		return listaventa;
	}

	public void setListaventa(Venta[] listaventa) {
		this.listaventa = listaventa;
	}

	public Vehiculo[] getListavehiculo() {
		return listavehiculo;
	}

	public void setListavehiculo(Vehiculo[] listavehiculo) {
		this.listavehiculo = listavehiculo;
	}
	
	public Clientes[] getListaclientes() {
		return listaclientes;
	}

	public void setListaclientes(Clientes[] listaclientes) {
		this.listaclientes = listaclientes;
	}

	public int getCantClientes() {
		return cantClientes;
	}

	public void setCantClientes(int cantClientes) {
		this.cantClientes = cantClientes;
	}
	
	public void registrarVehiculo(Vehiculo vehiculo)
	{
		this.listavehiculo[cantVehiculo] = vehiculo;
		cantVehiculo++;
	}
	
	public void registrarVenta(Venta venta)
	{
		this.listaventa[cantVenta] = venta;
		cantVenta++;
	}
	
	public void registrarCliente(Clientes cliente)
	{
		this.listaclientes[cantClientes] = cliente;
		cantClientes++;
	}
	
	public int setCodigo()
	{
		
		return cantVenta+1;
		
		
	}
	
	
	public void modificarVehiculo(Vehiculo vehiculo)
	{
		for(int i=0; i < cantVehiculo;i++)
		{
			if(listavehiculo[i].getModelo().equalsIgnoreCase(vehiculo.getModelo()))
			{
				listavehiculo[i]=vehiculo;
			}
		}
	}
	
	public void modificarSuministrador(Suministrador suministrador)
	{
		for(int i=0; i < cantSuministrador; i++)
		{
			if(listasuministrador[i].getCodigo().equalsIgnoreCase(suministrador.getCodigo()))
			{
				listasuministrador[i] = suministrador; 
			}
			
		}
	}
	
	public void modificarCliente(Clientes cliente)
	{
		for(int i =0; i <cantClientes; i++)
		{
			if(listaclientes[i].getCedula().equalsIgnoreCase(cliente.getCedula()))
			{
				listaclientes[i] = cliente;
			}
		}
	}
	
	
	
	
	public Suministrador encontrarSuministrador(String codigo)
	{
		Suministrador suministrador = null;
		for(int i =0; i < cantSuministrador;i++)
		{
			if(listasuministrador[i].getCodigo().equalsIgnoreCase(codigo))
			{
				suministrador = listasuministrador[i];
			}
			
			
		}
		return suministrador;
	}
	
	public String encontrarMarcaSuministrador(String marca)
	{
		Suministrador suministrador = null;
		int pos=0;
		for(int i =0; i < cantSuministrador; i++)
		{
			if(listasuministrador[i].getMarca().equalsIgnoreCase(marca))
			{
				suministrador = listasuministrador[i];
				pos = i;
			}
		}
		return listasuministrador[pos].getMarca();
		
	}
	
	public Vehiculo encontrarVehiculo(String modelo,int indice)
	{
		Vehiculo vehiculo = null;
		for(int i=0; i < cantVehiculo; i++)
		{
			if(i == indice && listavehiculo[i].getModelo().equalsIgnoreCase(modelo))
			{
				vehiculo = listavehiculo[i];
			}
		}
		return vehiculo;
		
	}
	
	public Clientes encontrarCliente(String cedula, int indice)
	{
		Clientes cliente=null;
		for(int i =0; i < cantClientes;i++)
		{
			if(i == indice && listaclientes[i].getCedula().equalsIgnoreCase(cedula))
			{
				cliente = listaclientes[i];
			}
		}
		
		return cliente;
	}
	
	public void eliminarVehiculo(Vehiculo vehiculo, int indice)
	{
		boolean find = false;
		int i =0;
		int pos = -1;
		
		while(!find && i < cantVehiculo)
		{
			if(listavehiculo[i].getModelo().equalsIgnoreCase(vehiculo.getModelo()) && i == indice){
				
				find = true;
				pos = i;
			}
			i++;
		}
		if( pos != -1)
		{
			i = pos;
			while(pos < cantVehiculo)
			{
				listavehiculo[i] = listavehiculo[i+1];
				i++;
				pos++;
			}
			cantVehiculo--;
		}
	}
	
	public void eliminarVehiculoSinIndice(Vehiculo vehiculo)
	{
		boolean find = false;
		int i =0;
		int pos = -1;
		
		while(!find && i < cantVehiculo)
		{
			if(listavehiculo[i].getModelo().equalsIgnoreCase(vehiculo.getModelo())){
				
				find = true;
				pos = i;
			}
			i++;
		}
		if( pos != -1)
		{
			i = pos;
			while(pos < cantVehiculo)
			{
				listavehiculo[i] = listavehiculo[i+1];
				i++;
				pos++;
			}
			cantVehiculo--;
		}
	}
	
	public void eliminarSuministrador(Suministrador suministrador)
	{
		boolean find = false;
		int i =0;
		int pos = -1;
		
		while(!find && i < cantSuministrador)
		{
			if(listasuministrador[i].getCodigo().equalsIgnoreCase(suministrador.getCodigo()))
			{
				find = true;
				pos = i;
				
			}
			i++;
		}
		if( pos != -1)
		{
			i = pos;
			while(pos < cantSuministrador)
			{
				listasuministrador[i] = listasuministrador[i+1];
				i++;
				pos++;
			}
			cantSuministrador--;
		}
	}
	
	public void eliminarCliente (Clientes cliente)
	{
		boolean find = false;
		int i =0;
		int pos = -1;
		
		while(!find && i < cantClientes)
		{
			if(listaclientes[i].getCedula().equalsIgnoreCase(cliente.getCedula()))
			{
				find = true;
				pos = i;
			}
		}
		if(pos != -1)
		{
			while(pos < cantClientes)
			{
				listaclientes[i] = listaclientes[i+1];
				i++;
				pos++;
			}
			cantClientes--;
		}
	}

	public Suministrador[] getListasuministrador() {
		return listasuministrador;
	}

	public void setListasuministrador(Suministrador[] listasuministrador) {
		this.listasuministrador = listasuministrador;
	}

	public int getCantSuministrador() {
		return cantSuministrador;
	}

	public void setCantSuministrador(int cantSuministrador) {
		this.cantSuministrador = cantSuministrador;
	}
	
	public void registrarSuministrador(Suministrador suministrador)
	{
		this.listasuministrador[cantSuministrador] = suministrador;
		cantSuministrador++;
	}
	
	public int codigoVenta()
	{
		int a =0;
			
		Random rnd = new Random();
		
		a = rnd.nextInt(101);
		
		return a;
		
	}
}
