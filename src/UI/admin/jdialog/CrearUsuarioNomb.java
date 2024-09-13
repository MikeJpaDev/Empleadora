package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

import componentesVisuales.BotonAnimacion;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import componentesVisuales.JTextFieldModificado;

import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import logica.utilidades.logica.Sexo;

public class CrearUsuarioNomb extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearUsuarioNomb dialog = new CrearUsuarioNomb();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearUsuarioNomb() {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Crear usuario");
		setBounds(100, 100, 465, 295);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 459, 222);
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Nombre :");
		label.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label.setBounds(10, 53, 80, 26);
		contentPanel.add(label);
		
		textField = new JTextField();
		textField.setText("Nombre Completo");
		textField.setFont(new Font("Arial", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBorder(new EmptyBorder(0, 5, 0, 5));
		textField.setBounds(100, 53, 349, 26);
		contentPanel.add(textField);
		
		JTextFieldModificado textFieldModificado = new JTextFieldModificado();
		textFieldModificado.setTipoValidacion(2);
		textFieldModificado.setText("Carnet de Identidad");
		textFieldModificado.setPreferredSize(new Dimension(6, 20));
		textFieldModificado.setLimite(11);
		textFieldModificado.setFont(new Font("Arial", Font.ITALIC, 13));
		textFieldModificado.setBorder(null);
		textFieldModificado.setAlignmentX(1.0f);
		textFieldModificado.setBounds(100, 93, 349, 26);
		contentPanel.add(textFieldModificado);
		
		JLabel label_1 = new JLabel("CI");
		label_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label_1.setBounds(10, 93, 80, 26);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Tel\u00E9fono");
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label_2.setBounds(10, 133, 80, 26);
		contentPanel.add(label_2);
		
		JTextFieldModificado textFieldModificado_1 = new JTextFieldModificado();
		textFieldModificado_1.setTipoValidacion(2);
		textFieldModificado_1.setText("Tel\u00E9fono");
		textFieldModificado_1.setPreferredSize(new Dimension(6, 20));
		textFieldModificado_1.setLimite(8);
		textFieldModificado_1.setFont(new Font("Arial", Font.ITALIC, 13));
		textFieldModificado_1.setBorder(null);
		textFieldModificado_1.setAlignmentX(1.0f);
		textFieldModificado_1.setBounds(100, 135, 349, 26);
		contentPanel.add(textFieldModificado_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 459, 42);
		contentPanel.add(panel);
		
		JLabel label_3 = new JLabel("Crear Usuario");
		label_3.setIcon(new ImageIcon(CrearUsuarioNomb.class.getResource("/images/empresa/Usuarios 38px.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Roboto Black", Font.BOLD, 20));
		label_3.setBounds(10, 0, 439, 42);
		panel.add(label_3);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblSexo.setBounds(10, 170, 62, 26);
		contentPanel.add(lblSexo);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
		cmbSexo.setBounds(68, 170, 287, 26);
		contentPanel.add(cmbSexo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setBounds(0, 221, 459, 45);
			getContentPane().add(buttonPane);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT, 5, 5);
			buttonPane.setLayout(fl_buttonPane);
			{
				btnmcnCrear = new BotonAnimacion();
				btnmcnCrear.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
				btnmcnCrear.setText("Siguiente");
				buttonPane.add(btnmcnCrear);
			}
			{
				btnCancel = new BotonAnimacion();
				btnCancel.setFocusPainted(false);
				btnCancel.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
				btnCancel.setText("Cancelar");
				buttonPane.add(btnCancel);
			}
		}
	}
}
