package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logical.Cliente;
import logical.Complejo;
import logical.Queso;
import logical.Ventas;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class VerFactura extends JDialog {

	private static  boolean paso = false;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private ArrayList<Ventas> listv;
	private static DefaultTableModel tableModel;
	static Object[] fila;
	private Cliente client = null;
	private ArrayList<Queso> listQueso;
	private Ventas vent;
	private JTextField nombreCliente;
	private JTextField direccionCliente;
	private JTextField cedulaCliente;
	private JTextField telefonoCliente;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private JTextField totalVent;
	
	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public VerFactura(String title, Cliente clie, Ventas v) {
		super();
		this.listQueso = new ArrayList<Queso>();
		setTitle(title);
		setBounds(100, 100, 714, 499);
		setLocationRelativeTo(null);
		setResizable(false);
		this.client = clie;
		//this.listQueso = list;
		
		this.vent = v;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 688, 264);
		contentPanel.add(scrollPane);
		
		String[] columnsHeaders = { "ID", "Radio", "Volumen", "Precio"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 688, 103);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 30, 56, 21);
		panel.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 62, 62, 21);
		panel.add(lblDireccion);
		
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nombreCliente = new JTextField();
		nombreCliente.setEditable(false);
		nombreCliente.setBounds(76, 30, 114, 21);
		panel.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		direccionCliente = new JTextField();
		direccionCliente.setEditable(false);
		direccionCliente.setBounds(72, 62, 606, 21);
		panel.add(direccionCliente);
		direccionCliente.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula: ");
		lblCedula.setBounds(228, 33, 48, 21);
		panel.add(lblCedula);
		
		cedulaCliente = new JFormattedTextField(patron);
		cedulaCliente.setEditable(false);
		cedulaCliente.setBounds(286, 30, 114, 21);
		panel.add(cedulaCliente);
		cedulaCliente.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(484, 30, 56, 21);
		panel.add(lblTelefono);
		
		telefonoCliente = new JFormattedTextField(tele);
		telefonoCliente.setEditable(false);
		telefonoCliente.setBounds(564, 30, 114, 21);
		panel.add(telefonoCliente);
		telefonoCliente.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setBounds(10, 408, 59, 20);
		contentPanel.add(lblTotal);
		
		totalVent = new JTextField();
		totalVent.setForeground(Color.RED);
		totalVent.setEditable(false);
		totalVent.setBounds(66, 408, 86, 20);
		contentPanel.add(totalVent);
		totalVent.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
		cargaCliente();
		cargaQuesosVent();
	}
	
	public void cargaCliente()
	{
		nombreCliente.setText(client.getNombre());
		cedulaCliente.setText(client.getCedula());
		telefonoCliente.setText(client.getTelefono());
		direccionCliente.setText(client.getDireccion());
		totalVent.setText(String.valueOf(vent.getPreciototal()));
	}
	
	public void cargaQuesosVent() 
	{
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		
		
		
		for (int i=0; i < Complejo.getComplejo().getListaventas().size(); i++) {
			
			if(Complejo.getComplejo().getListaventas().get(i).getClient().getCedula().equalsIgnoreCase(vent.getClient().getCedula()))
			{
				listQueso = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa();
			}
		}
		
		fila = new Object[tableModel.getColumnCount()];
		/*
		for(int i=0; i < listQueso.size();i++)
		{
			fila[0] = listQueso.get(i).getId();
			fila[1] = listQueso.get(i).getRadio();
			fila[2] = listQueso.get(i).volumen();
			fila[3] = listQueso.get(i).precio();
			
			tableModel.addRow(fila);
		}
		*/
		
		
		for(int i =0; i < Complejo.getComplejo().getListaventas().size();i++)
		{
			for(int j =0; j < Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().size();j++)
			{
				fila[0] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(j).getId();
				fila[1] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(j).getRadio();
				fila[2] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(j).volumen();
				fila[3] = Complejo.getComplejo().getListaventas().get(i).getListaquesosventa().get(j).precio();
				
				tableModel.addRow(fila);
			}
		}
	}
	
	
}
