package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Cliente;
import logical.Complejo;
import logical.Queso;
import logical.QuesoCilindrico;
import logical.QuesoEsferico;
import logical.Tipos;
import logical.Ventas;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Principal extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension dim;
	private static JTextField gananciasV;
	private static boolean paso = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Complejo Lácteo de Ciudad de La Habana");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		final String dirComplejo = "complejo.dat";
		final String dirFactura = "factura.txt";
		final File complejo = new File(dirComplejo);
		final File factura = new File(dirFactura);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistarClientes = new JMenuItem("Registar Clientes");
		mntmRegistarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegistrarClientes  regclient = new RegistrarClientes("Registrar Clientes", null, option);
				regclient.setModal(true);
				regclient.setVisible(true);
				
			}
		});
		mnClientes.add(mntmRegistarClientes);
		
		JMenuItem mntmListaDeClientes = new JMenuItem("Lista de Clientes");
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListClientes listclient = new ListClientes("Lista de Clientes");
				listclient.setModal(true);
				listclient.setVisible(true);
				
			}
		});
		mnClientes.add(mntmListaDeClientes);
		
		JMenu mnNewMenu = new JMenu("Fabricar Quesos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrarQuso = new JMenuItem("Registrar Queso");
		mntmRegistrarQuso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegistrarQueso regqueso = new RegistrarQueso("Registrar Queso",null, option);
				regqueso.setModal(true);
				regqueso.setVisible(true);
			
				
			}
		});
		mnNewMenu.add(mntmRegistrarQuso);
		
		JMenuItem mntmListaDeQuesos = new JMenuItem("Lista de Quesos");
		mntmListaDeQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListQuesos listq = new ListQuesos("Lista de Quesos");
				listq.setModal(true);
				listq.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmListaDeQuesos);
		
		JMenu mnFacturar = new JMenu("Facturar");
		menuBar.add(mnFacturar);
		
		JMenuItem mntmRealizarCompra = new JMenuItem("Realizar Compra");
		mntmRealizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
					ListClientes listclient = new ListClientes("Lista de Clientes Registrados");
				
				
				listclient.setModal(true);
				listclient.setVisible(true);
			
				
				
				
			}
		});
		mnFacturar.add(mntmRealizarCompra);
		
		JMenuItem mntmVerCompras = new JMenuItem("Ver Compras");
		mntmVerCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				ListClientesVentas lis = new ListClientesVentas("Lista de Cliente con Ventas");
				lis.setModal(true);
				lis.setVisible(true);
					
				
			}
		});
		mnFacturar.add(mntmVerCompras);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 635, 1362, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGanancias = new JLabel("Ganancias:");
		lblGanancias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGanancias.setBounds(10, 11, 73, 27);
		panel.add(lblGanancias);
		
		gananciasV = new JTextField();
		gananciasV.setForeground(Color.RED);
		gananciasV.setEditable(false);
		gananciasV.setBounds(104, 16, 109, 20);
		panel.add(gananciasV);
		gananciasV.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				guarda(complejo, Complejo.getComplejo());
				creaFact(factura);
				dispose();
			}
		});
		btnSalir.setBounds(1250, 15, 89, 23);
		panel.add(btnSalir);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 622, 1342, 2);
		contentPane.add(separator);
	
		if(complejo.exists())
		{
			lee(complejo);
		}
		
		ponGanancias();
		
	}
	
	public static void ponGanancias() 
	{
		
		
		
			gananciasV.setText(String.valueOf(Complejo.getComplejo().getGanancias()));
		
		
	}
	

	
	
	
	public void guarda(File ar, Complejo comp)
	{
		FileOutputStream fos = null;
		ObjectOutputStream escritor = null;
		try
		{
			fos = new FileOutputStream(ar);
			escritor = new ObjectOutputStream(fos);
			
			escritor.writeObject(comp);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				if(escritor != null)
				{
					escritor.close();
				}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public void lee(File ar)
	{
		try
		{
			FileInputStream fis = new FileInputStream(ar);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Complejo aux = (Complejo)ois.readObject();
			Complejo.setComplejo(aux);
			ois.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void creaFact(File ar)
	{
		
	       FileWriter escritor;
			try {
				escritor = new FileWriter(ar);
				
				
				escritor.append("Cliente");
				escritor.append(System.lineSeparator());
				escritor.append("Nombre: " + Complejo.getComplejo().getLastvent().getClient().getNombre());
				escritor.append(System.lineSeparator());
				escritor.append("Cedula: " + Complejo.getComplejo().getLastvent().getClient().getCedula());
				escritor.append(System.lineSeparator());
				escritor.append("Telefono: " + Complejo.getComplejo().getLastvent().getClient().getTelefono());
				escritor.append(System.lineSeparator());
				escritor.append("Direccion: " + Complejo.getComplejo().getLastvent().getClient().getDireccion());
				escritor.append(System.lineSeparator());
				escritor.append("Quesos");
				for (Queso q : Complejo.getComplejo().getLastques()) {
					
					escritor.append("ID: " + q.getId());
					escritor.append(System.lineSeparator());
					if( q instanceof QuesoEsferico)
					{
						escritor.append("Tipo: Esferico");
					}
					else if( q instanceof QuesoCilindrico)
					{
						escritor.append("Tipo: Cilindrico");
					}
					else
					{
						escritor.append("Tipo: Cilindrico Hueco");
					}
					escritor.append(System.lineSeparator());
					escritor.append("Volumen: " + q.volumen());
					escritor.append(System.lineSeparator());
					escritor.append("Precio: " + q.precio());
					escritor.append(System.lineSeparator());
					
					
				}
				escritor.append("Sub-Total: " + Complejo.getComplejo().getLastvent().getSubtotal());
				escritor.append(System.lineSeparator());
				escritor.append("Total: " + Complejo.getComplejo().getLastvent().getPreciototal());
				escritor.append(System.lineSeparator());
		           
		        // Cierra el stream
		        escritor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Se ha escrito la factura");
	}
}
