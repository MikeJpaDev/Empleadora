package panels;

import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import UI.IniciarSesion;
import UI.InicioUsuario;
import UI.Registrarse;
import componentesVisuales.CampoCIValidado;

import java.awt.Font;

import javax.swing.SwingConstants;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JPasswordField;

import principal.Empleadora;
import principal.Usuario;
import componentesVisuales.BotonAnimacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class usuarioR extends JPanel {
	private JPasswordField cont;
	private JLabel label_5;
	private JTextFieldModificado nombreField;
	private CampoCIValidado campoCIValidado;
	private JTextFieldModificado direccion;
	private JTextFieldModificado nEscolar;
	private JTextFieldModificado exp;
	private JTextFieldModificado telf;
	private char echoCharCont;
	private JTextFieldModificado espc;
	
	private void terminarRegistro(){
		((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
	}
	
	public usuarioR() throws ParseException {
		this.setBounds(0, 82, 436, 345);
		this.setBackground(new Color(204, 230, 230));
		setLayout(null);
		
		campoCIValidado = new CampoCIValidado();
		campoCIValidado.setHorizontalAlignment(SwingConstants.CENTER);
		campoCIValidado.setFont(new Font("Arial", Font.PLAIN, 15));
		campoCIValidado.setOpaque(false);
		campoCIValidado.setBounds(10, 57, 169, 20);
		campoCIValidado.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		add(campoCIValidado);
		
		JLabel lblCi = new JLabel("CI:");
		lblCi.setFont(new Font("Arial", Font.BOLD, 14));
		lblCi.setBounds(10, 36, 63, 20);
		add(lblCi);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Arial", Font.BOLD, 14));
		label_1.setBounds(257, 36, 63, 20);
		add(label_1);
		
		nombreField = new JTextFieldModificado();
		nombreField.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz");
		nombreField.setTipoValidacion(0);
		nombreField.setOpaque(false);
		nombreField.setLimite(8);
		nombreField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		nombreField.setBeepActivado(false);
		nombreField.setBackground(new Color(135, 206, 235));
		nombreField.setBounds(257, 57, 169, 20);
		add(nombreField);
		
		direccion = new JTextFieldModificado();
		direccion.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		direccion.setToolTipText("");
		direccion.setTipoValidacion(4);
		direccion.setOpaque(false);
		direccion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		direccion.setBeepActivado(false);
		direccion.setBackground(new Color(135, 206, 235));
		direccion.setBounds(10, 109, 169, 20);
		add(direccion);
		
		JLabel label_2 = new JLabel("Direcci\u00F3n:");
		label_2.setFont(new Font("Arial", Font.BOLD, 14));
		label_2.setBounds(10, 88, 81, 20);
		add(label_2);
		
		telf = new JTextFieldModificado();
		telf.setValidacionPersonalizada("1234567890");
		telf.setToolTipText("");
		telf.setTipoValidacion(2);
		telf.setOpaque(false);
		telf.setLimite(8);
		telf.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		telf.setBeepActivado(false);
		telf.setBackground(new Color(135, 206, 235));
		telf.setBounds(257, 109, 169, 20);
		add(telf);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono:");
		label_3.setFont(new Font("Arial", Font.BOLD, 14));
		label_3.setBounds(257, 88, 81, 20);
		add(label_3);
		
		nEscolar = new JTextFieldModificado();
		nEscolar.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		nEscolar.setToolTipText("");
		nEscolar.setTipoValidacion(1);
		nEscolar.setOpaque(false);
		nEscolar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		nEscolar.setBeepActivado(false);
		nEscolar.setBackground(new Color(135, 206, 235));
		nEscolar.setBounds(10, 161, 169, 20);
		add(nEscolar);
		
		JLabel lblNivelEscolar = new JLabel("Nivel Escolar:");
		lblNivelEscolar.setFont(new Font("Arial", Font.BOLD, 14));
		lblNivelEscolar.setBounds(10, 140, 106, 20);
		add(lblNivelEscolar);
		
		espc = new JTextFieldModificado();
		espc.setValidacionPersonalizada("abcdefghijklmn\u00F1opqrstuvwxz%1234567890");
		espc.setToolTipText("");
		espc.setTipoValidacion(1);
		espc.setOpaque(false);
		espc.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		espc.setBeepActivado(false);
		espc.setBackground(new Color(135, 206, 235));
		espc.setBounds(257, 161, 169, 20);
		add(espc);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblEspecialidad.setBounds(257, 140, 106, 20);
		add(lblEspecialidad);
		
		exp = new JTextFieldModificado();
		exp.setValidacionPersonalizada("1234567890");
		exp.setToolTipText("");
		exp.setTipoValidacion(2);
		exp.setOpaque(false);
		exp.setLimite(8);
		exp.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		exp.setBeepActivado(false);
		exp.setBackground(new Color(135, 206, 235));
		exp.setBounds(10, 213, 169, 20);
		add(exp);
		
		JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de Experiencia:");
		lblAosDeExperiencia.setFont(new Font("Arial", Font.BOLD, 14));
		lblAosDeExperiencia.setBounds(10, 192, 153, 20);
		add(lblAosDeExperiencia);
		
		label_5 = new JLabel("");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(new MouseAdapter() {
			int click = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (click == 0){
					label_5.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24.png")));
					cont.setEchoChar((char)0);
					click = 1;
				}
				else{
					label_5.setIcon(new ImageIcon(IniciarSesion.class.getResource("/icons/icons8-eye-24 (1).png")));
					cont.setEchoChar((char) echoCharCont);
					click = 0;
				}
				
			}
		});
		label_5.setIcon(new ImageIcon(usuarioR.class.getResource("/icons/icons8-eye-24 (1).png")));
		label_5.setBounds(402, 192, 24, 58);
		add(label_5);
		
		cont = new JPasswordField();
		cont.setToolTipText("Introduce la contrase\u00F1a");
		cont.setOpaque(false);
		cont.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		cont.setBackground(new Color(135, 206, 235));
		cont.setBounds(257, 211, 169, 20);
		this.echoCharCont = cont.getEchoChar();
		add(cont);
		
		JLabel label_4 = new JLabel("Contrase\u00F1a:");
		label_4.setFont(new Font("Arial", Font.BOLD, 14));
		label_4.setBounds(257, 192, 86, 20);
		add(label_4);
		
		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ci = campoCIValidado.getText();
				String nombre = nombreField.getText();
				String telefono = telf.getText();
				boolean disp = false;
				
				if(ci != null && nombre != null && telefono != null && camposVacios()){
					disp = usuarioDisp(nombre, telefono, ci);
					if (disp){
						Empleadora e1 = Empleadora.getInstancia();
						char sexo = campoCIValidado.getSexoChar();
						int edad = campoCIValidado.getEdad();
						int expe = Integer.parseInt(exp.getText());
						e1.getUsuarios().add(new Usuario(ci, nombre, cont.getText(),sexo , direccion.getText(), telf.getText(), nEscolar.getText(), espc.getText(), expe, edad));
						JOptionPane.showMessageDialog(null, "Usuario creado correctamente, presione cancelar", "Exito", JOptionPane.INFORMATION_MESSAGE);
						terminarRegistro();
						IniciarSesion frame = new IniciarSesion();
						frame.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "El Usuario, Carnet o Telefono ya existen", "Error al Registrar", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error al Registrar", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
			}
		});
		botonAnimacion.setText("Aceptar");
		botonAnimacion.setFocusPainted(false);
		botonAnimacion.setBounds(122, 264, 169, 36);
		add(botonAnimacion);
		
		
	}
	
	private boolean usuarioDisp(String nombre, String telf, String ci){
		Empleadora e = Empleadora.getInstancia();
		ArrayList<Usuario> usuarios = e.getUsuarios();
		boolean ok = false;
	    
		
		for(int i = 0; i < usuarios.size() && !ok; i++){
			if (!usuarios.get(i).getNombre().equals(nombre) && !usuarios.get(i).getTelefono().equals(telf) && !usuarios.get(i).getCI().equals(ci)){
				ok = true;
			}
		}
		
		return ok;
	}
	
	private boolean camposVacios(){
		boolean vacio = false;
		if(direccion.getText() != null && nEscolar.getText() != null && espc.getText() != null && exp.getText() != null && cont.getText() != null){
			vacio = true;
		}
		return vacio;
	}
}
