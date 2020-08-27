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



public class VerDetallesVenta extends JDialog {
	private static DefaultTableModel tableModel;
	static Object[] fila;
	
	private static Vendedor vend;
	private static Venta venta;
	private static Venta myVenta;
	private JTextField colorVehiculoCliente;
	private JTextField modeloVehiculoCliente;
	private JTextField precioVehiculoCliente;
	private static JTextField nombreCliente;
	private static JTextField direccionCliente;
	private static JTextField apellidoCliente;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private static JFormattedTextField clienteCedula;
	private static JFormattedTextField clienteTelefono;
	private static JButton okbutton;
	private static Clientes mycliente = null;
	private Venta vent = null;
	private static Vehiculo vehi;
	private JTextField fechaCliente;
	private static JTextField montoCliente;
	private static JTextField codigoVenta;
	private static boolean option1;
	private int codigo;
	private int verDetalles;

	/**
	 * Launch the application.
	 */
	
	
	

	/**
	 * Create the dialog.
	 * 
	 */
	public VerDetallesVenta(Vendedor pvend, String title,  boolean option,  Clientes client, Venta pventa, Vehiculo vehiculo, int verSoloDetalles) {
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 488, 463);
		getContentPane().setLayout(null);
		this.vend = pvend;
		this.vehi = vehiculo;
		this.mycliente = client;
		this.vent = pventa;
		this.option1 = option;
		this.verDetalles = verSoloDetalles;
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 393, 482, 42);
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
		
	
		
		if(verDetalles == 0)
		{
			System.out.println("funciona");
		}
		okbutton = new JButton("OK");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
					Clientes client = new Clientes();
					Venta venta = new Venta();
					
					client.setNombre(nombreCliente.getText());
					client.setApellido(apellidoCliente.getText());
					client.setCedula(clienteCedula.getText());
					client.setTelefono(clienteTelefono.getText());
					client.setDireccion(direccionCliente.getText());
					venta.setFecha(fechaCliente.getText());
					venta.setMonto(vehi.getPrecio());
					//venta.setCodigo(venta.getCodigo());
					
					VehiculosVenta.cargarVehiculo();
					dispose();
			
			}
			
		});
		okbutton.setBounds(276, 11, 89, 23);
		panel.add(okbutton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 472, 388);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos del Vehiculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 201, 462, 70);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(160, 32, 46, 14);
		panel_2.add(lblColor);
		
		colorVehiculoCliente = new JTextField();
		colorVehiculoCliente.setBounds(205, 29, 86, 20);
		colorVehiculoCliente.setEditable(false);
		panel_2.add(colorVehiculoCliente);
		colorVehiculoCliente.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 32, 46, 14);
		panel_2.add(lblModelo);
		
		modeloVehiculoCliente = new JTextField();
		modeloVehiculoCliente.setBounds(64, 29, 86, 20);
		modeloVehiculoCliente.setEditable(false);
		panel_2.add(modeloVehiculoCliente);
		modeloVehiculoCliente.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(301, 32, 46, 14);
		panel_2.add(lblPrecio);
		
		precioVehiculoCliente = new JTextField();
		precioVehiculoCliente.setBounds(346, 29, 86, 20);
		precioVehiculoCliente.setEditable(false);
		panel_2.add(precioVehiculoCliente);
		precioVehiculoCliente.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 21, 462, 158);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 72, 54, 14);
		panel_3.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 29, 54, 14);
		panel_3.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(234, 29, 54, 14);
		panel_3.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 115, 67, 14);
		panel_3.add(lblDireccion);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(66, 24, 127, 20);
		panel_3.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		direccionCliente = new JTextField();
		direccionCliente.setBounds(74, 112, 373, 20);
		panel_3.add(direccionCliente);
		direccionCliente.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(234, 72, 54, 14);
		panel_3.add(lblTelefono);
		
		apellidoCliente = new JTextField();
		apellidoCliente.setBounds(298, 24, 127, 20);
		panel_3.add(apellidoCliente);
		apellidoCliente.setColumns(10);
		
		clienteCedula = new JFormattedTextField(patron);
		clienteCedula.setBounds(66, 68, 127, 20);
		panel_3.add(clienteCedula);
		
		clienteTelefono = new JFormattedTextField(tele);
		clienteTelefono.setBounds(298, 68, 127, 20);
		panel_3.add(clienteTelefono);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Datos de la Venta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 282, 462, 95);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(10, 22, 46, 14);
		panel_4.add(lblFecha);
		
		JLabel lblMontoAPagar = new JLabel("Monto a pagar:");
		lblMontoAPagar.setBounds(248, 22, 86, 14);
		panel_4.add(lblMontoAPagar);
		
		fechaCliente = new JTextField();
		fechaCliente.setEditable(false);
		fechaCliente.setBounds(55, 18, 153, 20);
		panel_4.add(fechaCliente);
		fechaCliente.setColumns(10);
		
		montoCliente = new JTextField();
		montoCliente.setEditable(false);
		montoCliente.setBounds(344, 18, 75, 20);
		panel_4.add(montoCliente);
		montoCliente.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 58, 46, 14);
		panel_4.add(lblCodigo);
		
		codigoVenta = new JTextField();
		codigoVenta.setEditable(false);
		codigoVenta.setBounds(55, 56, 103, 20);
		panel_4.add(codigoVenta);
		codigoVenta.setColumns(10);
		
		codigoVenta.setText("0");
		cargarFecha();
		cargarDatosdeVenta();
		cargarDatosVehiculoCliente();
		
	}
	
	public void cargarDatosVehiculoCliente()
	{
		modeloVehiculoCliente.setText(vehi.getModelo());
		colorVehiculoCliente.setText(vehi.getColor());
		precioVehiculoCliente.setText(String.valueOf(vehi.getPrecio()));
		montoCliente.setText(String.valueOf(vehi.getPrecio()));
		
	}
	

	public void cargarFecha()
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy - HH:mm:ss ");
		fechaCliente.setText(format.format(date));
	}
	
	public static Venta retornaVenta()
	{
		return venta;
		
	}
	
	public static void cargarDatosdeVenta()
	{
		if(!option1)
		{
			okbutton.setEnabled(true);
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
			montoCliente.setText(String.valueOf(vehi.getPrecio()));
			codigoVenta.setText(String.valueOf(vend.getCantVenta()));
		}
			
			
			
			
	}
}
