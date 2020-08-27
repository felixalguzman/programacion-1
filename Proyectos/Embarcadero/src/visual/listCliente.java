package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logical.Clientes;
import logical.Embarcadero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;

public class listCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	private static Embarcadero emb;
	static Object[] fila;
	private static JTable table;
	private JButton btnModify;
	private JButton btnEliminar;
	private String cedula;
	


	/**
	 * Create the dialog.
	 */
	public listCliente(Embarcadero pemb) {
		this.emb = pemb;
		setTitle("Listado de Clientes");
		setBounds(100, 100, 540, 370);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"Cédula","Nomb.Cliente", "Teléfon", "Nomb.Barco", "Tipo"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 515, 283);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(table.getSelectedRow()>=0){
						btnModify.setEnabled(true);
						btnEliminar.setEnabled(true);
						int index = table.getSelectedRow();
						cedula = (String)table.getModel().getValueAt(index, 0);
						
						
					}
				}
			});
			table.setModel(tableModel);
		
			scrollPane.setViewportView(table);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
			    btnModify = new JButton("Modificar");
			    btnModify.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent arg0) {
			    		Clientes client = emb.findClient(cedula);
						boolean option = false;
						RegCliente regClient = new RegCliente(emb,"Modificar Cliente",option,client);
						regClient.setModal(true);
						regClient.setVisible(true);
			    		
			    	}
			    });
				btnModify.setEnabled(false);
				btnModify.setActionCommand("OK");
				buttonPane.add(btnModify);
				getRootPane().setDefaultButton(btnModify);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Clientes client = emb.findClient(cedula);
						emb.deleteClient(client);
						JOptionPane.showMessageDialog(null, "Cliente eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						loadClient();
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadClient();
	}

	public static void loadClient() {
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		
		fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i< emb.getCantidadClientes();i++) {
			fila[0] = emb.getListaClientes()[i].getCedula();
			fila[1] = emb.getListaClientes()[i].getNombre();
			fila[2] = emb.getListaClientes()[i].getTelefono();
			fila[3] = emb.getListaClientes()[i].getBarco().getNombre();
			fila[4] = emb.getListaClientes()[i].getBarco().getTipo().toString();
			tableModel.addRow(fila);
		
	}
}
}
