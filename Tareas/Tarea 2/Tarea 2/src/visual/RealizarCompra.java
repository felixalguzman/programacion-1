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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class RealizarCompra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private static JTable table;
	private JButton btnSeleccionar ;
	private  String id;
	private int[] selected;
	private ArrayList<Queso>listQueso;
	private Cliente cliente = null;
	private static int j;
	private int idVent = 0;
	

	
	public RealizarCompra()
	{
		this.listQueso = new ArrayList<Queso>();
	}
	
	/**
	 * Create the dialog.
	 * @param client 
	 */
	public RealizarCompra(String title, Ventas vent,  Cliente client) {
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

		public Class getColumnClass(int column){
			 switch (column) {
             case 0:
                 return String.class;
             case 1:
                 return Float.class;
             case 2:
                 return Float.class;
             case 3:
                 return Float.class;
             default:
                 return Boolean.class;
             case 5:
            	 return String.class;
         }
		}};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(table.getSelectedRowCount() >= 0)
				{
					btnSeleccionar.setEnabled(true);
					 selected = table.getSelectedRows();
							
					for(int i =0; i < Complejo.getComplejo().getListaquesos().size();i++)
					{
						j = selected[i];
						id = (String) table.getValueAt(j, 0);
						Queso q = Complejo.getComplejo().findQueso(id);
						
						if( q.isIscomp() == false )
						{
							q.setIscomp(true);
							
						}
						else
						{
							q.setIscomp(false);
						}
						
					
						
						Complejo.getComplejo().modificarQueso(q);
						
					}
					
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
					
						
						idVent++;
						ven.setId(idVent);
						for(int i =0; i < Complejo.getComplejo().getListaquesos().size();i++)
						{
							if(Complejo.getComplejo().getListaquesos().get(i).isIscomp()==true)
							{
								System.out.println("Codigo queso: " + Complejo.getComplejo().getListaquesos().get(i).getId());
							}
							
							if(Complejo.getComplejo().getListaquesos().get(i).isIscomp()==true)
							{
								Queso q = Complejo.getComplejo().getListaquesos().get(i);
								
								listQueso.add(Complejo.getComplejo().getListaquesos().get(i));
								ven.setListaquesosventa(listQueso);
								//ven.setQ(q);
								Complejo.getComplejo().registrarVenta(ven);
								
								
								Complejo.getComplejo().deleteQueso(q);
							}
							
							
							//Complejo.getComplejo().deleteQueso(q);
						}
						
						
						
						
						JOptionPane.showMessageDialog(null, "Venta realizada satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						cargarQuesos();
					
					
					
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
					fila[2] = Complejo.getComplejo().getListaquesos().get(i).volumenEsferico();
					fila[3] = Complejo.getComplejo().getListaquesos().get(i).precio();
					fila[4] = Complejo.getComplejo().getListaquesos().get(i).isIscomp();
					
					
					
					tableModel.addRow(fila);
				

				
			}
			

					
		
	}



	public ArrayList<Queso> getListQueso() {
		return listQueso;
	}



	public void setListQueso(ArrayList<Queso> listQueso) {
		this.listQueso = listQueso;
	}
	
	


}
