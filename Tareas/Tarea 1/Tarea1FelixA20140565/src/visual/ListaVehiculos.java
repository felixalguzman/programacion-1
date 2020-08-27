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

public class ListaVehiculos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	static Object[] fila;
	private static Vendedor vend;
	private static Suministrador sumi;
	private JButton cancelButton;
	private JButton eliminarButton;
	private static JTable table;
	private String modelo;
	private String codigo;
	private JButton modificarButton;
	private int indice;
	
	

	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaVehiculos(Vendedor pvend, String title) {
		this.vend = pvend;
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 478, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"Marca", "Color", "Carro", "Modelo", "Precio", "Pais","Codigo"};
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
						indice = index;
						modelo = (String)table.getModel().getValueAt(index, 3);
						codigo = (String)table.getModel().getValueAt(index, 6);
						
					}
					
				}
			});
			table.setModel(tableModel);
			scrollPane.setViewportView(table);
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 312, 472, 41);
			contentPanel.add(buttonPane);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			{
				buttonPane.setLayout(null);
			}
			{
				cancelButton = new JButton("Salir");
				cancelButton.setBounds(382, 11, 80, 23);
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
					
					
					Vehiculo vehiculos = vend.encontrarVehiculo(modelo, indice);
					vend.eliminarVehiculo(vehiculos, indice);
					JOptionPane.showMessageDialog(null, "Vehiculo eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
					cargarVehiculo();
				}
			});
			eliminarButton.setBounds(292, 11, 80, 23);
			buttonPane.add(eliminarButton);
			
			modificarButton = new JButton("Modificar");
			modificarButton.setEnabled(false);
			modificarButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow() >= 0)
					{	
									
						Vehiculo vehiculo = vend.encontrarVehiculo(modelo, indice);
						boolean option = false;
						System.out.println(codigo);
						RegistrarVehiculo regVehiculo = new RegistrarVehiculo(vend, "Modificar Vehiculo", option, vehiculo, sumi);
						regVehiculo.setModal(true);
						regVehiculo.setVisible(true);
						
					}
					
				}
			});
			modificarButton.setBounds(202, 11, 80, 23);
			buttonPane.add(modificarButton);
			//cargarVehiculo();
		}
		cargarVehiculo();
	}

	
		
		public static void cargarVehiculo(){
			tableModel.setRowCount(0);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			
			table.getColumnModel().getColumn(0).setCellRenderer(tcr);
			table.getColumnModel().getColumn(1).setCellRenderer(tcr);
			table.getColumnModel().getColumn(2).setCellRenderer(tcr);
			table.getColumnModel().getColumn(3).setCellRenderer(tcr);
			table.getColumnModel().getColumn(4).setCellRenderer(tcr);
			table.getColumnModel().getColumn(5).setCellRenderer(tcr);
			table.getColumnModel().getColumn(6).setCellRenderer(tcr);
			
			fila = new Object[tableModel.getColumnCount()];
			
			for(int i =0; i < vend.getCantVehiculo();i++)
			{
				
				fila[0] = vend.getVehiculo()[i].getMarca();
				fila[1] = vend.getVehiculo()[i].getColor();
				fila[2] = vend.getVehiculo()[i].getTipo().toString();
				fila[3] = vend.getVehiculo()[i].getModelo();
				fila[4] = vend.getVehiculo()[i].getPrecio();
				fila[5] = vend.getVehiculo()[i].getSuministrador().getPais();
				fila[6] = vend.getVehiculo()[i].getSuministrador().getCodigo();
				tableModel.addRow(fila);
				
				
			}
			
		
	}
}

	
