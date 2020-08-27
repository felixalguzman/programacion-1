package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import logical.Cliente;
import logical.Complejo;
import logical.Queso;
import logical.QuesoCilindrico;
import logical.Ventas;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class ListCompras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private static JTable table;
	private String cedula;
	private JTextField nombreClienteVenta;
	private JTextField direccionClienteVenta;
	private JTextField cedulaClienteVenta;
	private JTextField telefonoClienteVenta;
	private static JTextField totalP;
	private Cliente myclient;
	private Ventas vent;
	/**
	 * Create the dialog.
	 */
	public ListCompras(String title, Cliente client, Ventas v) {
		setTitle(title);
		setBounds(100, 100, 672, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setLayout(null);
		this.myclient = client;
		this.vent = v;
		String[] columnsHeaders = { "ID", "Radio", "Volumen", "Precio"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 171, 646, 223);
		contentPanel.add(scrollPane_1);
	
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow() >= 0)
				{
					
				}
			
				
			}
		});
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 27, 646, 121);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 31, 61, 14);
		panel.add(lblNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 76, 61, 14);
		panel.add(lblDireccin);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(225, 31, 61, 14);
		panel.add(lblCedula);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(434, 31, 61, 14);
		panel.add(lblTelefono);
		
		nombreClienteVenta = new JTextField();
		nombreClienteVenta.setEditable(false);
		nombreClienteVenta.setBounds(70, 28, 109, 20);
		panel.add(nombreClienteVenta);
		nombreClienteVenta.setColumns(10);
		
		direccionClienteVenta = new JTextField();
		direccionClienteVenta.setEditable(false);
		direccionClienteVenta.setBounds(69, 74, 550, 20);
		panel.add(direccionClienteVenta);
		direccionClienteVenta.setColumns(10);
		
		cedulaClienteVenta = new JTextField();
		cedulaClienteVenta.setEditable(false);
		cedulaClienteVenta.setBounds(296, 28, 109, 20);
		panel.add(cedulaClienteVenta);
		cedulaClienteVenta.setColumns(10);
		
		telefonoClienteVenta = new JTextField();
		telefonoClienteVenta.setEditable(false);
		telefonoClienteVenta.setBounds(510, 28, 109, 20);
		panel.add(telefonoClienteVenta);
		telefonoClienteVenta.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 418, 75, 19);
		contentPanel.add(lblTotal);
		
		totalP = new JTextField();
		totalP.setForeground(Color.RED);
		totalP.setEditable(false);
		totalP.setEnabled(false);
		totalP.setBounds(52, 417, 86, 20);
		contentPanel.add(totalP);
		totalP.setColumns(10);
		
		JButton button = new JButton("Salir");
		button.setBounds(551, 416, 105, 23);
		contentPanel.add(button);
		cargarCompras();
		cargaCliente();
	}
	
	

	public static void cargarCompras()
	{
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		
		
		fila = new Object[tableModel.getColumnCount()];
		
		
			
			for(int i =0; i < Complejo.getComplejo().getListaventas().size(); i++)
			{
				
				
					fila[0] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(i).getId();
					fila[1] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(i).getRadio();
					fila[2] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(i).volumenEsferico();
					fila[3] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(i).precio();
				
					
					
				
					
					tableModel.addRow(fila);
				

				
			}
			
			
			
			
					
		
	}
	
	public void cargaCliente()
	{
		nombreClienteVenta.setText(myclient.getNombre());
		cedulaClienteVenta.setText(myclient.getCedula());
		telefonoClienteVenta.setText(myclient.getTelefono());
		direccionClienteVenta.setText(myclient.getDireccion());
		totalP.setText(String.valueOf(Complejo.getComplejo().precioTotalfact(vent)));
		
		
	}
}
