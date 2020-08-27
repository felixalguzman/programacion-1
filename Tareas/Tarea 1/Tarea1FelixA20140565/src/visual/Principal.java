package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Suministrador;
import Logical.Vendedor;
import Logical.Venta;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Vendedor vend;
	private Suministrador sumi;
	private Venta vent;
	private String fecha;
	private Dimension dim;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendedor vend = new Vendedor();
					Principal frame = new Principal(vend);
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
	public Principal(Vendedor pVend) {
		setTitle("Empresa de automoviles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.vend = pVend;
		//this.vent = pVenta;
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCarrosEnVenta = new JMenu("Carros en Venta");
		menuBar.add(mnCarrosEnVenta);
		
		JMenuItem mntmRegistrarCarros = new JMenuItem("Registrar Vehiculo");
		mntmRegistrarCarros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegistrarVehiculo vehiculo = new RegistrarVehiculo(vend, "Registrar Vehiculo",option, null ,sumi);
				vehiculo.setModal(true);
				vehiculo.setVisible(true);
				
			}
		});
		mnCarrosEnVenta.add(mntmRegistrarCarros);
		
		JMenuItem mntmListadoDeVehiculos = new JMenuItem("Listado de Vehiculos");
		mntmListadoDeVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaVehiculos lista = new ListaVehiculos(vend, "Listado de Vehiculos en venta");
				lista.setModal(true);
				lista.setVisible(true);
				
				
			}
		});
		
		JMenuItem mntmRegistrarSuministrador = new JMenuItem("Registrar Suministrador");
		mntmRegistrarSuministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegistrarSuministrador sumi = new RegistrarSuministrador(vend, "Registrar Suministrador", option, null);
				sumi.setModal(true);
				sumi.setVisible(true);
				
			}
		});
		mnCarrosEnVenta.add(mntmRegistrarSuministrador);
		mnCarrosEnVenta.add(mntmListadoDeVehiculos);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenuItem mntmListadorDeSuministradores = new JMenuItem("Listado de Suministradores");
		mntmListadorDeSuministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListaSuministradores lista = new ListaSuministradores(vend, "Lista de Suministradores");
				lista.setModal(true);
				lista.setVisible(true);
				
			}
		});
		mnCarrosEnVenta.add(mntmListadorDeSuministradores);
		mnCarrosEnVenta.add(mntmSalir);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		JMenuItem mntmRealizarVenta = new JMenuItem("Realizar Venta");
		mntmRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				VehiculosVenta lista = new VehiculosVenta(vend, "Vehiculos en venta", vent);
				lista.setModal(true);
				lista.setVisible(true);
				
				
			}
		});
		mnVentas.add(mntmRealizarVenta);
		
		JMenuItem mntmListaDeVentas = new JMenuItem("Lista de Ventas");
		mntmListaDeVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ListaVentas listaven = new ListaVentas(vend, "Lista de Ventas");
				listaven.setModal(true);
				listaven.setVisible(true);
				
			}
		});
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegistrarCliente regCliente = new RegistrarCliente(vend, "Registrar Cliente", option, null, 0);
				regCliente.setModal(true);
				regCliente.setVisible(true);
				
			}
		});
		mnVentas.add(mntmRegistrarCliente);
		
		JMenuItem mntmListaDeClientes = new JMenuItem("Lista de Clientes");
		mntmListaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				
				ListaClientes listacli = new ListaClientes(vend, "Lista de Clientes", option, vent, null);
				listacli.setModal(true);
				listacli.setVisible(true);
			}
		});
		mnVentas.add(mntmListaDeClientes);
		mnVentas.add(mntmListaDeVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
	}
}
