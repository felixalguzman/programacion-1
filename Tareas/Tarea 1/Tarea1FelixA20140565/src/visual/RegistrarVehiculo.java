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


public class RegistrarVehiculo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField vehiculoModelo;
	private JTextField vehiculoColor;
	private JTextField vehiculoPrecio;
	private JComboBox vehiculoTipo;
	private boolean option = true;
	private Vendedor vend;
	private JTextField vehiculoMarca;
	private Vehiculo myVehiculo = null;
	private static Vehiculo myVehiculo1 = null;
	private JTextField codigoSuministradorv;

	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegistrarVehiculo(Vendedor pvend, String title, boolean option, Vehiculo vehiculo, Suministrador suministrador) {
		setTitle(title);
		this.option  = option;
		this.vend = pvend;
		this.myVehiculo = vehiculo;
		setBounds(100, 100, 447, 305);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 431, 34);
			contentPanel.add(buttonPane);
			{
				JButton salvarButton = new JButton("Salvar");
				salvarButton.setBounds(259, 5, 76, 23);
				salvarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(myVehiculo == null)
						{
							if(!vehiculoMarca.getText().equalsIgnoreCase("") && !vehiculoColor.getText().equalsIgnoreCase("") && !vehiculoModelo.getText().equalsIgnoreCase("") && !vehiculoPrecio.getText().equalsIgnoreCase("") && !vehiculoTipo.getSelectedItem().equals("<Seleccione>")  )
							{
								Vehiculo vehiculo = new Vehiculo();
								Suministrador suministrador = new Suministrador();
								vehiculo.setColor(vehiculoColor.getText());
								vehiculo.setMarca(vehiculoMarca.getText());
								vehiculo.setModelo(vehiculoModelo.getText());
								vehiculo.setPrecio(Integer.valueOf(vehiculoPrecio.getText()));	
								
					
																							
								if(vehiculoTipo.getSelectedItem().toString().equalsIgnoreCase("Auto"))
								{
									vehiculo.setTipo(Tipovehi.auto);
								}
								else if(vehiculoTipo.getSelectedItem().toString().equalsIgnoreCase("Microbus"))
								{
									vehiculo.setTipo(Tipovehi.microbus);
								}
								else if(vehiculoTipo.getSelectedItem().toString().equalsIgnoreCase("Autobus"))
								{
									vehiculo.setTipo(Tipovehi.autobus);
								}
								
								myVehiculo1 = vehiculo;
								suministrador = vend.encontrarSuministrador(codigoSuministradorv.getText());
								
								
								if(suministrador == null)
								{
									JOptionPane.showMessageDialog(null, "Este suministrador no ha sido registrado", null, JOptionPane.INFORMATION_MESSAGE, null);
									boolean option = true;
									RegistrarSuministrador sumi = new RegistrarSuministrador(vend, "Registrar Suministrador", option, suministrador);
									sumi.setModal(true);
									sumi.setVisible(true);
									vehiculo.setSuministrador(sumi.retornameSuministrador());
									
								}
								else
								{
									if(vehiculoMarca.getText().equalsIgnoreCase(vend.encontrarMarcaSuministrador(suministrador.getMarca())))
									{
										vehiculo.setSuministrador(suministrador);
										vend.registrarVehiculo(vehiculo);
										JOptionPane.showMessageDialog(null, "Auto registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
										cleanDialogVehiculo();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Este suministrador no ofrece esta marca de vehiculo", null, JOptionPane.INFORMATION_MESSAGE, null);

									}
									
									
									
								}
								
								
							
								System.out.println("Llego 1");
								
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.INFORMATION_MESSAGE, null);
							}
						}
						else
						{
							if(!myVehiculo.getMarca().equalsIgnoreCase("") && !myVehiculo.getColor().equalsIgnoreCase("") && !myVehiculo.getModelo().equalsIgnoreCase("") && !myVehiculo.toString().valueOf(myVehiculo.getPrecio()).equalsIgnoreCase("") && !myVehiculo.getTipo().toString().equalsIgnoreCase("<Seleccione>"))
							{
								System.out.println(myVehiculo.getTipo().toString());
								
								myVehiculo.setColor(vehiculoColor.getText());
								myVehiculo.setMarca(vehiculoMarca.getText());
								myVehiculo.setPrecio(Integer.valueOf(vehiculoPrecio.getText()));
								myVehiculo.setSuministrador(vend.encontrarSuministrador(codigoSuministradorv.getText()));
								myVehiculo.setModelo(vehiculoModelo.getText());
								
								
								if(vehiculoTipo.getSelectedItem().toString().equalsIgnoreCase("Auto"))
								{
									myVehiculo.setTipo(Tipovehi.auto);
								}
								else if(vehiculoTipo.getSelectedItem().toString().equalsIgnoreCase("Microbus"))
								{
									myVehiculo.setTipo(Tipovehi.microbus);
								}
								else if(vehiculoTipo.getSelectedItem().toString().equalsIgnoreCase("Autobus"))
								{
									myVehiculo.setTipo(Tipovehi.autobus);
								}
								//vehiculo.setSuministrador(mySuministrador);
								ListaVehiculos.cargarVehiculo();
								vend.modificarVehiculo(myVehiculo);
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.INFORMATION_MESSAGE, null);

							}
							
							
							
						}
							
							//ListaSuministradores.cargarSuministrador();
							
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
						//ListaVehiculos.cargarVehiculo();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Vehiculo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(9, 11, 412, 131);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		vehiculoModelo = new JTextField();
		vehiculoModelo.setBounds(299, 30, 101, 20);
		panel.add(vehiculoModelo);
		vehiculoModelo.setColumns(10);
		
		vehiculoMarca = new JTextField();
		vehiculoMarca.setBounds(67, 30, 111, 20);
		panel.add(vehiculoMarca);
		vehiculoMarca.setColumns(10);
		
		vehiculoPrecio = new JTextField();
		vehiculoPrecio.setBounds(67, 92, 111, 20);
		panel.add(vehiculoPrecio);
		vehiculoPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 95, 46, 14);
		panel.add(lblPrecio);
		
		JLabel lblColo = new JLabel("Color:");
		lblColo.setBounds(10, 64, 46, 14);
		panel.add(lblColo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 33, 46, 14);
		panel.add(lblMarca);
		
		vehiculoColor = new JTextField();
		vehiculoColor.setBounds(67, 61, 111, 20);
		panel.add(vehiculoColor);
		vehiculoColor.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(221, 64, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(221, 30, 47, 20);
		panel.add(lblModelo);
		
		vehiculoTipo = new JComboBox();
		vehiculoTipo.setBounds(298, 61, 102, 20);
		panel.add(vehiculoTipo);
		vehiculoTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Auto", "Autobus", "Microbus"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dato del Suministrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 163, 411, 65);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigoDelSuministrador = new JLabel("Codigo del Suministrador del vehiculo:");
		lblCodigoDelSuministrador.setBounds(10, 21, 236, 33);
		panel_1.add(lblCodigoDelSuministrador);
		
		codigoSuministradorv = new JTextField();
		codigoSuministradorv.setBounds(233, 27, 105, 20);
		panel_1.add(codigoSuministradorv);
		codigoSuministradorv.setColumns(10);
		cargarModifiVehiculo();
	}

	private void cargarModifiVehiculo()
	{
		if(!option)
		{
			vehiculoModelo.setText(myVehiculo.getModelo());
			vehiculoColor.setText(myVehiculo.getColor());
			vehiculoPrecio.setText(String.valueOf( myVehiculo.getPrecio()));
			vehiculoMarca.setText(myVehiculo.getMarca());
			codigoSuministradorv.setText(myVehiculo.getSuministrador().getCodigo());
			
			
			if(myVehiculo.getTipo().toString().equalsIgnoreCase("Auto"))
			{
				vehiculoTipo.setSelectedIndex(1);
			}
			else if(myVehiculo.getTipo().toString().equalsIgnoreCase("Autobus"))
			{
				vehiculoTipo.setSelectedIndex(2);
			}
			else if(myVehiculo.getTipo().toString().equalsIgnoreCase("Microbus"))
			{
				vehiculoTipo.setSelectedIndex(3);
			}
			
		}
	}

	protected void cleanDialogVehiculo() {
		vehiculoModelo.setText("");
		vehiculoMarca.setText("");
		vehiculoColor.setText("");
		vehiculoPrecio.setText("");
		vehiculoTipo.setSelectedIndex(0);
		codigoSuministradorv.setText("");
		
		
	}
	
	public static Vehiculo retornarVehiculo()
	{
		return myVehiculo1;
	}
	

}
