package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Insets;
import javax.swing.ButtonGroup;

public class CrearUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNom;
	private JTextField txtId;
	private JTextField txtTel;
	private JTextField txtDir;
	private boolean clickName = false;
	private boolean clickId = false;
	private boolean clickTel = false;
	private boolean clickDir = false;
	
	private void clicBorrar(JTextField jtext, boolean click){
		if(click){
			jtext.setFont(new Font("Arial", Font.ITALIC, 13));
		}
		else{
			jtext.setText("");
			jtext.setFont(new Font("Arial", Font.BOLD, 13));
		}
	}
	
	public String cambTxt(){
		String c1;
		c1 = txtNom.getText();
		return c1;
	}
	
	public CrearUsuario() {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Crear usuario");
		setBounds(100, 100, 465, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 191, 255));
			panel.setBounds(0, 0, 459, 42);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCrearUsuario = new JLabel("Crear Usuario");
				lblCrearUsuario.setIcon(new ImageIcon(CrearUsuario.class.getResource("/images/empresa/Usuarios 38px.png")));
				lblCrearUsuario.setHorizontalAlignment(SwingConstants.CENTER);
				lblCrearUsuario.setFont(new Font("Roboto Black", Font.BOLD, 20));
				lblCrearUsuario.setBounds(10, 0, 439, 42);
				panel.add(lblCrearUsuario);
			}
		}
		{
			JLabel lblNombre = new JLabel("* Nombre :");
			lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblNombre.setBounds(10, 60, 80, 26);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblCarnetDeIdentidad = new JLabel("CI");
			lblCarnetDeIdentidad.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblCarnetDeIdentidad.setBounds(10, 100, 80, 26);
			contentPanel.add(lblCarnetDeIdentidad);
		}
		{
			JLabel lblTelfono = new JLabel("Tel\u00E9fono");
			lblTelfono.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblTelfono.setBounds(10, 140, 80, 26);
			contentPanel.add(lblTelfono);
		}
		{
			JLabel lblDireccin = new JLabel("Direcci\u00F3n");
			lblDireccin.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblDireccin.setBounds(10, 180, 80, 26);
			contentPanel.add(lblDireccin);
		}
		{
			txtNom = new JTextField();
			txtNom.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(!clickName){
						clicBorrar(txtNom,clickName);
						clickName = true;
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtNom.getText().isEmpty()){
						clicBorrar(txtNom,clickName);
						txtNom.setText("Nombre Completo");
						clickName = false;
					}
				}
			});
			txtNom.setFont(new Font("Arial", Font.ITALIC, 13));
			txtNom.setText("Nombre Completo");
			txtNom.setBorder(new EmptyBorder(0, 5, 0, 5));
			txtNom.setBounds(100, 60, 349, 26);
			contentPanel.add(txtNom);
			txtNom.setColumns(10);
		}
		{
			txtId = new JTextField();
			txtId.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(!clickId){
						clicBorrar(txtId,clickId);
						clickId = true;
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtId.getText().isEmpty()){
						clicBorrar(txtId,clickId);
						txtId.setText("Carnet de Identidad");
						clickId = false;
					}
				}
			});
			txtId.setText("Carnet de Identidad");
			txtId.setFont(new Font("Arial", Font.ITALIC, 13));
			txtId.setColumns(10);
			txtId.setBorder(new EmptyBorder(0, 5, 0, 5));
			txtId.setBounds(100, 100, 349, 26);
			contentPanel.add(txtId);
		}
		{
			txtTel = new JTextField();
			txtTel.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(!clickTel){
						clicBorrar(txtTel,clickTel);
						clickTel = true;
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtTel.getText().isEmpty()){
						clicBorrar(txtTel,clickTel);
						txtTel.setText("N\u00FAmero de Tel\u00E9fono");
						clickTel = false;
					}
				}
			});
			txtTel.setText("N\u00FAmero de Tel\u00E9fono");
			txtTel.setFont(new Font("Arial", Font.ITALIC, 13));
			txtTel.setColumns(10);
			txtTel.setBorder(new EmptyBorder(0, 5, 0, 5));
			txtTel.setBounds(100, 140, 349, 26);
			contentPanel.add(txtTel);
		}
		{
			txtDir = new JTextField();
			txtDir.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(!clickDir){
						clicBorrar(txtDir,clickDir);
						clickDir = true;
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtDir.getText().isEmpty()){
						clicBorrar(txtDir,clickDir);
						txtDir.setText("Direcci\u00F3n");
						clickDir = false;
					}
				}
			});
			txtDir.setText("Direcci\u00F3n");
			txtDir.setFont(new Font("Arial", Font.ITALIC, 13));
			txtDir.setColumns(10);
			txtDir.setBorder(new EmptyBorder(0, 5, 0, 5));
			txtDir.setBounds(100, 180, 349, 26);
			contentPanel.add(txtDir);
		}
		{
			JLabel lblSexo = new JLabel("Sexo");
			lblSexo.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblSexo.setBounds(10, 220, 80, 26);
			contentPanel.add(lblSexo);
		}
		{
			JLabel lblNivelDeEscolaridad = new JLabel("Nivel de Escolaridad");
			lblNivelDeEscolaridad.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblNivelDeEscolaridad.setBounds(10, 260, 155, 26);
			contentPanel.add(lblNivelDeEscolaridad);
		}
		{
			JLabel lblEspecialidad = new JLabel("Especialidad");
			lblEspecialidad.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblEspecialidad.setBounds(10, 300, 118, 26);
			contentPanel.add(lblEspecialidad);
		}
		{
			JLabel lblRama = new JLabel("Rama");
			lblRama.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblRama.setBounds(10, 340, 80, 26);
			contentPanel.add(lblRama);
		}
		{
			JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de Experiencia");
			lblAosDeExperiencia.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblAosDeExperiencia.setBounds(10, 380, 136, 26);
			contentPanel.add(lblAosDeExperiencia);
		}
		
		JRadioButton rdbSexoMasc = new JRadioButton("Masculino");
		rdbSexoMasc.setMargin(new Insets(0, 0, 0, 0));
		rdbSexoMasc.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		rdbSexoMasc.setBorder(null);
		rdbSexoMasc.setBackground(new Color(135, 206, 235));
		rdbSexoMasc.setBounds(143, 220, 97, 23);
		contentPanel.add(rdbSexoMasc);
		
		JRadioButton rdbSexoFem = new JRadioButton("Femenino");
		rdbSexoFem.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		rdbSexoFem.setBorder(null);
		rdbSexoFem.setBackground(new Color(135, 206, 235));
		rdbSexoFem.setBounds(309, 220, 109, 23);
		contentPanel.add(rdbSexoFem);
		
		JComboBox cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setBounds(171, 260, 278, 26);
		contentPanel.add(cmbEspecialidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 300, 307, 26);
		contentPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 340, 249, 26);
		contentPanel.add(comboBox_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(156, 380, 84, 26);
		contentPanel.add(spinner);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cambTxt();  //Pruebas
						dispose();	//Pruebas
					}
				});
				okButton.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
				okButton.setFocusPainted(false);
				okButton.setBorderPainted(false);
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(30, 144, 255));
				okButton.setFont(new Font("Roboto Black", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon("E:\\Proyectos de Programaci\u00F3n\\Java\\Empleadora\\src\\icons\\empresa\\icons8-cancelar-24.png"));
				cancelButton.setFocusPainted(false);
				cancelButton.setBorderPainted(false);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(new Color(30, 144, 255));
				cancelButton.setFont(new Font("Roboto Black", Font.BOLD, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
