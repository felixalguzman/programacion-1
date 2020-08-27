package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Ventas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente client;
	private ArrayList<Queso>listaquesosventa;
	private int id;
	private float preciototal;
	private float subtotal;
	private int cant;
	
	public Ventas()
	{
		super();
		this.listaquesosventa = new ArrayList<Queso>();
	
		
		
	}
	
	

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

	public float getPreciototal() {
			
		return preciototal;
	}

	public void setPreciototal(float preciototal) {
		this.preciototal = preciototal;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	

}
