package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logical.Complejo;
import logical.Queso;
import logical.QuesoCilindrico;
import logical.QuesoCilindricoHueco;
import logical.QuesoEsferico;
import logical.Tipos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField preciobaseQueso;
	private JTextField preciounitarioQueso;
	private JTextField longitudQueso;
	private JTextField radiointeriorQueso;
	private JTextField radioQueso;
	private Queso myQueso = null;
	private JTextField codigoQueso;
	private boolean option = true;
	private boolean comp = false;
	private JComboBox tipo ;
	/**
	 * Create the dialog.
	 * @param option 
	 */
	public RegistrarQueso(String title, Queso queso, boolean option) {
		setTitle(title);
		this.myQueso = queso;
		this.option = option;
		setBounds(100, 100, 536, 333);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Queso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 510, 246);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblPrecioBase = new JLabel("Precio Base:");
		lblPrecioBase.setBounds(31, 86, 83, 14);
		panel.add(lblPrecioBase);
		
		preciobaseQueso = new JTextField();
		preciobaseQueso.setBounds(145, 80, 86, 20);
		panel.add(preciobaseQueso);
		preciobaseQueso.setColumns(10);
		
		JLabel lblPrecioUnitario = new JLabel("Precio Unitario:");
		lblPrecioUnitario.setBounds(262, 86, 96, 14);
		panel.add(lblPrecioUnitario);
		
		preciounitarioQueso = new JTextField();
		preciounitarioQueso.setBounds(382, 80, 86, 20);
		panel.add(preciounitarioQueso);
		preciounitarioQueso.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Longitud y Radio Interior", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 168, 490, 64);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(29, 29, 86, 14);
		panel_2.add(lblLongitud);
		
		longitudQueso = new JTextField();
		longitudQueso.setEditable(false);
		longitudQueso.setBounds(144, 26, 86, 20);
		panel_2.add(longitudQueso);
		longitudQueso.setColumns(10);
		
		JLabel lblRadioInterior = new JLabel("Radio interior:");
		lblRadioInterior.setBounds(259, 29, 86, 14);
		panel_2.add(lblRadioInterior);
		
		radiointeriorQueso = new JTextField();
		radiointeriorQueso.setEditable(false);
		radiointeriorQueso.setBounds(374, 26, 86, 20);
		panel_2.add(radiointeriorQueso);
		radiointeriorQueso.setColumns(10);
		
		JLabel lblRadio = new JLabel("Radio:");
		lblRadio.setBounds(31, 46, 64, 14);
		panel.add(lblRadio);
		
		radioQueso = new JTextField();
		radioQueso.setBounds(145, 40, 86, 20);
		panel.add(radioQueso);
		radioQueso.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(262, 46, 64, 14);
		panel.add(lblCodigo);
		
		codigoQueso = new JTextField();
		codigoQueso.setBounds(382, 40, 86, 20);
		panel.add(codigoQueso);
		codigoQueso.setColumns(10);
		
		JLabel lblTipoDeQueso = new JLabel("Tipo de Queso:");
		lblTipoDeQueso.setBounds(31, 137, 96, 14);
		panel.add(lblTipoDeQueso);
		
		tipo = new JComboBox();
		tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tipo.getSelectedIndex()!=0)
				{
					int i = tipo.getSelectedIndex();
					switch(i){
					
					case 1:
						
						longitudQueso.setEnabled(false);
						radiointeriorQueso.setEnabled(false);
						longitudQueso.setEditable(false);
						radiointeriorQueso.setEditable(false);
						longitudQueso.setText("");
						radiointeriorQueso.setText("");
						
						break;
						
					case 2:
						
						longitudQueso.setEnabled(true);
						longitudQueso.setEditable(true);
						radiointeriorQueso.setText("");
						radiointeriorQueso.setEnabled(false);
						radiointeriorQueso.setText("");
						
						break;
						
					case 3:
						
						longitudQueso.setEnabled(true);
						radiointeriorQueso.setEnabled(true);
						longitudQueso.setEditable(true);
						radiointeriorQueso.setEditable(true);
						break;
						
					}
					
						
				}
			}
		});
		tipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Esferico", "Cilindrico", "Cilindrico Hueco"}));
		tipo.setBounds(145, 134, 141, 20);
		panel.add(tipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 268, 530, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Queso q = null;
						if(myQueso ==  null )
						{
							if(!(radioQueso.getText().equalsIgnoreCase("")) && !(codigoQueso.getText().equalsIgnoreCase("")) && !(preciobaseQueso.getText().equalsIgnoreCase("")) && !(preciounitarioQueso.getText().equalsIgnoreCase("")) && tipo.getSelectedIndex()!=0)
							{
								if(tipo.getSelectedIndex() ==1)
								{
								
									q = new QuesoEsferico(Float.valueOf(preciobaseQueso.getText()), Float.valueOf(preciounitarioQueso.getText()), Float.valueOf(radioQueso.getText()), String.valueOf(codigoQueso.getText()), comp,Tipos.esferico );
									Complejo.getComplejo().registrarQueso(q);
									JOptionPane.showMessageDialog(null, "Queso registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
									limpiaCampos();
									
								}
								else if(tipo.getSelectedIndex()==2)
								{
									QuesoCilindrico qc = new QuesoCilindrico(Float.valueOf(preciobaseQueso.getText()), Float.valueOf(preciounitarioQueso.getText()), Float.valueOf(radioQueso.getText()), Float.valueOf(longitudQueso.getText()), String.valueOf(codigoQueso.getText()), comp, Tipos.cilindrico);
									
									Complejo.getComplejo().registrarQueso(qc);
									JOptionPane.showMessageDialog(null, "Queso registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
									limpiaCampos();
									
								}
								else if(tipo.getSelectedIndex()==3)
								{
									if(  Float.valueOf(radiointeriorQueso.getText()) > Float.valueOf(radioQueso.getText()))
									{
										JOptionPane.showMessageDialog(null, "El radio interior debe ser menor que el radio del queso", null, JOptionPane.WARNING_MESSAGE, null);

									}
									else
									{
										QuesoCilindricoHueco qch = new QuesoCilindricoHueco(Float.valueOf(preciobaseQueso.getText()), Float.valueOf(preciounitarioQueso.getText()), Float.valueOf(radioQueso.getText()), Float.valueOf(longitudQueso.getText()),Float.valueOf(radiointeriorQueso.getText()), String.valueOf(codigoQueso.getText()), comp, Tipos.cilindricohueco );
										Complejo.getComplejo().registrarQueso(qch);	
										JOptionPane.showMessageDialog(null, "Queso registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
										limpiaCampos();
										
									}
								
								}
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.WARNING_MESSAGE, null);

							}
							revalidate();
							repaint();
						}
						else
						{
							
							
							
							
							
							if(tipo.getSelectedIndex()==1)
							{
								
								myQueso.setPrecioUnitario(Float.valueOf(preciounitarioQueso.getText()));
								myQueso.setRadio(Float.valueOf(radioQueso.getText()));
								myQueso.setId(String.valueOf(codigoQueso.getText()));
								myQueso.setPrecioBase(Float.valueOf(preciobaseQueso.getText()));
								myQueso.setTipo(Tipos.esferico);
								
								Complejo.getComplejo().modificarQueso(myQueso);
								JOptionPane.showMessageDialog(null, "Queso modificado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								
							}
							else if(tipo.getSelectedIndex()==2)
							{
								QuesoCilindrico qc = new QuesoCilindrico();
								qc.setPrecioBase(Float.valueOf(preciobaseQueso.getText()));
								qc.setPrecioUnitario(Float.valueOf(preciounitarioQueso.getText()));
								qc.setLongitud(Float.valueOf(longitudQueso.getText()));
								qc.setId(String.valueOf(codigoQueso.getText()));
								qc.setRadio(Float.valueOf(radioQueso.getText()));
								qc.setTipo(Tipos.cilindrico);
								
								
								Complejo.getComplejo().modificarQueso(qc);
								JOptionPane.showMessageDialog(null, "Queso modificado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
							}
							else if(tipo.getSelectedIndex()==3)
							{
								if(  Float.valueOf(radiointeriorQueso.getText()) > Float.valueOf(radioQueso.getText()))
								{
									JOptionPane.showMessageDialog(null, "El radio interior debe ser menor que el radio del queso", null, JOptionPane.WARNING_MESSAGE, null);

								}
								else
								{
									QuesoCilindricoHueco qch = new QuesoCilindricoHueco(Float.valueOf(preciobaseQueso.getText()), Float.valueOf(preciounitarioQueso.getText()), Float.valueOf(radioQueso.getText()), Float.valueOf(longitudQueso.getText()),Float.valueOf(radiointeriorQueso.getText()), String.valueOf(codigoQueso.getText()), comp, Tipos.cilindricohueco );
									
									Complejo.getComplejo().modificarQueso(qch);	
									JOptionPane.showMessageDialog(null, "Queso modificado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								}
							}
							
							dispose();
							ListQuesos.cargarQuesos();
							
					}
						
					}});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarQuesoModi();
	}
	public void cargarQuesoModi()
	{
		if(!option)
		{
			
			
		radioQueso.setText(String.valueOf(myQueso.getRadio()));
		codigoQueso.setText(String.valueOf(myQueso.getId()));
		preciobaseQueso.setText(String.valueOf(myQueso.getPrecioBase()));
		preciounitarioQueso.setText(String.valueOf(myQueso.getPrecioUnitario()));
		
		if(myQueso.getTipo().toString().equalsIgnoreCase("Esferico"))
		{
			tipo.setSelectedIndex(1);
			longitudQueso.setEnabled(false);
			radiointeriorQueso.setEnabled(false);
			longitudQueso.setText("");
			radiointeriorQueso.setText("");
		}
		else if(myQueso.getTipo().toString().equalsIgnoreCase("Cilindrico"))
		{
			
			tipo.setSelectedIndex(2);
			longitudQueso.setEnabled(true);
			longitudQueso.setEditable(true);
			longitudQueso.setText(String.valueOf(myQueso.getlongitu()));
		}
		else if(myQueso.getTipo().toString().equalsIgnoreCase("Cilindricohueco"))
		{
			tipo.setSelectedIndex(3);
			longitudQueso.setEnabled(true);
			longitudQueso.setEditable(true);
			radiointeriorQueso.setEnabled(true);
			radiointeriorQueso.setEditable(true);
			longitudQueso.setText(String.valueOf(myQueso.getlongitu()));
			radiointeriorQueso.setText(String.valueOf(myQueso.getRadInter()));
			
		}
		
		
		
			
			
			
			
			
		}
	}
	
	public void limpiaCampos()
	{
		radioQueso.setText("");
		preciobaseQueso.setText("");
		preciounitarioQueso.setText("");
		longitudQueso.setText("");
		radiointeriorQueso.setText("");
		longitudQueso.setEditable(false);
		radiointeriorQueso.setEditable(false);
		codigoQueso.setText("");
		tipo.setSelectedIndex(0);
		setCursor(radioQueso.getCursor());
	}
}
