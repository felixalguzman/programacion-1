package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.IIOException;
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
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListClientes extends JDialog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  boolean paso = false;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private JButton btnModificar ;
	private JButton btnEliminar;
	private static JTable table;
	private JButton btnAgregarNuevo;
	private JButton btnSeleccionar ;
	private String cedula;
	/**
	 * Create the dialog.
	 */
	public ListClientes(String title){
		setTitle(title);
		setBounds(100, 100, 618, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = { "Cedula", "Nombre", "Telefono"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 592, 256);
		contentPanel.add(scrollPane_1);
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow() >= 0)
				{
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					btnSeleccionar.setEnabled(true);
					int index = table.getSelectedRow();
					cedula = (String)table.getModel().getValueAt(index, 0);

				}
			
				
			}
		});
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 298, 612, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBounds(495, 11, 105, 23);
			buttonPane.add(btnSalir);
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Cliente client = Complejo.getComplejo().findCliente(cedula);
					boolean option = false;
					RegistrarClientes regclient = new RegistrarClientes("Modificar Cliente", client, option);
					regclient.setModal(true);
					regclient.setVisible(true);
					
					
				}
			});
			btnModificar.setEnabled(false);
			btnModificar.setBounds(381, 11, 105, 23);
			buttonPane.add(btnModificar);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Cliente client = Complejo.getComplejo().findCliente(cedula);
					Complejo.getComplejo().deleteClient(client);
					JOptionPane.showMessageDialog(null, "Cliente eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
					cargarClientes();
					
					if(Complejo.getComplejo().getListaclientes().isEmpty())
					{
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setBounds(267, 11, 105, 23);
			buttonPane.add(btnEliminar);
			
			btnAgregarNuevo = new JButton("Agregar Nuevo");
			btnAgregarNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean option = true;
					RegistrarClientes  regclient = new RegistrarClientes("Registrar Clientes", null, option);
					regclient.setModal(true);
					regclient.setVisible(true);
					cargarClientes();
				}
			});
			btnAgregarNuevo.setBounds(9, 11, 135, 23);
			buttonPane.add(btnAgregarNuevo);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente client = Complejo.getComplejo().findCliente(cedula);
					RealizarCompra reacomp = null;
					reacomp = new RealizarCompra("Lista de Quesos para Comprar", null, client);
					reacomp.setModal(true);
					reacomp.setVisible(true);
					
					
				}
			});
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.setBounds(153, 11, 105, 23);
			buttonPane.add(btnSeleccionar);
		}
		
		cargarClientes();
	}
	
	

	public static void cargarClientes()
	{
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		
		
		fila = new Object[tableModel.getColumnCount()];
		
		
			
			for(int i =0; i < Complejo.getComplejo().getListaclientes().size(); i++)
			{
				
					
					fila[0] = Complejo.getComplejo().getListaclientes().get(i).getCedula();
					fila[1] = Complejo.getComplejo().getListaclientes().get(i).getNombre();
					fila[2] = Complejo.getComplejo().getListaclientes().get(i).getTelefono();
				
					
					tableModel.addRow(fila);
				

				
			}
			

					
		
	}
	
	
	
}
