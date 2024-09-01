package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javafx.scene.control.ComboBox;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import componentesVisuales.CampoCIValidado;

import javax.swing.JLabel;

import componentesVisuales.AvatarCircular;

import javax.swing.ImageIcon;

import java.awt.Font;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import logica.Empleadora;
import logica.empresa.Empresa;
import logica.enums.Sector;
import componentesVisuales.BotonAnimacion;

import javax.swing.SwingConstants;




import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextFieldModificado txtNom;
	private JTextFieldModificado txtDir;
	private JTextFieldModificado txtTel;
	private boolean clickNom = false;
	private boolean clickDir = false;
	private boolean clickTel = false;
	private JComboBox cmbSect;
	
	private boolean okNom = true;
	private boolean okDir = true;
	private boolean okTel = true;
	private BotonAnimacion btnmcnCancelar;
	private BotonAnimacion btnActu;
	
	
	private void clicBorrar(JTextField jtext, boolean click){
		if(click){
			jtext.setFont(new Font("Arial", Font.ITALIC, 13));
		}
		else{
			jtext.setText("");
			jtext.setFont(new Font("Arial", Font.BOLD, 13));
		}
	}
	
	private boolean existe(Empresa empresa, int pos){
		
		boolean encontrado = false;
		
		Empleadora emp = Empleadora.getInstancia();
		for(int i = 0; i < emp.getEmpresas().size() && i != pos && !encontrado; i++){
			if(emp.getEmpresas().get(i).getNombre().equalsIgnoreCase(empresa.getNombre())){
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	private boolean ediEmp(Empresa empresa, int pos){
		boolean retorno = false;
		
		if(this.okDir && this.okNom && this.okTel){
			Empleadora emp = Empleadora.getInstancia();
			empresa.setNombre(txtNom.getText());
			empresa.setDireccion(txtDir.getText());
			empresa.setTelefeno(txtTel.getText());
			empresa.setSector(cmbSect.getSelectedItem().toString());
			if(emp.getEmpresas().size() != 1){
				if(!existe(empresa, pos)){
					retorno = true;
				}
				else{
					retorno = false;
				}
			}
			else{
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	
	public JTextFieldModificado getTxtNom(){
		return txtNom;
	}
	
	public JTextFieldModificado getTxtDir(){
		return txtDir;
	}
	
	public JTextFieldModificado getTxtTel(){
		return txtTel;
	}
	
	private void iniciarComponetes(final Empresa act, final int pos){
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Crear Empresa");
		setBounds(100, 100, 465, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(EditarEmpresa.class.getResource("/icons/icons8-bank-building-80.png")));
			lblNewLabel.setBounds(196, 11, 82, 69);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNombre.setBounds(10, 98, 73, 26);
			contentPanel.add(lblNombre);
		}
		
		txtNom = new JTextFieldModificado();
		txtNom.setText("Introduce el Nombre");
		txtNom.setBeepActivado(false);
		txtNom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickNom){
					clicBorrar(txtNom,clickNom);
					clickNom = true;
					okNom = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNom.getText().isEmpty()){
					clicBorrar(txtNom,clickNom);
					txtNom.setText("Introduce el Nombre");
					clickNom = false;
					okNom = false;
				}
			}
		});
		txtNom.setFont(new Font("Arial", Font.ITALIC, 13));
		txtNom.setBorder(null);
		txtNom.setBounds(93, 97, 349, 26);
		contentPanel.add(txtNom);
		{
			JLabel lblDireccin = new JLabel("Direcci\u00F3n: ");
			lblDireccin.setFont(new Font("Arial", Font.PLAIN, 18));
			lblDireccin.setBounds(10, 135, 92, 26);
			contentPanel.add(lblDireccin);
		}
		
		txtDir = new JTextFieldModificado();
		txtDir.setBeepActivado(false);
		txtDir.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickDir){
					clicBorrar(txtDir,clickDir);
					clickDir = true;
					okDir = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtDir.getText().isEmpty()){
					clicBorrar(txtDir,clickDir);
					txtDir.setText("Introduce la Dirección");
					clickDir = false;
					okDir = false;
				}
			}
		});
		txtDir.setFont(new Font("Arial", Font.ITALIC, 13));
		txtDir.setText("Introduce la Direcci\u00F3n");
		txtDir.setBorder(null);
		txtDir.setBounds(93, 134, 349, 26);
		contentPanel.add(txtDir);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
		lblTelfono.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelfono.setBounds(10, 172, 92, 26);
		contentPanel.add(lblTelfono);
		
		txtTel = new JTextFieldModificado();
		txtTel.setBeepActivado(false);
		txtTel.setTipoValidacion(2);
		txtTel.setLimite(8);
		txtTel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickTel){
					clicBorrar(txtTel,clickTel);
					clickTel = true;
					txtTel.setForeground(null);
					okTel = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTel.getText().isEmpty()){
					clicBorrar(txtTel,clickTel);
					txtTel.setText("Introduce el Teléfono");
					clickTel = false;
					okTel = false;
				}
				else{
					String texto = txtTel.getText();

					if(texto.charAt(0) == '0' || texto.trim().length() < 8){
						txtTel.setForeground(Color.RED);
						txtTel.setText("Teléfono no válido");
						clickTel = false;
						okTel = false;
					}

				}
			}
		});
		txtTel.setText("Introduce el Tel\u00E9fono");
		txtTel.setFont(new Font("Arial", Font.ITALIC, 13));
		txtTel.setBorder(null);
		txtTel.setBounds(93, 172, 349, 26);
		contentPanel.add(txtTel);
		
		JLabel lblSector = new JLabel("Sector: ");
		lblSector.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSector.setBounds(10, 209, 92, 26);
		contentPanel.add(lblSector);
		
		cmbSect = new JComboBox();
		cmbSect.setFont(new Font("Arial", Font.ITALIC, 13));
		cmbSect.setModel(new DefaultComboBoxModel(Sector.values()));
		cmbSect.setBounds(93, 209, 349, 26);
		contentPanel.add(cmbSect);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(135, 206, 235));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnActu = new BotonAnimacion();
			btnActu.setFocusPainted(false);
			btnActu.setFocusTraversalKeysEnabled(false);
			btnActu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ediEmp(act, pos)){
						JOptionPane.showMessageDialog(null, "Presione Actualizar para Visualizar los Cambios", "Nota", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Error al Crear Empresa.\n Posibles Causas:\n 1- Campos vacíos o incorrectos.\n 2- Ya existe una empresa del mismo Nombre", "Error" , JOptionPane.ERROR_MESSAGE); 
					}
				}
			});
			btnActu.setIcon(new ImageIcon(EditarEmpresa.class.getResource("/icons/empresa/icons8-actualizar-24.png")));
			btnActu.setText("Actualizar");
			btnActu.setBorderPainted(false);
			buttonPane.add(btnActu);
			
			btnmcnCancelar = new BotonAnimacion();
			btnmcnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnmcnCancelar.setIcon(new ImageIcon(EditarEmpresa.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
			btnmcnCancelar.setFocusPainted(false);
			btnmcnCancelar.setText("Cancelar");
			buttonPane.add(btnmcnCancelar);
			

			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					btnmcnCancelar.requestFocusInWindow();
				}
			});
		}
	}
	
	public EditarEmpresa(Empresa emp, int pos){
		iniciarComponetes(emp, pos);
		txtNom.setText(emp.getNombre());
		txtDir.setText(emp.getDireccion());
		txtTel.setText(emp.getTelefeno());
		cmbSect.setSelectedItem(Sector.valueOf(emp.getSector()));;
	}

}
