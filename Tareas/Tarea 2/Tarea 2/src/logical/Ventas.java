package logical;

import java.util.ArrayList;

public class Ventas {

	private Cliente client;
	private ArrayList<Queso>listaquesosventa;
	private int id = 0;
	
	public Cliente getClient() {
		return client;
	}
	public void setClient(Cliente client) {
		this.client = client;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Queso> getListaquesosventa() {
		return listaquesosventa;
	}
	public void setListaquesosventa(ArrayList<Queso> listaquesosventa) {
		this.listaquesosventa = listaquesosventa;
	}
	public void regiQuesos(Queso q)
	{
		listaquesosventa.add(q);
	}
	
	public Ventas()
	{
		super();
		this.listaquesosventa = new ArrayList<Queso>();
	}
	
	

}
