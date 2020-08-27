package visual;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class RealizarCompra extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private static JTable table;
	private JButton btnSeleccionar ;
	private Cliente cliente = null;
	private int idVent = 0;
	private int cant=0;	
	private boolean ischecked = false;
	

	

	/**
	 * Create the dialog.
	 * @param client 
	 */
	public RealizarCompra(String title, Ventas vent,  Cliente client)  {
		setTitle(title);
		setBounds(100, 100, 519, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setLayout(null);
		this.cliente = client;
		
		String[] columnsHeaders = { "ID", "Radio", "Volumen", "Precio", "Seleccionado"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 29, 493, 224);
		contentPanel.add(scrollPane_1);
	
		table = new JTable(tableModel){
		
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int column){
			 switch (column) {
             case 0:
                 return Integer.class;
             case 1:
                 return Float.class;
             case 2:
                 return Float.class;
             case 3:
                 return Float.class;
             case 4:
            	 return Boolean.class;
             default:
                 return Boolean.class;
             
         }
		}};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(table.getSelectedRowCount() >= 0)
				{
					btnSeleccionar.setEnabled(true);
					
							
					 
					
					
				}
				
			}
		});
		
		
		
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 278, 513, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBounds(414, 11, 89, 23);
			buttonPane.add(btnSalir);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.setEnabled(false);
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					Ventas ven = new Ventas();
					ven.setClient(cliente);
					float p=0;
					
					idVent++;
					ven.setId(idVent);
					for(int i =0; i < Complejo.getComplejo().getListaquesos().size();i++)
					{
						
						ischecked = (boolean)table.getValueAt(i, 4);
						
						if(ischecked)
						{
							System.out.println("Codigo queso: " + Complejo.getComplejo().getListaquesos().get(i).getId());
						}
							
						
						if(ischecked)
						{
							Queso q = Complejo.getComplejo().getListaquesos().get(i);
							
							Complejo.getComplejo().registrarQpventa(q);
							Complejo.getComplejo().lastq(q);
							cant++;
							//j++;
						}
					
					}
						
						
						ven.setListaquesosventa(Complejo.getComplejo().getListaquesopventa());
						ven.setPreciototal(Complejo.getComplejo().precioTotalconitbi());
						ven.setSubtotal(Complejo.getComplejo().gananciassubTotal());
						ven.setCant(Complejo.getComplejo().cantQuesoVent());
						Complejo.getComplejo().registrarVenta(ven);
						
						
						Complejo.getComplejo().setLastvent(ven);
					
						
						
						for(int j =0; j < Complejo.getComplejo().getListaquesopventa().size() ;j++)
						{
							
							
							Complejo.getComplejo().deleteQueso(Complejo.getComplejo().getListaquesopventa().get(j));
						}
						
						JOptionPane.showMessageDialog(null, "Venta realizada satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);

						cargarQuesos();
						Complejo.getComplejo().limplistapventas();
					
				}
			});
			btnSeleccionar.setBounds(299, 11, 103, 23);
			buttonPane.add(btnSeleccionar);
		}
		
		
		
		cargarQuesos();
	}
	
	

	public static void cargarQuesos()
	{
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		
		
		
		fila = new Object[tableModel.getColumnCount()];
		
		
			
			for(int i =0; i < Complejo.getComplejo().getListaquesos().size(); i++)
			{
				
					
					fila[0] = Complejo.getComplejo().getListaquesos().get(i).getId();
					fila[1] = Complejo.getComplejo().getListaquesos().get(i).getRadio();
					fila[2] = Complejo.getComplejo().getListaquesos().get(i).volumen();
					fila[3] = Complejo.getComplejo().getListaquesos().get(i).precio();
					
					
					
					tableModel.addRow(fila);
				

				
			}
			

					
		
	}


	
	
	
	
	

}
