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

public class Myclass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		 // Instancia un FileWriter que se encargara de escribir
		/*File archivo = new File ("C:/Users/felix/Desktop/myFile.txt");
       FileWriter escritor;
		try {
			escritor = new FileWriter(archivo);
			String info = "Tengo que estudiar mas programacion pork el profe tiene duda de mi rendimiento";
		       
	        // Escribe el archivo con la informacion
	        for (int i=0; i<info.length(); i++)
	            escritor.write(info.charAt(i));
	           
	        // Cierra el stream
	        escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Construye una cadena de caracteres a ser guardada en el archivo     
       
        // Informa que el archivo ha sido escrito
        System.out.println("El archivo ha sido escrito...");
		//File archivo = new File ("C:/Users/felix/Desktop/myFile.txt");
	      // Defino variables
        boolean eof = false;
        String lineaLeida = "";
        
		 // Construye un BufferedReader
        BufferedReader lectorMejorado;
		try {
			lectorMejorado = new BufferedReader(new FileReader(archivo));
			 while (!eof)
		        {
		            // Lee una linea entera
		            lineaLeida = lectorMejorado.readLine();
		           
		            // Imprime la linea en pantalla
		            if( lineaLeida != null )
		                System.out.println( lineaLeida );
		           
		            // Si llego al final del archivo, termina la ejecución
		            else
		                eof = true;
		        }

		        // Cierra el FileReader
		        lectorMejorado.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        // Lee el archivoEntrada de forma eficiente e imprime los datos en pantalla
       
		
		
		 // Instancia un objeto File de entrada y otro de salida
       /* File archivoEntrada = new File("E:/Tulips.jpg");
        File archivoSalida = new File("F:/Tulips.jpg");

        // Instancia un   FileInputStream  y un  FileOutputStream  que se encargaran de leer y escribir archivos respectivamente
        FileInputStream lector = new FileInputStream(archivoEntrada);
        FileOutputStream escritor = new FileOutputStream(archivoSalida);
       
        // Instancia una variable que contendrá el byte a leer
        int unByte;     
        // Informa que se está copiando el archivo
        System.out.println("\n\tEl archivo está siendo copiado....");
        // Lee el archivoEntrada y guarda la informacion en el archivoSalida
        try {
			while ((unByte = lector.read()) != -1)
			   escritor.write(unByte);
			
		    lector.close();
	        escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
       
        // Informa que se ha copiado el archivo
        System.out.println("\tEl archivo ha sido copiado con éxito....\n");*/
		/*FileOutputStream fs = new FileOutputStream ("C:/Users/felix/Desktop/Personas.dat");
		ObjectOutputStream oos 	= new ObjectOutputStream (fs);
		*/
		FileInputStream f = new FileInputStream ("C:/Users/felix/Desktop/Personas.dat");
		ObjectInputStream ooE = new ObjectInputStream(f);
		/*
        Person[] v = new Person[10];
        		for (int i = 0; i < v.length ; i++)
        		  v[i] = new Person("Pepe "+ i, i);
        		
        		oos.writeInt(v.length);*/
                int cant =  ooE.readInt();
              //  System.out.println("Cantidad de personas: "+cant);
        		for (int i = 0; i < 10; i++){		
        			Person a = (Person)ooE.readObject();
        			//oos.writeObject(v[i]);
        			System.out.println("Nombre: " + a.getName()+"- Edad: " + a.getAge());
        		}
        		
        		f.close();

	}

}
