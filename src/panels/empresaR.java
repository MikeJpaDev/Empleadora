package panels;

import java.awt.Color;

import javax.swing.JPanel;

import UI.IniciarSesion;
import UI.Registrarse;
import componentesVisuales.JTextFieldModificado;

import javax.swing.border.MatteBorder;

import java.awt.SystemColor;

import componentesVisuales.AvatarCircular;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JPasswordField;

import principal.Empleadora;
import principal.Empresa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import componentesVisuales.BotonAnimacion;

import java.awt.Cursor;
import java.util.ArrayList;

public class empresaR extends JPanel {
	private JPasswordField contEmp;
	private JLabel label_1;
	private char echoCharCont;
	private JTextFieldModificado nombreEmp;
	private JTextFieldModificado telfEmp;
	private JTextFieldModificado direcEmp;
	private JTextFieldModificado sectorEmp;
	
	private void terminarRegistro(){
		((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
	}

	
	public empresaR() {
		this.setBounds(0, 82, 436, 321);
		this.setBackground(new Color(204, 230, 230));
		setLayout(null);
		
		nombreEmp = new JTextFieldModificado();
		nombreEmp.setTipoValidacion(0);
		nombreEmp.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz");
		nombreEmp.setOpaque(false);
		nombreEmp.setLimite(8);
		nombreEmp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		nombreEmp.setBeepActivado(false);
		nombreEmp.setBackground(new Color(135, 206, 235));
		nombreEmp.setBounds(10, 99, 169, 20);
		add(nombreEmp);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(10, 78, 63, 20);
		add(lblNombre);
		
		direcEmp = new JTextFieldModificado();
		direcEmp.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		direcEmp.setToolTipText("");
		direcEmp.setTipoValidacion(4);
		direcEmp.setOpaque(false);
		direcEmp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		direcEmp.setBeepActivado(false);
		direcEmp.setBackground(new Color(135, 206, 235));
		direcEmp.setBounds(10, 151, 169, 20);
		add(direcEmp);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Arial", Font.BOLD, 14));
		lblDireccin.setBounds(10, 130, 81, 20);
		add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Arial", Font.BOLD, 14));
		lblTelfono.setBounds(257, 78, 81, 20);
		add(lblTelfono);
		
		telfEmp = new JTextFieldModificado();
		telfEmp.setValidacionPersonalizada("1234567890");
		telfEmp.setToolTipText("");
		telfEmp.setTipoValidacion(2);
		telfEmp.setOpaque(false);
		telfEmp.setLimite(8);
		telfEmp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		telfEmp.setBeepActivado(false);
		telfEmp.setBackground(new Color(135, 206, 235));
		telfEmp.setBounds(257, 99, 169, 20);
		add(telfEmp);
		
		JLabel lblSector = new JLabel("Sector:");
		lblSector.setFont(new Font("Arial", Font.BOLD, 14));
		lblSector.setBounds(257, 130, 81, 20);
		add(lblSector);
		
		sectorEmp = new JTextFieldModificado();
		sectorEmp.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz");
		sectorEmp.setToolTipText("");
		sectorEmp.setTipoValidacion(0);
		sectorEmp.setOpaque(false);
		sectorEmp.setLimite(12);
		sectorEmp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		sectorEmp.setBeepActivado(false);
		sectorEmp.setBackground(new Color(135, 206, 235));
		sectorEmp.setBounds(257, 151, 169, 20);
		add(sectorEmp);
		
		contEmp = new JPasswordField();
		contEmp.setToolTipText("Introduce la contrase\u00F1a");
		contEmp.setOpaque(false);
		contEmp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		contEmp.setBackground(new Color(135, 206, 235));
		contEmp.setBounds(122, 201, 169, 20);
		this.echoCharCont = contEmp.getEchoChar();
		
		label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(empresaR.class.getResource("/icons/icons8-eye-24 (1).png")));
		label_1.addMouseListener(new MouseAdapter() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (click == 0){
					label_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24.png")));
					contEmp.setEchoChar((char)0);
					click = 1;
				}
				else{
					label_1.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24 (1).png")));
					contEmp.setEchoChar((char) echoCharCont);
					click = 0;
				}
				
			}
		});
		label_1.setBounds(267, 182, 24, 58);
		add(label_1);
		add(contEmp);
		
		JLabel label = new JLabel("Contrase\u00F1a:");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(122, 182, 86, 20);
		add(label);
		
		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!camposVacios()){
					if(empresaDisp(nombreEmp.getText(), telfEmp.getText())){
						Empleadora e1 = Empleadora.getInstancia();
						e1.getEmpresas().add(new Empresa(nombreEmp.getText(), direcEmp.getText(), telfEmp.getText(), sectorEmp.getText(), contEmp.getText()));
						terminarRegistro();
						IniciarSesion frame = new IniciarSesion();
						frame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "El Usuario o Telefono ya existen", "Error al Registrar", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error al Registrar", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonAnimacion.setText("Aceptar");
		botonAnimacion.setFocusPainted(false);
		botonAnimacion.setBounds(122, 274, 169, 36);
		add(botonAnimacion);
		
		
	}
	
	private boolean empresaDisp(String user, String telf){
		Empleadora e = Empleadora.getInstancia();
		ArrayList<Empresa> empresas = e.getEmpresas();
		boolean dis = true;
		
		for (int i = 0; i < empresas.size() && dis; i++){
			if(empresas.get(i).getNombre().equals(user) || empresas.get(i).getNombre().equals(telf)){
				dis = false;
			}
		}
		
		return dis;
	}
	
	private boolean camposVacios(){
		boolean vacio = true;
		if(direcEmp.getText() != null && telfEmp.getText() != null && sectorEmp.getText() != null && nombreEmp.getText() != null && contEmp.getText() != null){
			vacio = false;
		}
		return vacio;
	}
}
