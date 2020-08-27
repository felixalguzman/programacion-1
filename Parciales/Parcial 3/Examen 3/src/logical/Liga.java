package logical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;

public class Liga {

	ArrayList<Equipo> listequipo;
	
	private static Liga milig;
	
	private Liga() {
		super();
		this.listequipo = new ArrayList<Equipo>();
	}
	
	public static Liga getliga()
	{
		if(milig == null)
		{
			milig = new Liga();
		}
		
		return milig;
	}
	

	public ArrayList<Equipo> getListequipo() {
		return listequipo;
	}

	public void setListequipo(ArrayList<Equipo> listequipo) {
		this.listequipo = listequipo;
	}
	
	public void regEquipo(Equipo e)
	{
		listequipo.add(e);
	}
	
	public void guardaFichBin()
	{
		FileOutputStream fs;
		try {
			
			fs = new FileOutputStream("equipobin.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			
			oos.writeInt(listequipo.size());
			oos.writeObject(listequipo);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	}
	
	public int cantjug()
	{
		int cant =0;
		
		for (Equipo equipo : listequipo) {
			
			if(equipo instanceof Jugador)
			{
				cant++;
			}
		}
		
		return cant+1;
	}
	
	public void ficheroTexto() throws IOException
	{
		File arch = new File("equipo.txt");
		FileWriter escritor = null;
		
		try{
			escritor = new FileWriter(arch);
			
			for(int i =0; i < listequipo.size();i++)
			{
				escritor.append("Equipo: " + listequipo.get(i).getNombre());
				escritor.append("\nCantidad jugadores: " + listequipo.get(i).getCant());
				escritor.append("\nJugador con la camiseta #" + Liga.getliga().getListequipo().get(i).getListjug().get(i).getNcamiseta() + ":  ");
				escritor.append(Liga.getliga().getListequipo().get(i).getListjug().get(i).getNombrej() + " juega en la posicion " + Liga.getliga().getListequipo().get(i).getListjug().get(i).getPos() + " " );
				escritor.append(", mide " + Liga.getliga().getListequipo().get(i).getListjug().get(i).getEstatura() + "cm " + " y pesa" + Liga.getliga().getListequipo().get(i).getListjug().get(i).getPeso() + "kg \n" );
				
			
			}
			
		}catch(IOException er)
		{
			er.printStackTrace();
		}
		escritor.close();
		
	}
	
	public void leerFicherotext() throws IOException
	{
		
		File arch = new File("equipobin.dat");
		FileInputStream f = null;
		try {
			f = new FileInputStream(arch);
			ObjectInputStream ooE = new ObjectInputStream(f);
			
			//int cant = ooE.readInt();
			for(int i =0; i < 2; i++)
			{
				Equipo q = (Equipo)ooE.readObject();
				System.out.println("Equipo: " + q.getNombre());
				System.out.println("Cantidad jugadores: " + q.getCant());
				System.out.println("Jugador con la camiseta #" + q.getListjug().get(i).getNcamiseta() + " " + q.getListjug().get(i).getNombrej() + ", juega en la posicion " + q.getListjug().get(i).getPos() + ", mide " + q.getListjug().get(i).getEstatura() + "cm " + " y pesa " + q.getListjug().get(i).getPeso() + "kg ");
			}
		} catch (IOException | ClassNotFoundException | ClassCastException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		f.close();
		
	}
	

}
