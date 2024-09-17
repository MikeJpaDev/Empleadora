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
import logica.candidato.Candidato;
import logica.enums.Genero;
import logica.utilidades.logica.Sexo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CrearUsuarioNomb extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JTextFieldModificado txtNombre;
	private JTextFieldModificado txtCi;
	private JTextFieldModificado txtTel;
	private JComboBox cmbSexo;
	private boolean nomClick = false;
	private boolean ciClick = false;
	private boolean telClick = false;

	private void crearUser(){
		try {
			CrearUsuario dialog = new CrearUsuario(txtNombre.getText(), txtCi.getText(), (Genero)cmbSexo.getSelectedItem(), txtTel.getText());
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
		
		JLabel label_1 = new JLabel("CI");
		label_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label_1.setBounds(10, 93, 80, 26);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Tel\u00E9fono");
		label_2.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		label_2.setBounds(10, 133, 80, 26);
		contentPanel.add(label_2);
		
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
		
		cmbSexo = new JComboBox();
		cmbSexo.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbSexo.setModel(new DefaultComboBoxModel(Genero.values()));
		cmbSexo.setBounds(68, 170, 287, 26);
		contentPanel.add(cmbSexo);
		
		txtNombre = new JTextFieldModificado();
		txtNombre.setText("Nombre del Candidato");
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                if (txtNombre.getText().equals("Nombre del Candidato") && !nomClick) {
                	txtNombre.setText("");
                	txtNombre.setForeground(Color.BLACK);
                	nomClick = true;
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (txtNombre.getText().isEmpty()) {
                	txtNombre.setText("Nombre del Candidato");
                	txtNombre.setForeground(Color.GRAY);
                	nomClick = false;
                }
			}
		});
		txtNombre.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtNombre.setBeepActivado(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombre.setValidacionPersonalizada("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ \u00E1\u00E9\u00ED\u00F3\u00C1\u00C9\u00CD\u00D3 \u00F1");
		txtNombre.setTipoValidacion(4);
		txtNombre.setBounds(100, 53, 349, 23);
		contentPanel.add(txtNombre);
		
		txtCi = new JTextFieldModificado();
		txtCi.setText("Carnet de Identidad");
		txtCi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                if (txtCi.getText().equals("Carnet de Identidad") && !ciClick) {
                	txtCi.setText("");
                	txtCi.setForeground(Color.BLACK);
                	ciClick = true;
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (txtCi.getText().isEmpty()) {
                	txtCi.setText("Carnet de Identidad");
                	txtCi.setForeground(Color.GRAY);
                	ciClick = false;
                }
			}
		});
		txtCi.setBeepActivado(false);
		txtCi.setLimite(11);
		txtCi.setColumns(10);
		txtCi.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtCi.setValidacionPersonalizada("0123456789");
		txtCi.setTipoValidacion(2);
		txtCi.setBounds(100, 93, 349, 23);
		contentPanel.add(txtCi);
		
		txtTel = new JTextFieldModificado();
		txtTel.setText("N\u00FAmero de Tel\u00E9fono");
		txtTel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                if (txtTel.getText().equals("Número de Teléfono") && !telClick) {
                	txtTel.setText("");
                	txtTel.setForeground(Color.BLACK);
                	telClick = true;
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (txtTel.getText().isEmpty()) {
                	txtTel.setText("Número de Teléfono");
                	txtTel.setForeground(Color.GRAY);
                	telClick = false;
                }
			}
		});
		txtTel.setBeepActivado(false);
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTel.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtTel.setLimite(9);
		txtTel.setValidacionPersonalizada("0123456789");
		txtTel.setTipoValidacion(2);
		txtTel.setBounds(100, 133, 349, 23);
		contentPanel.add(txtTel);
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
							
							if(!nomClick || !ciClick || !telClick)
								throw new IllegalArgumentException("Hay campos vacios");
							
							Candidato.validarNombre(txtNombre.getText());
							Candidato.validarTelef(txtTel.getText());
							Candidato.validarCi(txtCi.getText());
							Empleadora.getInstancia().esNuevo(txtCi.getText());
							dispose();
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
