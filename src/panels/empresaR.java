package panels;

import java.awt.Color;

import javax.swing.JPanel;

import UI.IniciarSesion;
import UI.Registrarse;
import componentesVisuales.JTextFieldModificado;

import javax.swing.border.MatteBorder;

import java.awt.SystemColor;

import componentesVisuales.AvatarCircular;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import componentesVisuales.BotonAnimacion;

import java.awt.Cursor;

public class empresaR extends JPanel {
	private JPasswordField passwordField;
	private JLabel label_1;

	
	public empresaR() {
		this.setBounds(0, 82, 436, 321);
		this.setBackground(new Color(204, 230, 230));
		setLayout(null);
		
		JTextFieldModificado textFieldModificado = new JTextFieldModificado();
		textFieldModificado.setTipoValidacion(0);
		textFieldModificado.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz");
		textFieldModificado.setOpaque(false);
		textFieldModificado.setLimite(8);
		textFieldModificado.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado.setBeepActivado(false);
		textFieldModificado.setBackground(new Color(135, 206, 235));
		textFieldModificado.setBounds(10, 99, 169, 20);
		add(textFieldModificado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(10, 78, 63, 20);
		add(lblNombre);
		
		JTextFieldModificado textFieldModificado_1 = new JTextFieldModificado();
		textFieldModificado_1.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		textFieldModificado_1.setToolTipText("");
		textFieldModificado_1.setTipoValidacion(4);
		textFieldModificado_1.setOpaque(false);
		textFieldModificado_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_1.setBeepActivado(false);
		textFieldModificado_1.setBackground(new Color(135, 206, 235));
		textFieldModificado_1.setBounds(10, 151, 169, 20);
		add(textFieldModificado_1);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Arial", Font.BOLD, 14));
		lblDireccin.setBounds(10, 130, 81, 20);
		add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelfono.setBounds(257, 78, 81, 20);
		add(lblTelfono);
		
		JTextFieldModificado textFieldModificado_2 = new JTextFieldModificado();
		textFieldModificado_2.setValidacionPersonalizada("1234567890");
		textFieldModificado_2.setToolTipText("");
		textFieldModificado_2.setTipoValidacion(2);
		textFieldModificado_2.setOpaque(false);
		textFieldModificado_2.setLimite(8);
		textFieldModificado_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_2.setBeepActivado(false);
		textFieldModificado_2.setBackground(new Color(135, 206, 235));
		textFieldModificado_2.setBounds(257, 99, 169, 20);
		add(textFieldModificado_2);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setFont(new Font("Arial", Font.BOLD, 14));
		lblSector.setBounds(257, 130, 81, 20);
		add(lblSector);
		
		JTextFieldModificado textFieldModificado_3 = new JTextFieldModificado();
		textFieldModificado_3.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz");
		textFieldModificado_3.setToolTipText("");
		textFieldModificado_3.setTipoValidacion(0);
		textFieldModificado_3.setOpaque(false);
		textFieldModificado_3.setLimite(12);
		textFieldModificado_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_3.setBeepActivado(false);
		textFieldModificado_3.setBackground(new Color(135, 206, 235));
		textFieldModificado_3.setBounds(257, 151, 169, 20);
		add(textFieldModificado_3);
		
		JLabel label = new JLabel("Contrase\u00F1a:");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(122, 182, 86, 20);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(empresaR.class.getResource("/icons/icons8-eye-24 (1).png")));
		label_1.addMouseListener(new MouseAdapter() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (click == 0){
					label_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24.png")));
					click = 1;
				}
				else{
					label_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24 (1).png")));
					click = 0;
				}
				
			}
		});
		label_1.setBounds(267, 182, 24, 58);
		add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Introduce la contrase\u00F1a");
		passwordField.setOpaque(false);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		passwordField.setBackground(new Color(135, 206, 235));
		passwordField.setBounds(122, 201, 169, 20);
		add(passwordField);
	}
}
