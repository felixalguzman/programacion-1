package logical;

import java.io.File;
import java.io.IOException;
import java.io.OptionalDataException;

public class Main {

	public static void main(String[] args) {
		
		File arch = new File("equipobin.dat");
		if(arch.exists())
		{
			try {
				Liga.getliga().leerFicherotext();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			Jugador jug = new Jugador();
			Jugador jug2 = new Jugador();
			Equipo qe = new Equipo();
			
			jug.setId(1);
			jug.setNombre("SantiagoFC");
			jug.setAgn("1990");
			
			jug.setEstatura("180");
			jug.setNcamiseta("19");
			jug.setNombrej("Juan");
			jug.setPeso("80");
			jug.setPos(Tipo.f);
			jug.setCant(1);
			
			jug2.setId(1);
			jug2.setNombre("SantiagoFC");
			jug2.setAgn("1990");
			
			jug2.setEstatura("175");
			jug2.setNcamiseta("11");
			jug2.setNombrej("Pepe");
			jug2.setPeso("85");
			jug2.setPos(Tipo.d);
			jug2.setCant(2);
			
			
			qe.regjug(jug);
			qe.regjug(jug2);
			
			Liga.getliga().regEquipo(qe);
			
			Liga.getliga().guardaFichBin();
			
			try {
				Liga.getliga().ficheroTexto();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		

	}

}
