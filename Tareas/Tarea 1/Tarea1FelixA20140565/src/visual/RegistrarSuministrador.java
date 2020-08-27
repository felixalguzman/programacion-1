package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Suministrador;
import Logical.Vehiculo;
import Logical.Vendedor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import Logical.Tipovehi;

import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JEditorPane;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class RegistrarSuministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean option = true;
	private Vendedor vend;
	private Vehiculo vehi;
	private Vehiculo myVehiculo = null;
	private Suministrador mySuministrador = null;
	private Suministrador mySuministrador1 = null;
	private JTextField nombreSuministrador;
	private JTextField apellidoSuministrador;
	private JTextField codigoSuministrador;
	private JTextField paisSuministrador;
	private JTextField marcaSuministrador;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarSuministrador(Vendedor pvend, String title, boolean option, Suministrador suministrador) {
		setTitle(title);
		this.option  = option;
		this.vend = pvend;
		this.mySuministrador = suministrador;
		setBounds(100, 100, 447, 227);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 154, 431, 34);
			contentPanel.add(buttonPane);
			{
				JButton salvarButton = new JButton("Salvar");
				salvarButton.setBounds(259, 5, 76, 23);
				salvarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(mySuministrador == null)
						{
							if(!nombreSuministrador.getText().equalsIgnoreCase("") && !apellidoSuministrador.getText().equalsIgnoreCase("") && !codigoSuministrador.getText().equalsIgnoreCase("") && !paisSuministrador.getText().equalsIgnoreCase("") && !marcaSuministrador.getText().equalsIgnoreCase("") )
							{
								Suministrador sum = new Suministrador();
								
								sum.setCodigo(codigoSuministrador.getText());
								sum.setApellido(apellidoSuministrador.getText());
								sum.setNombre(nombreSuministrador.getText());
								sum.setPais(paisSuministrador.getText());
								sum.setMarca(marcaSuministrador.getText());
								mySuministrador1 = sum;
																							
							
								JOptionPane.showMessageDialog(null, "Suministrador registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								
								vend.registrarSuministrador(sum);
							
								System.out.println("Llego 1");
								cleanDialog();
								
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.INFORMATION_MESSAGE, null);
							}
						}
						else
						{
							//cargarModifi();
							mySuministrador.setApellido(apellidoSuministrador.getText());
							mySuministrador.setNombre(nombreSuministrador.getText());
							mySuministrador.setCodigo(codigoSuministrador.getText());
							mySuministrador.setPais(paisSuministrador.getText());
							mySuministrador.setMarca(marcaSuministrador.getText());
							
							vend.modificarSuministrador(mySuministrador);
							
							ListaSuministradores.cargarSuministrador();
							
							
							
						}
					
						}
						
					}
				);
				buttonPane.setLayout(null);
				salvarButton.setActionCommand("OK");
				buttonPane.add(salvarButton);
				getRootPane().setDefaultButton(salvarButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBounds(345, 5, 76, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
			
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Suministrador del Vehiculo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 411, 142);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 64, 57, 14);
		panel_1.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 25, 57, 14);
		panel_1.add(lblNombre);
		
		JLabel lblPais = new JLabel("Pais:");
		lblPais.setBounds(232, 90, 46, 14);
		panel_1.add(lblPais);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(232, 38, 57, 14);
		panel_1.add(lblApellido);
		
		nombreSuministrador = new JTextField();
		nombreSuministrador.setBounds(66, 20, 106, 20);
		panel_1.add(nombreSuministrador);
		nombreSuministrador.setColumns(10);
		
		apellidoSuministrador = new JTextField();
		apellidoSuministrador.setBounds(298, 34, 106, 20);
		panel_1.add(apellidoSuministrador);
		apellidoSuministrador.setColumns(10);
		
		codigoSuministrador = new JTextField();
		codigoSuministrador.setBounds(66, 60, 106, 20);
		panel_1.add(codigoSuministrador);
		codigoSuministrador.setColumns(10);
		
		paisSuministrador = new JTextField();
		paisSuministrador.setBounds(298, 88, 106, 20);
		panel_1.add(paisSuministrador);
		paisSuministrador.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 103, 46, 14);
		panel_1.add(lblMarca);
		
		marcaSuministrador = new JTextField();
		marcaSuministrador.setBounds(66, 100, 106, 20);
		panel_1.add(marcaSuministrador);
		marcaSuministrador.setColumns(10);
		
		cargarModifi();
	}

	private void cargarModifi()
	{
		if(!option)
		{
			nombreSuministrador.setText(mySuministrador.getNombre());
			apellidoSuministrador.setText(mySuministrador.getApellido());
			paisSuministrador.setText(mySuministrador.getPais());
			codigoSuministrador.setText(String.valueOf(mySuministrador.getCodigo()));
			marcaSuministrador.setText(mySuministrador.getMarca());

			
		}
	}

	protected void cleanDialog() {
		
		apellidoSuministrador.setText("");
		nombreSuministrador.setText("");
		codigoSuministrador.setText("");
		paisSuministrador.setText("");
		marcaSuministrador.setText("");
		
		
	}
	
	public Suministrador retornameSuministrador()
	{
		
		return mySuministrador1;
		
	}
}
