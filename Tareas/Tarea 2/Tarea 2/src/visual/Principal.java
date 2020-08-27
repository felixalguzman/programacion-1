package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
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
		
		JMenuItem mntmListaDeCompras = new JMenuItem("Lista de Compras");
		mntmListaDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListClientesVentas listcvent = new ListClientesVentas("Lista de Clientes con Compras");
				listcvent.setModal(true);
				listcvent.setVisible(true);
				
			}
		});
		mnFacturar.add(mntmListaDeCompras);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
