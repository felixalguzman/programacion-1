package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Logical.Clientes;
import Logical.Vehiculo;
import Logical.Vendedor;
import Logical.Venta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class RegistrarCliente extends JDialog {
	private static DefaultTableModel tableModel;
	static Object[] fila;
	
	private static Vendedor vend;
	private static Venta venta;
	private static Venta myVenta;
	private static JTextField nombreCliente;
	private static JTextField direccionCliente;
	private static JTextField apellidoCliente;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private static JFormattedTextField clienteCedula;
	private static JFormattedTextField clienteTelefono;
	private static JButton btnSalvar;
	private static Clientes mycliente = null;
	private Venta vent = null;
	private static Vehiculo vehi;
	private int codigo;
	private static boolean option1 = true;
	private static int entrar;
	/**
	 * Launch the application.
	 */
	
	
	

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente(Vendedor pvend, String title, boolean option,  Clientes client, int entr) {
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 488, 257);
		getContentPane().setLayout(null);
		this.option1 = option;
		this.entrar = entr;
		this.vend = pvend;
		this.mycliente = client;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 186, 482, 42);
		getContentPane().add(panel);
		
		String[] columnsHeaders = {"Color", "Carro", "Modelo", "Precio"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(375, 11, 97, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.setLayout(null);
		btnCancelar.setActionCommand("Cancel");
		panel.add(btnCancelar);
		
		//vent.setCodigo(1);
		
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(mycliente == null )
			{
				if(!nombreCliente.getText().equalsIgnoreCase("") && clienteCedula.getText().length()==13  && !clienteTelefono.getText().equalsIgnoreCase("") && !direccionCliente.getText().equalsIgnoreCase("") && !apellidoCliente.getText().equalsIgnoreCase(""))
				{
					Clientes client = new Clientes();
					
					
					client.setNombre(nombreCliente.getText());
					client.setApellido(apellidoCliente.getText());
					client.setCedula(clienteCedula.getText());
					client.setTelefono(clienteTelefono.getText());
					client.setDireccion(direccionCliente.getText());
				
					
				
					vend.registrarCliente(client);				
					
					JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
					limpiarDatosCliente();
					dispose();

				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.INFORMATION_MESSAGE, null);
					
					
				}
			}
			else  
			{
				
				
				mycliente.setApellido(apellidoCliente.getText());
				mycliente.setNombre(nombreCliente.getText());
				mycliente.setDireccion(direccionCliente.getText());
				mycliente.setTelefono(String.valueOf(clienteTelefono.getText()));
				mycliente.setCedula(String.valueOf(clienteCedula.getText()));
				
				vend.modificarCliente(mycliente);
				dispose();
				
				
			}
			
			
			}
			
		});
		btnSalvar.setBounds(276, 11, 89, 23);
		panel.add(btnSalvar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 472, 173);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 11, 462, 158);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 72, 54, 14);
		panel_3.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 29, 54, 14);
		panel_3.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(240, 29, 54, 14);
		panel_3.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 115, 64, 14);
		panel_3.add(lblDireccion);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(66, 24, 127, 20);
		panel_3.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		direccionCliente = new JTextField();
		direccionCliente.setBounds(74, 109, 373, 20);
		panel_3.add(direccionCliente);
		direccionCliente.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(240, 72, 54, 14);
		panel_3.add(lblTelefono);
		
		apellidoCliente = new JTextField();
		apellidoCliente.setBounds(320, 23, 127, 20);
		panel_3.add(apellidoCliente);
		apellidoCliente.setColumns(10);
		
		clienteCedula = new JFormattedTextField(patron);
		clienteCedula.setBounds(66, 68, 127, 20);
		panel_3.add(clienteCedula);
		
		clienteTelefono = new JFormattedTextField(tele);
		clienteTelefono.setBounds(320, 66, 127, 20);
		panel_3.add(clienteTelefono);
		
		cargarDatosdeCliente();
	}
	

	
	public void limpiarDatosCliente()
	{
		nombreCliente.setText("");
		apellidoCliente.setText("");
		clienteCedula.setText("");
		clienteTelefono.setText("");
		direccionCliente.setText("");
	}
	
	
	
	public static Venta retornaVenta()
	{
		return venta;
		
	}
	
	public static void cargarDatosdeClienteParaVenta()
	{
		if(!option1)
		{
			btnSalvar.setEnabled(false);
			nombreCliente.setEditable(false);
			apellidoCliente.setEditable(false);
			direccionCliente.setEditable(false);
			clienteCedula.setEditable(false);
			clienteTelefono.setEditable(false);
			nombreCliente.setText(mycliente.getNombre());
			apellidoCliente.setText(mycliente.getApellido());
			direccionCliente.setText(mycliente.getDireccion());
			clienteCedula.setText(mycliente.getCedula());
			clienteTelefono.setText(mycliente.getTelefono());
		}	
			
			
	}
	
	public static void cargarDatosdeCliente()
	{
		if(!option1)
		{
			
			nombreCliente.setText(mycliente.getNombre());
			apellidoCliente.setText(mycliente.getApellido());
			direccionCliente.setText(mycliente.getDireccion());
			clienteCedula.setText(mycliente.getCedula());
			clienteTelefono.setText(mycliente.getTelefono());
		}	
			
			
	}
}
