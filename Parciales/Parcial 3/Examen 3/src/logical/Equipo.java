package logical;

import java.io.Serializable;
import java.util.ArrayList;

public  class Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String agn;
	protected String nombre;
	private int cant;
	private ArrayList<Jugador> listjug;
	
	public Equipo(int id, String agn, String nombre) {
		super();
		
		this.id = id;
		this.agn = agn;
		this.nombre = nombre;
	}


	public Equipo() {
		super();
		this.listjug = new ArrayList<Jugador>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAgn() {
		return agn;
	}


	public void setAgn(String agn) {
		this.agn = agn;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCant() {
		return cant;
	}


	public void setCant(int cant) {
		this.cant = cant;
	}


	public ArrayList<Jugador> getListjug() {
		return listjug;
	}


	public void setListjug(ArrayList<Jugador> listjug) {
		this.listjug = listjug;
	}
	
	public void regjug(Jugador j)
	{
		listjug.add(j);
	}

}
