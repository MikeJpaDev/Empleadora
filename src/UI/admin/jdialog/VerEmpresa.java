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





import com.formdev.flatlaf.FlatLightLaf;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextFieldModificado txtNom;
	private JTextFieldModificado txtDir;
	private JTextFieldModificado txtTel;
	private boolean clickNom = false;
	private boolean clickDir = false;
	private boolean clickTel = false;

	private boolean okNom = false;
	private boolean okDir = false;
	private boolean okTel = false;
	private BotonAnimacion btnCrear;
	private JTextFieldModificado txtSect;
	
	

	public VerEmpresa(Empresa emp) {
		iniciarComponetes();
		txtNom.setText(emp.getNombre());
		txtDir.setText(emp.getDireccion());
		txtTel.setText(emp.getTelefeno());
		txtSect.setText(emp.getSector());	
	}

	private void iniciarComponetes(){
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Ver Empresa");
		setBounds(100, 100, 465, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(VerEmpresa.class.getResource("/icons/icons8-bank-building-80.png")));
			lblNewLabel.setBounds(196, 11, 82, 69);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNombre.setBounds(10, 98, 73, 26);
			contentPanel.add(lblNombre);
		}
		
		txtSect = new JTextFieldModificado();
		txtSect.setTipoValidacion(2);
		txtSect.setLimite(8);
		txtSect.setFont(new Font("Arial", Font.ITALIC, 13));
		txtSect.setEnabled(false);
		txtSect.setDisabledTextColor(Color.BLACK);
		txtSect.setBorder(null);
		txtSect.setBeepActivado(false);
		txtSect.setBounds(93, 209, 349, 26);
		contentPanel.add(txtSect);

		txtNom = new JTextFieldModificado();
		txtNom.setDisabledTextColor(Color.BLACK);
		txtNom.setEnabled(false);
		txtNom.setBeepActivado(false);
		txtNom.setFont(new Font("Arial", Font.ITALIC, 13));
		txtNom.setText("Introduce el Nombre");
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
		txtDir.setDisabledTextColor(Color.BLACK);
		txtDir.setEnabled(false);
		txtDir.setBeepActivado(false);
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
		txtTel.setDisabledTextColor(Color.BLACK);
		txtTel.setEnabled(false);
		txtTel.setBeepActivado(false);
		txtTel.setTipoValidacion(2);
		txtTel.setLimite(8);
		txtTel.setText("Introduce el Tel\u00E9fono");
		txtTel.setFont(new Font("Arial", Font.ITALIC, 13));
		txtTel.setBorder(null);
		txtTel.setBounds(93, 172, 349, 26);
		contentPanel.add(txtTel);

		JLabel lblSector = new JLabel("Sector: ");
		lblSector.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSector.setBounds(10, 209, 92, 26);
		contentPanel.add(lblSector);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(135, 206, 235));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnCrear = new BotonAnimacion();
			btnCrear.setFocusPainted(false);
			btnCrear.setFocusTraversalKeysEnabled(false);
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCrear.setIcon(new ImageIcon(VerEmpresa.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnCrear.setText("Ok");
			btnCrear.setBorderPainted(false);
			buttonPane.add(btnCrear);


			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
				}
			});
		}
	}
}
