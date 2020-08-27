package Logical;

public class Vehiculo {

	private String marca;
	private String modelo;
	private String color;
	private Tipovehi tipo;
	private Suministrador suministrador;
	private int precio;
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Tipovehi getTipo() {
		return tipo;
	}
	public void setTipo(Tipovehi tipo) {
		this.tipo = tipo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		if(precio>0)
		this.precio = precio;
	}
	public Suministrador getSuministrador() {
		return suministrador;
	}
	public void setSuministrador(Suministrador suministrador) {
		this.suministrador = suministrador;
	}

}
	

