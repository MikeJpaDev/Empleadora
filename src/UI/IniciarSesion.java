package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import raven.swing.AvatarIcon;

import javax.swing.Icon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import componentesVisuales.AvatarCircular;
import componentesVisuales.Linea;

import java.awt.Color;

import componentesVisuales.NotificacionesModernas;

import com.github.weisj.jsvg.nodes.Line;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import componentesVisuales.JTextFieldModificado;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import componentesVisuales.BotonAnimacion;
import raven.utils.FlatLafStyleUtils;
import logica.utilidades.interfaz.ManejadorLookAndFeels;
import java.awt.Toolkit;
import javax.swing.text.IconView;
import javax.swing.text.Element;
import com.github.weisj.jsvg.nodes.Image;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdIntroduceLaContrasea;
	
	public IniciarSesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Proyectos\\Java\\Empleadora\\Empleadora-master\\src\\icons\\icons8-usuario-30.png"));
		
		setResizable(false);
		setTitle("Autenticaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 391);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setName("");
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setBounds(0, 0, 633, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Linea linea = new Linea(0, 0);
		linea.setColor(Color.LIGHT_GRAY);
		linea.setBounds(376, 0, 11, 362);
		panel.add(linea);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		avatarCircular.setAvatar(new ImageIcon("D:\\Proyectos\\Java\\Empleadora\\Empleadora-master\\src\\icons\\icons8-usuario-100.png"));
		avatarCircular.setBounds(446, 17, 125, 125);
		panel.add(avatarCircular);
		
		JTextFieldModificado textFieldModificado = new JTextFieldModificado();
		textFieldModificado.setBeepActivado(false);
		textFieldModificado.setLimite(8);
		textFieldModificado.setBorder(null);
		textFieldModificado.setBackground(Color.LIGHT_GRAY);
		textFieldModificado.setTipoValidacion(0);
		textFieldModificado.setBounds(427, 173, 169, 20);
		panel.add(textFieldModificado);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsuario.setBounds(427, 153, 63, 20);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasea.setBounds(427, 199, 86, 20);
		panel.add(lblContrasea);
		
		pwdIntroduceLaContrasea = new JPasswordField();
		pwdIntroduceLaContrasea.setToolTipText("Introduce la contrase\u00F1a");
		pwdIntroduceLaContrasea.setBorder(null);
		pwdIntroduceLaContrasea.setBackground(Color.LIGHT_GRAY);
		pwdIntroduceLaContrasea.setBounds(427, 218, 169, 20);
		panel.add(pwdIntroduceLaContrasea);
		
		BotonAnimacion btnmcnIniciarSesin = new BotonAnimacion();
		btnmcnIniciarSesin.setFocusPainted(false);
		btnmcnIniciarSesin.setBorderPainted(false);
		btnmcnIniciarSesin.setText("Iniciar Sesi\u00F3n");
		btnmcnIniciarSesin.setBounds(427, 249, 169, 29);
		panel.add(btnmcnIniciarSesin);
		
		BotonAnimacion btnmcnRegistrarse = new BotonAnimacion();
		btnmcnRegistrarse.setText("Registrarse");
		btnmcnRegistrarse.setFocusPainted(false);
		btnmcnRegistrarse.setBorderPainted(false);
		btnmcnRegistrarse.setBounds(427, 289, 169, 29);
		panel.add(btnmcnRegistrarse);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Proyectos\\Java\\Empleadora\\Empleadora-master\\src\\icons\\621d26b292a9c1000165c39e-removebg-preview.png"));
		lblNewLabel.setBounds(12, 0, 375, 362);
		panel.add(lblNewLabel);
	}
}
