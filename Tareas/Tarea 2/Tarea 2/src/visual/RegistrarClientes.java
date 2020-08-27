package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logical.Cliente;
import logical.Complejo;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class RegistrarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreCliente;
	private JTextField cedulaCliente;
	private JTextField telefonoCliente;
	private JTextField direccionCliente;
	private Cliente myclient;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private boolean option = true;
	
	/**
	 * Create the dialog.
	 * @param option 
	 */
	public RegistrarClientes(String title, Cliente client, boolean option1) {
		setTitle(title);
		setBounds(100, 100, 610, 208);
		setResizable(false);
		setLocationRelativeTo(null);
		this.myclient = client;
		this.option = option1;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 584, 112);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 76, 14);
		panel.add(lblNombre);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(96, 30, 97, 20);
		panel.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(203, 36, 76, 14);
		panel.add(lblCedula);
		
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cedulaCliente = new JFormattedTextField(patron);
		cedulaCliente.setBounds(263, 33, 97, 20);
		panel.add(cedulaCliente);
		cedulaCliente.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(396, 36, 66, 14);
		panel.add(lblTelefono);
		
		telefonoCliente = new JFormattedTextField(tele);
		telefonoCliente.setBounds(472, 30, 97, 20);
		panel.add(telefonoCliente);
		telefonoCliente.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(10, 86, 76, 14);
		panel.add(lblDireccion);
		
		direccionCliente = new JTextField();
		direccionCliente.setBounds(96, 80, 479, 20);
		panel.add(direccionCliente);
		direccionCliente.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 134, 604, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(myclient == null)
						{
							if(!(nombreCliente.getText().equalsIgnoreCase("")) && (cedulaCliente.getText().length() == 13) && !(direccionCliente.getText().equalsIgnoreCase("")) && !(telefonoCliente.getText().equalsIgnoreCase("")))
							{
								Cliente cliente = new Cliente();
								
								cliente.setNombre(nombreCliente.getText());
								cliente.setDireccion(direccionCliente.getText());
								cliente.setTelefono(telefonoCliente.getText());
								cliente.setCedula(cedulaCliente.getText());
								
								Complejo.getComplejo().registrarCliente(cliente);
								JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								limpiarCampos();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.WARNING_MESSAGE, null);

							}
						}
						else
						{
							myclient.setNombre(nombreCliente.getText());
							myclient.setDireccion(direccionCliente.getText());
							myclient.setCedula(cedulaCliente.getText());
							myclient.setTelefono(telefonoCliente.getText());
							Complejo.getComplejo().modificarClient(myclient);
							
							JOptionPane.showMessageDialog(null, "Cliente modificado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
							dispose();
							ListClientes.cargarClientes();
						}
					}
				});
				okButton.setBounds(432, 11, 76, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBounds(518, 11, 76, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarClienteModificar();
	}
	
	public void limpiarCampos()
	{
		nombreCliente.setText("");
		direccionCliente.setText("");
		cedulaCliente.setText("");
		telefonoCliente.setText("");
		
	}
	
	
	public void cargarClienteModificar()
	{
		if(!option)
		{
			cedulaCliente.setEditable(false);
			nombreCliente.setText(myclient.getNombre());
			direccionCliente.setText(myclient.getDireccion());
			cedulaCliente.setText(myclient.getCedula());
			telefonoCliente.setText(myclient.getTelefono());
			
			
			
		}
	}
}
