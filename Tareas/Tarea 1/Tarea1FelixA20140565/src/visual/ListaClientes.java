package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Logical.Clientes;
import Logical.Suministrador;
import Logical.Vehiculo;
import Logical.Vendedor;
import Logical.Venta;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ListaClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	static Object[] fila;
	private static Vendedor vend;
	private static Suministrador sumi;
	private static Venta vent;
	private  boolean option;
	private int detalles;
	private static Vehiculo vehi;
	private JButton cancelButton;
	private JButton eliminarButton;
	private JButton btnAgregarNuevo;
	private static JTable table;
	private String cedula;
	private JButton modificarButton;
	private JButton btnSeleccionar;
	private int indice;
	private int entrar=0;
	

	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaClientes(Vendedor pvend, String title, boolean option, Venta pvent, Vehiculo pvehi) {
		this.vend = pvend;
		this.vent = pvent;
		this.vehi = pvehi;
		this.option = option;
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 631, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"Cedula", "Nombre","Apellido","Telefono"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 605, 290);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(table.getSelectedRow() >= 0)
					{
						eliminarButton.setEnabled(true);
						modificarButton.setEnabled(true);
						btnSeleccionar.setEnabled(true);
						int index = table.getSelectedRow();
						indice = index;
						cedula = (String)table.getModel().getValueAt(index, 0);
						System.out.println(cedula);
						
					}
					
				}
			});
			table.setModel(tableModel);
			scrollPane.setViewportView(table);
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 342, 625, 35);
			contentPanel.add(buttonPane);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			{
				buttonPane.setLayout(null);
			}
			{
				cancelButton = new JButton("Salir");
				cancelButton.setBounds(530, 6, 65, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			eliminarButton = new JButton("Eliminar");
			eliminarButton.setEnabled(false);
			eliminarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
 
					vend.eliminarCliente(vend.encontrarCliente(cedula, indice));
					JOptionPane.showMessageDialog(null, "Cliente eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
					cargarCliente();
				}
			});
			eliminarButton.setBounds(416, 6, 89, 23);
			buttonPane.add(eliminarButton);
			
			modificarButton = new JButton("Modificar");
			modificarButton.setEnabled(false);
			modificarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow() >= 0)
					{	
						
						boolean option = false;
						Clientes clie =  vend.encontrarCliente(cedula, indice);
						entrar=1;
						RegistrarCliente cliemodi = new RegistrarCliente(vend, "Modificar Cliente", option, clie, entrar);
						cliemodi.setModal(true);
						cliemodi.setVisible(true);
						cargarCliente();
						
					}
					
				}
			});
			modificarButton.setBounds(302, 6, 89, 23);
			buttonPane.add(modificarButton);
			
			btnAgregarNuevo = new JButton("Agregar Nuevo");
			btnAgregarNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					boolean option = true;
					entrar = 0;
					RegistrarCliente reg = new RegistrarCliente(vend, "Registrar Cliente", option, null, entrar);
					reg.setModal(true);
					reg.setVisible(true);
					cargarCliente();
				}
			});
			btnAgregarNuevo.setBounds(25, 6, 121, 23);
			buttonPane.add(btnAgregarNuevo);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean option = false;
					detalles = 1;
					Clientes cliente = vend.encontrarCliente(cedula, indice);
					RegistrarVenta regventa = new RegistrarVenta(vend, "Registrar Venta", option, cliente, vent, vehi, detalles);
					regventa.setModal(true);
					regventa.setVisible(true);
					dispose();
					
				}
			});
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.setBounds(171, 6, 106, 23);
			buttonPane.add(btnSeleccionar);
			
		}
		cargarCliente();
	}

	
		
		public static void cargarCliente(){
			tableModel.setRowCount(0);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			
			table.getColumnModel().getColumn(0).setCellRenderer(tcr);
			table.getColumnModel().getColumn(1).setCellRenderer(tcr);
			table.getColumnModel().getColumn(2).setCellRenderer(tcr);
			table.getColumnModel().getColumn(3).setCellRenderer(tcr);
			
			
			fila = new Object[tableModel.getColumnCount()];
			
			for(int i =0; i < vend.getCantClientes();i++)
			{
				
				fila[0] = vend.getListaclientes()[i].getCedula();
				fila[1] = vend.getListaclientes()[i].getNombre();
				fila[2] = vend.getListaclientes()[i].getApellido();
				fila[3] = vend.getListaclientes()[i].getTelefono();
				
				
				tableModel.addRow(fila);
				
				
			}
			
		
	}
		
		
}

	
