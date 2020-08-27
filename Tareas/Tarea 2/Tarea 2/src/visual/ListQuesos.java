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
import javax.swing.table.TableModel;

import logical.Complejo;
import logical.Queso;
import logical.QuesoCilindrico;
import logical.QuesoCilindricoHueco;
import logical.QuesoEsferico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ListQuesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private JButton btnModificar ;
	private JButton btnEliminar;
	private static JTable table;
	private static String id;
	private JButton btnAgregarNuevo;
	private JRadioButton rdbtnQuesoEsferico ;
	private JRadioButton rdbtnQuesoCilindrico ;
	private JRadioButton rdbtnQuesoCilindricoHueco;
	private JRadioButton rdbtnTodos;
	private JLabel lblCantidadDeQuesos;
	private static JTextField cantidad;

	/**
	 * Create the dialog.
	 */
	public ListQuesos(String title) {
		setTitle(title);
		setBounds(100, 100, 594, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = { "ID", "Radio", "Volumen", "Precio"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 79, 555, 256);
		contentPanel.add(scrollPane_1);
	
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				int index = table.getSelectedRow();
				id = (String)table.getModel().getValueAt(index, 0);
			}
		});
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 386, 588, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBounds(459, 11, 89, 23);
			buttonPane.add(btnSalir);
			
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Queso queso = Complejo.getComplejo().findQueso(id);
					
										
					boolean option = false;
					RegistrarQueso regqueso = new RegistrarQueso("Modificar Queso", queso, option);
					regqueso.setModal(true);
					regqueso.setVisible(true);
					
				}
			});
			btnModificar.setEnabled(false);
			btnModificar.setBounds(333, 11, 89, 23);
			buttonPane.add(btnModificar);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Queso queso = Complejo.getComplejo().findQueso(id);
					
					Complejo.getComplejo().deleteQueso(queso);
					JOptionPane.showMessageDialog(null, "Queso eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
					cargarQuesos();
					
					if(Complejo.getComplejo().getListaclientes().isEmpty())
					{
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
					
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setBounds(207, 11, 89, 23);
			buttonPane.add(btnEliminar);
			
			btnAgregarNuevo = new JButton("Agregar Nuevo");
			btnAgregarNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean option = true;
					RegistrarQueso regqueso = new RegistrarQueso("Registrar Queso",null, option);
					regqueso.setModal(true);
					regqueso.setVisible(true);
					cargarQuesos();
				}
			});
			btnAgregarNuevo.setBounds(37, 11, 133, 23);
			buttonPane.add(btnAgregarNuevo);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipos de Quesos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 555, 53);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnQuesoEsferico = new JRadioButton("Queso Esferico");
		rdbtnQuesoEsferico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnQuesoEsferico.isSelected())
				{
					rdbtnQuesoCilindrico.setSelected(false);
					rdbtnQuesoCilindricoHueco.setSelected(false);
					rdbtnTodos.setSelected(false);
					cargarQuesosEsf();
					
				
				}
				
				
			}
		});
		rdbtnQuesoEsferico.setBounds(14, 23, 125, 23);
		panel.add(rdbtnQuesoEsferico);
		
		rdbtnQuesoCilindrico = new JRadioButton("Queso Cilindrico");
		rdbtnQuesoCilindrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnQuesoCilindrico.isSelected())
				{
					
					rdbtnQuesoCilindricoHueco.setSelected(false);
					rdbtnTodos.setSelected(false);
					rdbtnQuesoEsferico.setSelected(false);
					cargarQuesosCil();
				}
			}
		});
		rdbtnQuesoCilindrico.setBounds(153, 23, 125, 23);
		panel.add(rdbtnQuesoCilindrico);
		
		rdbtnQuesoCilindricoHueco = new JRadioButton("Queso Cilindrico Hueco");
		rdbtnQuesoCilindricoHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnQuesoCilindricoHueco.isSelected())
				{
					rdbtnQuesoCilindrico.setSelected(false);
					rdbtnTodos.setSelected(false);
					rdbtnQuesoEsferico.setSelected(false);
					cargarQuesosCilHueco();
				}
			}
		});
		rdbtnQuesoCilindricoHueco.setBounds(292, 23, 162, 23);
		panel.add(rdbtnQuesoCilindricoHueco);
		
		rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnTodos.isSelected())
				{
					rdbtnQuesoCilindrico.setSelected(false);
					rdbtnQuesoCilindricoHueco.setSelected(false);
					rdbtnQuesoEsferico.setSelected(false);
					cargarQuesos();
				}
			}
		});
		rdbtnTodos.setBounds(468, 23, 71, 23);
		panel.add(rdbtnTodos);
		
		lblCantidadDeQuesos = new JLabel("Cantidad de Quesos:");
		lblCantidadDeQuesos.setBounds(10, 353, 123, 22);
		contentPanel.add(lblCantidadDeQuesos);
		
		cantidad = new JTextField();
		cantidad.setEditable(false);
		cantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cantidad.setBounds(143, 353, 116, 22);
		contentPanel.add(cantidad);
		cantidad.setColumns(10);
		
	}
	
	
	public static Queso getQuesoaBuscar()
	{
		Queso ques = Complejo.getComplejo().findQueso(id);
		
		return ques;
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
					
					
					tableModel.addRow(fila);
				

				
			}
			

			cantidad.setText(String.valueOf(Complejo.getComplejo().cantQTodos()));		
		
	}
	
	public static void cargarQuesosEsf()
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
				
					Queso q =Complejo.getComplejo().getListaquesos().get(i);
					
					if(q instanceof QuesoEsferico)
					{
						fila[0] = Complejo.getComplejo().getListaquesos().get(i).getId();
						fila[1] = Complejo.getComplejo().getListaquesos().get(i).getRadio();
						fila[2] = Complejo.getComplejo().getListaquesos().get(i).volumenEsferico();
						fila[3] = Complejo.getComplejo().getListaquesos().get(i).precio();
						
						
						tableModel.addRow(fila);
					}
					
				

				
			}
			
			cantidad.setText(String.valueOf(Complejo.getComplejo().cantQE()));
					
		
	}
	
	public static void cargarQuesosCil()
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
				
					Queso q =Complejo.getComplejo().getListaquesos().get(i);
					if(q instanceof QuesoCilindrico && q.getRadInter() == 0)
					{
						fila[0] = Complejo.getComplejo().getListaquesos().get(i).getId();
						fila[1] = Complejo.getComplejo().getListaquesos().get(i).getRadio();
						fila[2] = Complejo.getComplejo().getListaquesos().get(i).volumenEsferico();
						fila[3] = Complejo.getComplejo().getListaquesos().get(i).precio();
						
						
						tableModel.addRow(fila);
					}
					
				

				
			}
			

		cantidad.setText(String.valueOf(Complejo.getComplejo().cantQCil()));			
		
	}
	
	public static void cargarQuesosCilHueco()
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
				
					Queso q =Complejo.getComplejo().getListaquesos().get(i);
					if(q instanceof QuesoCilindricoHueco)
					{
						fila[0] = Complejo.getComplejo().getListaquesos().get(i).getId();
						fila[1] = Complejo.getComplejo().getListaquesos().get(i).getRadio();
						fila[2] = Complejo.getComplejo().getListaquesos().get(i).volumenEsferico();
						fila[3] = Complejo.getComplejo().getListaquesos().get(i).precio();
						
						
						tableModel.addRow(fila);
					}
					
				

				
			}
			
			cantidad.setText(String.valueOf(Complejo.getComplejo().cantQCilHueco()));
					
		
	}
}
