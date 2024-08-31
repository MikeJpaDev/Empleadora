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

import componentesVisuales.JTextFieldModificado;

import java.awt.Dimension;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;

import sun.security.jca.GetInstance;
import logica.Empleadora;
import logica.candidato.Candidato;
import logica.enums.NivelEscolar;
import logica.enums.Sector;
import componentesVisuales.BotonAnimacion;
import logica.enums.Genero;

public class CrearUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNom;
	private JTextField txtDir;
	private boolean clickName = false;
	private boolean clickId = false;
	private boolean clickTel = false;
	private boolean clickDir = false;
	private JTextFieldModificado txtId;
	private JTextFieldModificado txtTel;
	private JComboBox cmbNvEscolar;
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JSpinner spinner;
	private JComboBox cmbGen;

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
			JLabel lblNombre = new JLabel("Nombre :");
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
			JLabel lblSexo = new JLabel("Sexo: ");
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

		cmbNvEscolar = new JComboBox();
		cmbNvEscolar.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbNvEscolar.setModel(new DefaultComboBoxModel(NivelEscolar.values()));
		cmbNvEscolar.setBounds(171, 260, 278, 26);
		contentPanel.add(cmbNvEscolar);
		

		JComboBox cmbEspc = new JComboBox();
		cmbEspc.setBounds(100, 300, 307, 26);
		contentPanel.add(cmbEspc);

		JComboBox cmbRama = new JComboBox();
		cmbRama.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbRama.setModel(new DefaultComboBoxModel(Sector.values()));
		cmbRama.setBounds(100, 340, 249, 26);
		contentPanel.add(cmbRama);

		spinner = new JSpinner();
		spinner.setBounds(156, 380, 84, 26);
		contentPanel.add(spinner);

		txtId = new JTextFieldModificado();
		txtId.setTipoValidacion(2);
		txtId.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtId.setPreferredSize(new Dimension(6, 20));
		txtId.setLimite(11);
		txtId.setFont(new Font("Arial", Font.ITALIC, 13));
		txtId.setText("Carnet de Identidad");
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickId){
					clicBorrar(txtId,clickId);
					txtId.setForeground(null);
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
				else{
					if(txtId.getText().length() < 11){
						txtId.setForeground(Color.RED);
						txtId.setText("Carnet de Identidad no válido");
						clickId = false;
					}
				}
			}
		});
		txtId.setBorder(null);
		txtId.setBounds(100, 100, 349, 26);
		contentPanel.add(txtId);

		txtTel = new JTextFieldModificado();
		txtTel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickTel){
					clicBorrar(txtTel,clickTel);
					txtTel.setForeground(null);
					clickTel = true;
				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTel.getText().isEmpty()){
					clicBorrar(txtTel,clickTel);
					txtTel.setText("Teléfono");
					clickTel = false;
				}
				else{
					String texto = txtTel.getText();

					if(texto.charAt(0) == '0' || texto.trim().length() < 8){
						txtTel.setForeground(Color.RED);
						txtTel.setText("Teléfono no válido");
						clickTel = false;
					}

				}
			}
		});
		txtTel.setTipoValidacion(2);
		txtTel.setText("Tel\u00E9fono");
		txtTel.setPreferredSize(new Dimension(6, 20));
		txtTel.setLimite(8);
		txtTel.setFont(new Font("Arial", Font.ITALIC, 13));
		txtTel.setBorder(null);
		txtTel.setAlignmentX(1.0f);
		txtTel.setBounds(100, 142, 349, 26);
		contentPanel.add(txtTel);
		{
			cmbGen = new JComboBox();
			cmbGen.setModel(new DefaultComboBoxModel(Genero.values()));
			cmbGen.setFont(new Font("Arial", Font.PLAIN, 13));
			cmbGen.setBounds(100, 217, 349, 26);
			contentPanel.add(cmbGen);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnmcnCrear = new BotonAnimacion();
			btnmcnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Empleadora emp = Empleadora.getInstancia();
				}
			});
			btnmcnCrear.setFocusPainted(false);
			btnmcnCrear.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnmcnCrear.setText("Crear");
			buttonPane.add(btnmcnCrear);
			
			btnCancel = new BotonAnimacion();
			btnCancel.setFocusPainted(false);
			btnCancel.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
			btnCancel.setText("Cancelar");
			buttonPane.add(btnCancel);
		}
	}
}
