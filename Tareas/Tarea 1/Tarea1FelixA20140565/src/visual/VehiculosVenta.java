package visual;

import java.awt.BorderLayout;
import java.awt.Dialog;
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

public class VehiculosVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	static Object[] fila;
	private static Vendedor vend;
	private static Venta vent;
	private JButton cancelButton;
	private static JTable table;
	private String modelo;
	private JButton btnComprarVehiculo;
	private static Vehiculo vehi;
	private int indice;
	

	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public VehiculosVenta(Vendedor pvend, String title, Venta pventa) {
		this.vend = pvend;
		this.vent = pventa;
		//this.vehi = vehiculo;
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 478, 376);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"Color", "Carro", "Modelo", "Precio"};
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
						btnComprarVehiculo.setEnabled(true);
						
						int index = table.getSelectedRow();
						indice = index;
						modelo = (String)table.getModel().getValueAt(index, 2);
						
						
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
				cancelButton.setBounds(397, 7, 65, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			btnComprarVehiculo = new JButton("Comprar Vehiculo");
			btnComprarVehiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{   
					vehi = vend.encontrarVehiculo(modelo, indice);
					
					boolean option = true;
					Vehiculo vehi = vend.encontrarVehiculo(modelo, indice);
					//System.out.println(vend.getCantVenta()+1);
					//vent.setCodigo(vend.getCantVenta()+1);
					
					ListaClientes listclient = new ListaClientes(vend,"Seleccione el Cliente para la Venta", option, vent, vehi);
					listclient.setModal(true);
					listclient.setVisible(true);
					btnComprarVehiculo.setEnabled(false);
					
					/*
					RegistrarCliente venta = new RegistrarCliente(vend, "Registrar Cliente", option, null);
					venta.setModal(true);
					venta.setVisible(true);*/
					
			
					
					
					
					
				}
			});
			btnComprarVehiculo.setEnabled(false);
			btnComprarVehiculo.setBounds(238, 7, 145, 23);
			buttonPane.add(btnComprarVehiculo);
			
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
		
		fila = new Object[tableModel.getColumnCount()];
		
		for(int i =0; i < vend.getCantVehiculo();i++)
		{
			
			fila[0] = vend.getVehiculo()[i].getColor();
			fila[1] = vend.getVehiculo()[i].getTipo().toString();
			fila[2] = vend.getVehiculo()[i].getModelo();
			fila[3] = vend.getVehiculo()[i].getPrecio();
			tableModel.addRow(fila);
			
			
		}
		
	
}

	
}

	
