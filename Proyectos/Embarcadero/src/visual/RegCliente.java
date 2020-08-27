package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import logical.Barco;
import logical.Clientes;
import logical.Embarcadero;
import logical.Typeline;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField clienteNombre;
	private JTextField dir;
	private JTextField barcoNombre;
	private JTextField eslora;
	private JTextField barcoAnno;
	private JComboBox tipo;
	private JFormattedTextField clienteTele;
	private JFormattedTextField txtCedula;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private Embarcadero emb;
	private boolean option = true;
	private Clientes myClient = null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegCliente(Embarcadero pemb, String tittle, boolean option, Clientes client) {
		setTitle(tittle);
		this.option = option;
		myClient = client;
		this.emb = pemb;
		setBounds(100, 100, 508, 342);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 472, 125);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 63, 58, 14);
		panel.add(lblNombre);
		
		clienteNombre = new JTextField();
		clienteNombre.setBounds(74, 60, 179, 23);
		panel.add(clienteNombre);
		clienteNombre.setColumns(10);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(267, 63, 58, 14);
		panel.add(lblTelfono);
		
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clienteTele = new JFormattedTextField(tele);
		clienteTele.setBounds(324, 60, 127, 23);
		panel.add(clienteTele);
		clienteTele.setDropMode(DropMode.INSERT);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 94, 68, 14);
		panel.add(lblDireccin);
		
		dir = new JTextField();
		dir.setBounds(74, 91, 377, 23);
		panel.add(dir);
		dir.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 35, 58, 14);
	
		panel.add(lblCdula);

		txtCedula = new JFormattedTextField(patron);
		txtCedula.setBounds(74, 32, 179, 20);
		 if(!option){
				txtCedula.setEnabled(false);
			}
		panel.add(txtCedula);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 147, 472, 2);
		contentPanel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del Barco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 160, 472, 100);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(10, 23, 58, 14);
		panel_1.add(lblNombre_1);
		
		barcoNombre = new JTextField();
		barcoNombre.setBounds(74, 20, 179, 23);
		panel_1.add(barcoNombre);
		barcoNombre.setColumns(10);
		
		JLabel lblEsloram = new JLabel("Eslora (m):");
		lblEsloram.setBounds(267, 23, 72, 14);
		panel_1.add(lblEsloram);
		
		eslora = new JTextField();
		eslora.setBounds(336, 20, 115, 23);
		panel_1.add(eslora);
		eslora.setColumns(10);
		
		JLabel lblAoFab = new JLabel("A\u00F1o Fab:");
		lblAoFab.setBounds(10, 63, 58, 14);
		panel_1.add(lblAoFab);
		
		barcoAnno = new JTextField();
		barcoAnno.setBounds(74, 60, 179, 23);
		panel_1.add(barcoAnno);
		barcoAnno.setColumns(10);
		
		tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Yate", "Velero", "A motor"}));
		tipo.setBounds(336, 60, 115, 23);
		panel_1.add(tipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(267, 63, 72, 14);
		panel_1.add(lblTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(myClient == null){
							if(!clienteNombre.getText().equalsIgnoreCase("") && txtCedula.getText().length()==13){
						Barco barco = new Barco();
						barco.setNombre(barcoNombre.getText());
						barco.setAño(Integer.valueOf(barcoAnno.getText()));
						barco.setEslora(Integer.valueOf(eslora.getText()));
						if(tipo.getSelectedItem().toString().equalsIgnoreCase("Yate")){
							barco.setTipo(Typeline.yate);
						}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("Velero")){
							barco.setTipo(Typeline.velero);
						}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("A motor")){
							barco.setTipo(Typeline.motor);
						}  
						Clientes cliente = new Clientes();
						cliente.setDireccion(dir.getText());
						cliente.setNombre(clienteNombre.getText());
						cliente.setCedula(txtCedula.getText());
						cliente.setTelefono(clienteTele.getText());
						cliente.setBarco(barco);
						emb.registrarClientes(cliente);
						JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						cleanDialog();
							}else{
								JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.WARNING_MESSAGE, null);
							}
						}
						else{
						    myClient.setTelefono(clienteTele.getText());
						    myClient.setDireccion(dir.getText());
						    myClient.setNombre(clienteNombre.getText());
						    myClient.getBarco().setAño(Integer.valueOf(barcoAnno.getText()));
						    myClient.getBarco().setEslora(Integer.valueOf(eslora.getText()));
						    myClient.getBarco().setNombre(barcoNombre.getText());
						    if(tipo.getSelectedItem().toString().equalsIgnoreCase("Yate")){
						    	myClient.getBarco().setTipo(Typeline.yate);
							}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("Velero")){
								myClient.getBarco().setTipo(Typeline.velero);
							}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("A motor")){
								myClient.getBarco().setTipo(Typeline.motor);
							} 
							emb.modify(myClient);
							dispose();
							listCliente.loadClient();
						}
						
					}

					
				});
				okButton.setActionCommand("Salvar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadClientIfModify();
	}
	
	private void loadClientIfModify() {
		if(!option){
			txtCedula.setText(myClient.getCedula());
			barcoNombre.setText(myClient.getBarco().getNombre());
			clienteNombre.setText(myClient.getNombre());
			dir.setText(myClient.getDireccion());
			clienteTele.setText(String.valueOf(myClient.getTelefono()));
			eslora.setText(String.valueOf(myClient.getBarco().getEslora()));
			barcoAnno.setText(String.valueOf(myClient.getBarco().getAño()));
			if(myClient.getBarco().getTipo().toString().equalsIgnoreCase("Yate"))
			  tipo.setSelectedIndex(1);
			else if(myClient.getBarco().getTipo().toString().equalsIgnoreCase("Velero"))
				  tipo.setSelectedIndex(2);
			else if(myClient.getBarco().getTipo().toString().equalsIgnoreCase("A motor"))
				  tipo.setSelectedIndex(3);
			
		}
		
	}

	private void cleanDialog() {
		txtCedula.setText("");
		barcoNombre.setText("");
		barcoAnno.setText("");
		clienteNombre.setText("");
		clienteTele.setText("");
		dir.setText("");
		eslora.setText("");
		tipo.setSelectedIndex(0);
		
	}
}
