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

public class ListaVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	static Object[] fila;
	private static Vendedor vend;
	private static Suministrador sumi;
	private  Vehiculo vehi;
	private Venta vent;
	private JButton cancelButton;
	private JButton verDetallesVenta;
	private static JTable table;
	private int indice;
	private String cedula;

	
	

	
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaVentas(Vendedor pvend, String title) {
		this.vend = pvend;
		setTitle(title);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 599, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"Codigo", "Fecha","Monto","Cedula", "Nombre", "Telefono"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 573, 290);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(table.getSelectedRow() >= 0)
					{
						verDetallesVenta.setEnabled(true);
						int index = table.getSelectedRow();
						indice = index;
						cedula = (String)table.getModel().getValueAt(index, 3);
						
						
					}
					
				}
			});
			table.setModel(tableModel);
			scrollPane.setViewportView(table);
		}
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 322, 593, 44);
			contentPanel.add(buttonPane);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			{
				buttonPane.setLayout(null);
			}
			{
				cancelButton = new JButton("Salir");
				cancelButton.setBounds(468, 11, 115, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			verDetallesVenta = new JButton("Ver Detalles");
			verDetallesVenta.setEnabled(false);
			verDetallesVenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Clientes client = vend.encontrarCliente(cedula, indice);
					vehi = RegistrarVehiculo.retornarVehiculo();
					vent = RegistrarCliente.retornaVenta();
					boolean option = false;
					
					VerDetallesVenta clie = new VerDetallesVenta(vend, "Detalles de la Venta", option, client, vent, vehi, 0);
					RegistrarCliente.cargarDatosdeClienteParaVenta();
					clie.setModal(true);
					clie.setVisible(true);
					
				}
			});
			verDetallesVenta.setBounds(343, 11, 115, 23);
			buttonPane.add(verDetallesVenta);
			
		}
		cargarVentas();
	}

	
		
		public static void cargarVentas(){
			
			tableModel.setRowCount(0);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			
			table.getColumnModel().getColumn(0).setCellRenderer(tcr);
			table.getColumnModel().getColumn(1).setCellRenderer(tcr);
			table.getColumnModel().getColumn(2).setCellRenderer(tcr);
			table.getColumnModel().getColumn(3).setCellRenderer(tcr);
			table.getColumnModel().getColumn(4).setCellRenderer(tcr);
			table.getColumnModel().getColumn(5).setCellRenderer(tcr);
			
			
			fila = new Object[tableModel.getColumnCount()];
			
			for(int i =0; i < vend.getCantVenta();i++)
			{
				
				fila[0] = vend.getListaventa()[i].getCodigo();
				fila[1] = vend.getListaventa()[i].getFecha();
				fila[2] = vend.getListaventa()[i].getMonto();
				//fila[3] = vend.getListaventa()[i].
				fila[4] = vend.getListaclientes()[i].getNombre();
				fila[5] = vend.getListaclientes()[i].getTelefono();
				
				
				
				tableModel.addRow(fila);
				
				
			}
			
		
	}
}

	
