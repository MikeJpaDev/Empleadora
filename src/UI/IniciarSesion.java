package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import raven.swing.AvatarIcon;

import javax.swing.Icon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import UI.admin.pantallaAdmin;
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

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import principal.Empleadora;
import principal.Empresa;
import principal.Usuario;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JLabel labelOjo;
	private JTextFieldModificado lblUser;
	private JPasswordField lblCont;
	private char echoCharCont;
	
	private void abrirUsuario(){
		Empleadora e = Empleadora.getInstancia();
		ArrayList<Usuario> actuales = e.getUsuarios();
		ArrayList<Empresa> empresa = e.getEmpresas();
		boolean encontrado = false;
		boolean error = true;
		String cont = lblCont.getText();
		String user = lblUser.getText();
		
		for(int i = 0; i < actuales.size() && !encontrado; i++){
			if(actuales.get(i).getNombre().equals(user) && actuales.get(i).getPsswd().equals(cont)){
				if(actuales.get(i).getNombre().equals("admin")){
					this.dispose();
					pantallaAdmin pantalla = new pantallaAdmin();
					pantalla.setVisible(true);
					encontrado = true;
					error = false;
				}
				else{
					this.dispose();
					InicioUsuario usr = new InicioUsuario(actuales.get(i));
					usr.setVisible(true);
					encontrado = true;
					error = false;
				}
			}
		}
		
		if(!encontrado){
			for(int i = 0; i < empresa.size() && !encontrado; i++){
				if(empresa.get(i).getNombre().equals(user) && empresa.get(i).getCont().equals(cont)){
					this.dispose();
					InicioUsuario usr = new InicioUsuario(empresa.get(i));
					usr.setVisible(true);
					encontrado = true;
					error = false;
				}
			}
		}
		if(error){
			JOptionPane.showMessageDialog(null, "Revise sus credenciales", "Error al Iniciar Sesión", JOptionPane.ERROR_MESSAGE);
			lblCont.setText("");
			lblUser.setText("");
		}
		
		
	}
	
	private void abrirRegitro(){
		this.dispose();
		Registrarse regis = new Registrarse();
		regis.setVisible(true);
	}
	
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
		panel.setBackground(new Color(204, 230, 230));
		panel.setBorder(null);
		panel.setBounds(0, 0, 633, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Linea linea = new Linea(0, 0);
		linea.setColor(new Color(0, 153, 153));
		linea.setBounds(376, 0, 11, 362);
		panel.add(linea);
		
		AvatarCircular avatarCircular = new AvatarCircular();
		avatarCircular.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		avatarCircular.setAvatar(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-usuario-100.png")));
		avatarCircular.setBounds(446, 17, 125, 125);
		panel.add(avatarCircular);
		
		lblUser = new JTextFieldModificado();
		lblUser.setOpaque(false);
		lblUser.setToolTipText("");
		lblUser.setBeepActivado(false);
		lblUser.setLimite(8);
		lblUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		lblUser.setBackground(new Color(135, 206, 235));
		lblUser.setTipoValidacion(0);
		lblUser.setBounds(427, 173, 169, 20);
		panel.add(lblUser);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsuario.setBounds(427, 153, 63, 20);
		panel.add(lblUsuario);
		
		final JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasea.setBounds(427, 199, 86, 20);
		panel.add(lblContrasea);
		
		lblCont = new JPasswordField();
		
		labelOjo = new JLabel("");

		this.echoCharCont = lblCont.getEchoChar();
		labelOjo.addMouseListener(new MouseAdapter() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (click == 0){
					labelOjo.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24.png")));
					lblCont.setEchoChar((char)0);
					click = 1;
				}
				else{
					labelOjo.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24 (1).png")));
					lblCont.setEchoChar((char) echoCharCont);
					click = 0;
				}
				
			}
		});
		labelOjo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelOjo.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24 (1).png")));
		labelOjo.setBounds(572, 199, 24, 58);
		panel.add(labelOjo);
		lblCont.setOpaque(false);
		lblCont.setToolTipText("Introduce la contrase\u00F1a");
		lblCont.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		lblCont.setBackground(new Color(135, 206, 235));
		lblCont.setBounds(427, 218, 169, 20);
		panel.add(lblCont);
		
		BotonAnimacion btnmcnIniciarSesin = new BotonAnimacion();
		btnmcnIniciarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirUsuario();
			}
		});
		btnmcnIniciarSesin.setFocusPainted(false);
		btnmcnIniciarSesin.setBorderPainted(false);
		btnmcnIniciarSesin.setText("Iniciar Sesi\u00F3n");
		btnmcnIniciarSesin.setBounds(427, 265, 169, 29);
		panel.add(btnmcnIniciarSesin);
		
		BotonAnimacion btnmcnRegistrarse = new BotonAnimacion();
		btnmcnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirRegitro();
			}
		});
		btnmcnRegistrarse.setText("Registrarse");
		btnmcnRegistrarse.setFocusPainted(false);
		btnmcnRegistrarse.setBorderPainted(false);
		btnmcnRegistrarse.setBounds(427, 305, 169, 29);
		panel.add(btnmcnRegistrarse);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/621d26b292a9c1000165c39e-removebg-preview.png")));
		lblNewLabel.setBounds(12, 0, 375, 362);
		panel.add(lblNewLabel);
	}
}
