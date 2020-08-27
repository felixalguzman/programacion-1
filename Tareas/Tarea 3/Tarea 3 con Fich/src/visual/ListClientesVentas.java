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
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListClientesVentas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private static JTable table;
	private JButton btnSeleccionar ;
	private String cedula;
	private static ArrayList<Queso> lista;
	private static ArrayList<Ventas>listvent;
	private static boolean paso = false;
	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ListClientesVentas(String title){
		
		listvent = new ArrayList<Ventas>();
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
			btnSalir.setBounds(497, 11, 105, 23);
			buttonPane.add(btnSalir);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cliente client = Complejo.getComplejo().findCliente(cedula);
					//Cliente client = Complejo.getComplejo().findClienteFich(cedula, listvent);
					
					Ventas v = Complejo.getComplejo().findVenta(cedula);
					//Ventas v = Complejo.getComplejo().findVentFich(cedula, listvent);
					
					//lista = Complejo.getComplejo().findArrQuesoVent(v);
					
					VerFactura	vf = new VerFactura("Facturas", client, v);
					vf.setModal(true);
					vf.setVisible(true);
			
					
					
					
				}
			});
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.setBounds(382, 11, 105, 23);
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
		
		
		
			for(int i =0; i < Complejo.getComplejo().getListaventas().size(); i++)
			{
				
					
					fila[0] = Complejo.getComplejo().getListaventas().get(i).getClient().getCedula();
					fila[1] = Complejo.getComplejo().getListaventas().get(i).getClient().getNombre();
					fila[2] = Complejo.getComplejo().getListaventas().get(i).getClient().getTelefono();
				
					
					tableModel.addRow(fila);
				

				
			}
			

					
		
	}
}
