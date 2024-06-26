package panels;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import UI.IniciarSesion;
import UI.InicioUsuario;
import UI.Registrarse;
import componentesVisuales.CampoCIValidado;

import java.awt.Font;

import javax.swing.SwingConstants;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JPasswordField;

import componentesVisuales.BotonAnimacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class usuarioR extends JPanel {
	private JPasswordField passwordField;
	private JLabel label_5;
	
	public usuarioR() throws ParseException {
		this.setBounds(0, 82, 436, 345);
		this.setBackground(new Color(204, 230, 230));
		setLayout(null);
		
		CampoCIValidado campoCIValidado = new CampoCIValidado();
		campoCIValidado.setHorizontalAlignment(SwingConstants.CENTER);
		campoCIValidado.setFont(new Font("Arial", Font.PLAIN, 15));
		campoCIValidado.setOpaque(false);
		campoCIValidado.setBounds(10, 78, 169, 20);
		campoCIValidado.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		add(campoCIValidado);
		
		JLabel lblCi = new JLabel("CI:");
		lblCi.setFont(new Font("Arial", Font.BOLD, 14));
		lblCi.setBounds(10, 57, 63, 20);
		add(lblCi);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(257, 57, 63, 20);
		add(label_1);
		
		JTextFieldModificado textFieldModificado = new JTextFieldModificado();
		textFieldModificado.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz");
		textFieldModificado.setTipoValidacion(0);
		textFieldModificado.setOpaque(false);
		textFieldModificado.setLimite(8);
		textFieldModificado.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado.setBeepActivado(false);
		textFieldModificado.setBackground(new Color(135, 206, 235));
		textFieldModificado.setBounds(257, 78, 169, 20);
		add(textFieldModificado);
		
		JTextFieldModificado textFieldModificado_1 = new JTextFieldModificado();
		textFieldModificado_1.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		textFieldModificado_1.setToolTipText("");
		textFieldModificado_1.setTipoValidacion(4);
		textFieldModificado_1.setOpaque(false);
		textFieldModificado_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_1.setBeepActivado(false);
		textFieldModificado_1.setBackground(new Color(135, 206, 235));
		textFieldModificado_1.setBounds(10, 130, 169, 20);
		add(textFieldModificado_1);
		
		JLabel label_2 = new JLabel("Direcci\u00F3n:");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(10, 109, 81, 20);
		add(label_2);
		
		JTextFieldModificado textFieldModificado_2 = new JTextFieldModificado();
		textFieldModificado_2.setValidacionPersonalizada("1234567890");
		textFieldModificado_2.setToolTipText("");
		textFieldModificado_2.setTipoValidacion(2);
		textFieldModificado_2.setOpaque(false);
		textFieldModificado_2.setLimite(8);
		textFieldModificado_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_2.setBeepActivado(false);
		textFieldModificado_2.setBackground(new Color(135, 206, 235));
		textFieldModificado_2.setBounds(257, 130, 169, 20);
		add(textFieldModificado_2);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono:");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(257, 109, 81, 20);
		add(label_3);
		
		JTextFieldModificado textFieldModificado_3 = new JTextFieldModificado();
		textFieldModificado_3.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		textFieldModificado_3.setToolTipText("");
		textFieldModificado_3.setTipoValidacion(1);
		textFieldModificado_3.setOpaque(false);
		textFieldModificado_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_3.setBeepActivado(false);
		textFieldModificado_3.setBackground(new Color(135, 206, 235));
		textFieldModificado_3.setBounds(10, 182, 169, 20);
		add(textFieldModificado_3);
		
		JLabel lblNivelEscolar = new JLabel("Nivel Escolar:");
		lblNivelEscolar.setFont(new Font("Arial", Font.BOLD, 14));
		lblNivelEscolar.setBounds(10, 161, 106, 20);
		add(lblNivelEscolar);
		
		JTextFieldModificado textFieldModificado_4 = new JTextFieldModificado();
		textFieldModificado_4.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		textFieldModificado_4.setToolTipText("");
		textFieldModificado_4.setTipoValidacion(1);
		textFieldModificado_4.setOpaque(false);
		textFieldModificado_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_4.setBeepActivado(false);
		textFieldModificado_4.setBackground(new Color(135, 206, 235));
		textFieldModificado_4.setBounds(257, 182, 169, 20);
		add(textFieldModificado_4);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblEspecialidad.setBounds(257, 161, 106, 20);
		add(lblEspecialidad);
		
		JTextFieldModificado textFieldModificado_5 = new JTextFieldModificado();
		textFieldModificado_5.setValidacionPersonalizada("1234567890");
		textFieldModificado_5.setToolTipText("");
		textFieldModificado_5.setTipoValidacion(2);
		textFieldModificado_5.setOpaque(false);
		textFieldModificado_5.setLimite(8);
		textFieldModificado_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		textFieldModificado_5.setBeepActivado(false);
		textFieldModificado_5.setBackground(new Color(135, 206, 235));
		textFieldModificado_5.setBounds(10, 234, 169, 20);
		add(textFieldModificado_5);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de Experiencia:");
		lblAosDeExperiencia.setFont(new Font("Arial", Font.BOLD, 14));
		lblAosDeExperiencia.setBounds(10, 213, 153, 20);
		add(lblAosDeExperiencia);
		
		label_5 = new JLabel("");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(new MouseAdapter() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (click == 0){
					label_5.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24.png")));
					click = 1;
				}
				else{
					label_5.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24 (1).png")));
					click = 0;
				}
				
			}
		});
		label_5.setIcon(new ImageIcon(usuarioR.class.getResource("/icons/icons8-eye-24 (1).png")));
		label_5.setBounds(402, 213, 24, 58);
		add(label_5);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Introduce la contrase\u00F1a");
		passwordField.setOpaque(false);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		passwordField.setBackground(new Color(135, 206, 235));
		passwordField.setBounds(257, 232, 169, 20);
		add(passwordField);
		
		JLabel label_4 = new JLabel("Contrase\u00F1a:");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(257, 213, 86, 20);
		add(label_4);
	}
}
