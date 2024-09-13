package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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

import logica.Empleadora;
import logica.utilidades.logica.Sexo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CrearUsuarioNomb extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JTextFieldModificado txtCi;
	private JTextFieldModificado txtTel;
	private JTextFieldModificado txtNombre;
	private boolean clickNombre = false;

	private void crearUser(){
		try {
			CrearUsuario dialog = new CrearUsuario();
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

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
		
		txtNombre = new JTextFieldModificado();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//if()
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		txtNombre.setValidacionPersonalizada("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ Ò·ÈÌÛ˙¡…Õ”⁄ ");
		txtNombre.setTipoValidacion(4);
		txtNombre.setText("Nombre Completo");
		txtNombre.setFont(new Font("Arial", Font.ITALIC, 13));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtNombre.setBounds(100, 53, 349, 26);
		contentPanel.add(txtNombre);
		
		txtCi = new JTextFieldModificado();
		txtCi.setTipoValidacion(2);
		txtCi.setText("Carnet de Identidad");
		txtCi.setPreferredSize(new Dimension(6, 20));
		txtCi.setLimite(11);
		txtCi.setFont(new Font("Arial", Font.ITALIC, 13));
		txtCi.setBorder(null);
		txtCi.setAlignmentX(1.0f);
		txtCi.setBounds(100, 93, 349, 26);
		contentPanel.add(txtCi);
		
		JLabel label_1 = new JLabel("CI");
		label_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label_1.setBounds(10, 93, 80, 26);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Tel\u00E9fono");
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label_2.setBounds(10, 133, 80, 26);
		contentPanel.add(label_2);
		
		txtTel = new JTextFieldModificado();
		txtTel.setTipoValidacion(2);
		txtTel.setText("Tel\u00E9fono");
		txtTel.setPreferredSize(new Dimension(6, 20));
		txtTel.setLimite(8);
		txtTel.setFont(new Font("Arial", Font.ITALIC, 13));
		txtTel.setBorder(null);
		txtTel.setAlignmentX(1.0f);
		txtTel.setBounds(100, 135, 349, 26);
		contentPanel.add(txtTel);
		
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
				btnmcnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							Empleadora.getInstancia().esNuevo(txtCi.getText());
							crearUser();
						}catch(IllegalArgumentException e1){
							JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnmcnCrear.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
				btnmcnCrear.setText("Siguiente");
				buttonPane.add(btnmcnCrear);
			}
			{
				btnCancel = new BotonAnimacion();
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setFocusPainted(false);
				btnCancel.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
				btnCancel.setText("Cancelar");
				buttonPane.add(btnCancel);
			}
		}
	}
}
