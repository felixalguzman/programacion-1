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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import logical.Embarcadero;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Embarcadero emb;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Embarcadero emb = new Embarcadero();
					Principal frame = new Principal(emb);
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
	public Principal(Embarcadero pEmb) {
		setTitle("Empresa Embarcadero VIP s.a");
		this.emb = pEmb;
		System.out.println("La ganancia del embarcadero es:" + emb.calcularGanancia());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 443);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegCliente cliente = new RegCliente(emb,"Registra Cliente",option,null);
				cliente.setModal(true);
				cliente.setVisible(true);
				
			}
		});
		mnClientes.add(mntmRegistrarCliente);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listCliente listado = new listCliente(emb);
				listado.setModal(true);
				listado.setVisible(true);
			}
		});
		mnClientes.add(mntmListadoDeClientes);
		
		JMenu mnAlquileres = new JMenu("Alquileres");
		menuBar.add(mnAlquileres);
		
		JMenuItem mntmResgistrarAlquiler = new JMenuItem("Resgistrar Alquiler");
		mntmResgistrarAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegAlquiler alquiler = new RegAlquiler(emb);
				alquiler.setModal(true);
				alquiler.setVisible(true);
			}
		});
		mnAlquileres.add(mntmResgistrarAlquiler);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 691, 1018, 28);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy - HH:mm:ss ");
		JLabel fecha = new JLabel();
		fecha.setText(format.format(date));
		fecha.setBounds(10, 7, 190, 14);
		panel.add(fecha);
	}
}
