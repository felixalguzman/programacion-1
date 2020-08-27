package logical;

public class Jugador extends Equipo {

	private String nombrej;
	private String ncamiseta;
	private String estatura;
	private String peso;
	private Tipo pos;
	
	public Jugador(int id, String agn, String nombre, String ncam, String esta, String peso, Tipo tipo, String nombrej) {
		super(id, agn, nombre);
		this.ncamiseta = ncam;
		this.estatura = esta;
		this.peso = peso;
		this.pos = tipo;
		this.nombrej = nombrej;
		
	}

	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public String getNcamiseta() {
		return ncamiseta;
	}

	public void setNcamiseta(String ncamiseta) {
		this.ncamiseta = ncamiseta;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Tipo getPos() {
		return pos;
	}

	public void setPos(Tipo pos) {
		this.pos = pos;
	}

	public String getNombrej() {
		return nombrej;
	}

	public void setNombrej(String nombrej) {
		this.nombrej = nombrej;
	}

}
