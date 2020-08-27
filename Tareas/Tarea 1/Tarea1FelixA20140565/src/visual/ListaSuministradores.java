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

import Logical.Suministrador;
import Logical.Vehiculo;
import Logical.Vendedor;

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

public class ListaSuministradores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	static Object[] fila;
	private static Vendedor vend;
	private static Suministrador sumi;
	private JButton cancelButton;
	private JButton eliminarButton;
	private static JTable table;
	private String codigo;
	private JButton modificarButton;
	
	

	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaSuministradores(Vendedor pvend, String title) {
		this.vend = pvend;
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 478, 376);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"Nombre", "Apellido","Pais","Codigo", "Marca"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 290);
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
						int index = table.getSelectedRow();
						codigo = (String)table.getModel().getValueAt(index, 3);
						System.out.println(codigo);
						
					}
					
				}
			});
			table.setModel(tableModel);
			scrollPane.setViewportView(table);
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 312, 472, 35);
			contentPanel.add(buttonPane);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			{
				buttonPane.setLayout(null);
			}
			{
				cancelButton = new JButton("Salir");
				cancelButton.setBounds(384, 7, 65, 23);
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
					
 
					vend.eliminarSuministrador(vend.encontrarSuministrador(codigo));
					JOptionPane.showMessageDialog(null, "Suministrador eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
					cargarSuministrador();
				}
			});
			eliminarButton.setBounds(274, 7, 89, 23);
			buttonPane.add(eliminarButton);
			
			modificarButton = new JButton("Modificar");
			modificarButton.setEnabled(false);
			modificarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow() >= 0)
					{	
						
						boolean option = false;
						Suministrador sum =  vend.encontrarSuministrador(codigo);
						RegistrarSuministrador summodi = new RegistrarSuministrador(vend, "Modificar Suministrador", option, sum);
						summodi.setModal(true);
						summodi.setVisible(true);
						dispose();
						
					}
					
				}
			});
			modificarButton.setBounds(164, 7, 89, 23);
			buttonPane.add(modificarButton);
			
			JButton btnAgregarNuevo = new JButton("Agregar Nuevo");
			btnAgregarNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean option = true;
					RegistrarSuministrador reg = new RegistrarSuministrador(vend, "Registrar Suministrador", option, null);
					reg.setModal(true);
					reg.setVisible(true);
					cargarSuministrador();
				}
			});
			btnAgregarNuevo.setBounds(21, 7, 122, 23);
			buttonPane.add(btnAgregarNuevo);
			
		}
		cargarSuministrador();
	}

	
		
		public static void cargarSuministrador(){
			tableModel.setRowCount(0);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			
			table.getColumnModel().getColumn(0).setCellRenderer(tcr);
			table.getColumnModel().getColumn(1).setCellRenderer(tcr);
			table.getColumnModel().getColumn(2).setCellRenderer(tcr);
			table.getColumnModel().getColumn(3).setCellRenderer(tcr);
			table.getColumnModel().getColumn(4).setCellRenderer(tcr);
			
			fila = new Object[tableModel.getColumnCount()];
			
			for(int i =0; i < vend.getCantSuministrador();i++)
			{
				
				fila[0] = vend.getListasuministrador()[i].getNombre();
				fila[1] = vend.getListasuministrador()[i].getApellido();
				fila[2] = vend.getListasuministrador()[i].getPais();
				fila[3] = vend.getListasuministrador()[i].getCodigo();
				fila[4] = vend.getListasuministrador()[i].getMarca();
				
				
				tableModel.addRow(fila);
				
				
			}
			
		
	}
}

	
