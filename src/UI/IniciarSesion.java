package UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import UI.admin.pantallaAdmin;
import componentesVisuales.AvatarCircular;
import componentesVisuales.Linea;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;

import componentesVisuales.BotonAnimacion;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IniciarSesion extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelOjo;
	private JTextFieldModificado lblUser;
	private JPasswordField lblCont;
	private char echoCharCont;
	
	private void abrirApp(){
		this.dispose();
		pantallaAdmin frame = new pantallaAdmin();
		frame.setVisible(true);
		
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
		lblUser.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					if(lblUser.getText().equals("admin") && lblCont.getText().equals("admin")){
						abrirApp();
					}
					else{
						JOptionPane.showMessageDialog(null, "Revise sus credenciales", "Error al Iniciar Sesi�n", JOptionPane.ERROR_MESSAGE);
						lblCont.setText("");
						lblUser.setText("");
					}
			}
		});
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
		lblCont.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					if(lblUser.getText().equals("admin") && lblCont.getText().equals("admin")){
						abrirApp();
					}
					else{
						JOptionPane.showMessageDialog(null, "Revise sus credenciales", "Error al Iniciar Sesi�n", JOptionPane.ERROR_MESSAGE);
						lblCont.setText("");
						lblUser.setText("");
					}
			}
		});
		
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
		btnmcnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblUser.getText().equals("admin") && lblCont.getText().equals("admin")){
					abrirApp();
				}
				else{
					JOptionPane.showMessageDialog(null, "Revise sus credenciales", "Error al Iniciar Sesi�n", JOptionPane.ERROR_MESSAGE);
					lblCont.setText("");
					lblUser.setText("");
				}
			}
		});
		btnmcnIniciarSesin.setFocusPainted(false);
		btnmcnIniciarSesin.setBorderPainted(false);
		btnmcnIniciarSesin.setText("Iniciar Sesi\u00F3n");
		btnmcnIniciarSesin.setBounds(427, 291, 169, 29);
		panel.add(btnmcnIniciarSesin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/621d26b292a9c1000165c39e-removebg-preview.png")));
		lblNewLabel.setBounds(12, 0, 375, 362);
		panel.add(lblNewLabel);
	}
}
