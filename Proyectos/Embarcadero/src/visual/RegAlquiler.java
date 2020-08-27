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
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegAlquiler extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dir;
	private JTextField barcoNombre;
	private JTextField eslora;
	private MaskFormatter patron;
	private MaskFormatter tele;
	private Embarcadero emb;
	private boolean option = true;
	private Clientes myClient = null;
	private JTextField tipo;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegAlquiler(Embarcadero pemb ) {
		setTitle("Registrar Alquiler");
		
		this.emb = pemb;
		setBounds(100, 100, 524, 243);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Alquiler", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 488, 67);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		try {
			patron = new MaskFormatter("###-#######-#");
			tele = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblDireccin = new JLabel("Cant. D\u00EDas:");
		lblDireccin.setBounds(233, 28, 68, 14);
		panel.add(lblDireccin);
		
		dir = new JTextField();
		dir.setBounds(298, 24, 58, 23);
		panel.add(dir);
		dir.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 27, 58, 14);
		panel.add(lblCliente);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=0){
					String nombre = comboBox.getSelectedItem().toString();
					Clientes client =  emb.findClientByName(nombre);
					if(client!=null){
					barcoNombre.setText(client.getBarco().getNombre());
					eslora.setText(String.valueOf(client.getBarco().getEslora()));
					tipo.setText(client.getBarco().getTipo().toString());
					}
				}
			}
		});
		comboBox.setBounds(63, 24, 160, 23);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Amarre:");
		lblNewLabel.setBounds(372, 28, 46, 14);
		panel.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(428, 24, 50, 23);
		panel.add(spinner);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 89, 488, 2);
		contentPanel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del Barco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 102, 488, 60);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(10, 23, 58, 14);
		panel_1.add(lblNombre_1);
		
		barcoNombre = new JTextField();
		barcoNombre.setEditable(false);
		barcoNombre.setBounds(61, 20, 140, 23);
		panel_1.add(barcoNombre);
		barcoNombre.setColumns(10);
		
		JLabel lblEsloram = new JLabel("Eslora (m):");
		lblEsloram.setBounds(211, 23, 72, 14);
		panel_1.add(lblEsloram);
		
		eslora = new JTextField();
		eslora.setEditable(false);
		eslora.setBounds(285, 19, 51, 23);
		panel_1.add(eslora);
		eslora.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(346, 23, 43, 14);
		panel_1.add(lblTipo);
		
		tipo = new JTextField();
		tipo.setEditable(false);
		tipo.setBounds(384, 19, 94, 23);
		panel_1.add(tipo);
		tipo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
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
		
		loadClient();
	}
	
	private void loadClient() {
		comboBox.removeAll();
		for (int i = 0; i < emb.getCantidadClientes(); i++) {
			comboBox.addItem(emb.getListaClientes()[i].getNombre());	
		}
		comboBox.insertItemAt("<Seleccione>", 0);
		comboBox.setSelectedIndex(0);
		
	}

	private void cleanDialog() {
		
		barcoNombre.setText("");
		
		
		dir.setText("");
		eslora.setText("");
	
		
	}
}
