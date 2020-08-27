package logical;

public class Embarcadero {
	
	
	private Clientes[] listaClientes;
	private Alquiler[] listaAlquileres;
	private int cantidadClientes;
	private int cantidadAlquileres;
	
	public Clientes[] getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(Clientes[] listaClientes) {
		this.listaClientes = listaClientes;
	}
	public Alquiler[] getListaAlquileres() {
		return listaAlquileres;
	}
	public void setListaAlquileres(Alquiler[] listaAlquileres) {
		this.listaAlquileres = listaAlquileres;
	}
	public int getCantidadClientes() {
		return cantidadClientes;
	}
	public void setCantidadClientes(int cantidadClientes) {
		this.cantidadClientes = cantidadClientes;
	}
	public int getCantidadAlquileres() {
		return cantidadAlquileres;
	}
	public void setCantidadAlquileres(int cantidadAlquileres) {
		this.cantidadAlquileres = cantidadAlquileres;
	}
	
	public int cantidadYates(){

		int cant =0;
		for(int i=0; i<cantidadAlquileres; i++){
			if(listaAlquileres[i].getBarco().getTipo() == Typeline.yate)
				cant++;
		}
		
		return cant;
	}
	public int calcularGanancia(){
		int ganancia = 0;
		for(int i=0; i<cantidadAlquileres; i++){
			ganancia += listaAlquileres[i].valor();
		}
		return ganancia;
	}
	public void registrarAlquiler(Alquiler alq){
		this.listaAlquileres[cantidadAlquileres] = alq;
		cantidadAlquileres++;
	}
	public void registrarClientes(Clientes cliente){
		this.listaClientes[cantidadClientes] = cliente;
		cantidadClientes++;
	}
	public Embarcadero() {
		super();
		this.listaClientes = new Clientes[50];
		this.listaAlquileres = new Alquiler[50];
		this.cantidadClientes = 0;
		this.cantidadAlquileres = 0;
	} 
	
	public Clientes findClient(String cedula){
		Clientes client = null;
		for (int i = 0; i < cantidadClientes; i++) {
			if(listaClientes[i].getCedula().equalsIgnoreCase(cedula)){
				client = listaClientes[i];
			}
		}
		
		return client;
		
	}
	
	public Clientes findClientByName(String nombre){
		Clientes client = null;
		for (int i = 0; i < cantidadClientes; i++) {
			if(listaClientes[i].getNombre().equalsIgnoreCase(nombre)){
				client = listaClientes[i];
			}
		}
		
		return client;
		
	}
	
	public void modify(Clientes client){
		for (int i = 0; i < cantidadClientes; i++) {
			if(listaClientes[i].getNombre().equalsIgnoreCase(client.getNombre())){
				listaClientes[i] = client;
			}
		}
	}
	public void deleteClient(Clientes client) {
		boolean find = false;
		int i=0;
		int pos=-1;
		while(!find && i < cantidadClientes){
			if(listaClientes[i].getCedula().equalsIgnoreCase(client.getCedula())){
				find = true;
				pos = i;
			}
			i++;
	   }
		if(pos!=-1){
			i = pos;
			while(pos<cantidadClientes){
				listaClientes[i]=listaClientes[i+1];
				i++;
				pos++;		
			}
			cantidadClientes--;	
		}
	}
	
}
