package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import Fechas.Dia;
import Fechas.Mes;
import componentesVisuales.Linea;
import componentesVisuales.JLabelAnimacion;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.SwingConstants;

import componentesVisuales.JLabelHora;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import principal.Empleadora;
import principal.Empresa;
import principal.Usuario;
import raven.popup.GlassPanePopup;
import raven.popup.GlassPopup;
import net.miginfocom.swing.MigLayout;

public class InicioUsuario extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private boolean clicked1 = false;
	private boolean clicked2 = false;
	private boolean clicked3 = false;
	private JLabel labelRuta;
	private JPanel panel_3;


	public boolean isClicked1() {
		return clicked1;
	}


	public void setClicked1(boolean clicked1) {
		this.clicked1 = clicked1;
	}


	public boolean isClicked2() {
		return clicked2;
	}


	public void setClicked2(boolean clicked2) {
		this.clicked2 = clicked2;
	}


	public boolean isClicked3() {
		return clicked3;
	}


	public void setClicked3(boolean clicked3) {
		this.clicked3 = clicked3;
	}
	
	private void terminarVentana(){
		this.dispose();
		IniciarSesion sesion = new IniciarSesion();
		sesion.setVisible(true);
	}


	public InicioUsuario(Object user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(0, 102, 102));
		panelOpciones.setBounds(0, 0, 229, 677);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);

		Linea linea = new Linea(0, 0);
		linea.setGrosor(1);
		linea.setColor(new Color(0, 0, 0));
		linea.setOrientacion(1);
		linea.setBounds(46, 60, 139, 14);
		panelOpciones.add(linea);

		JLabel lblSigem = new JLabel("SIGEM");
		lblSigem.setForeground(new Color(0, 0, 0));
		lblSigem.setFont(new Font("Arial", Font.BOLD, 14));
		lblSigem.setBounds(92, 45, 46, 14);
		panelOpciones.add(lblSigem);

		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(102, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!isClicked1()){
					panel.setBackground(new Color(0, 102, 102));	
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setBackground(new Color(102, 153, 153));
				panel_2.setBackground(new Color(0, 102, 102));	
				panel_1.setBackground(new Color(0, 102, 102));
				labelRuta.setText("Principal");
				setClicked1(true);
				setClicked2(false);
				setClicked3(false);
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(0, 85, 229, 45);
		panelOpciones.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-casa-24.png")));
		label.setBounds(10, 11, 24, 23);
		panel.add(label);

		JLabel lblPrincipal = new JLabel("Principal");
		lblPrincipal.setForeground(Color.BLACK);
		lblPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPrincipal.setFont(new Font("Arial", Font.BOLD, 17));
		lblPrincipal.setBounds(77, 11, 82, 23);
		panel.add(lblPrincipal);

		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(102, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!isClicked2()){
					panel_1.setBackground(new Color(0, 102, 102));	
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setBackground(new Color(102, 153, 153));
				panel_2.setBackground(new Color(0, 102, 102));	
				panel.setBackground(new Color(0, 102, 102));
				labelRuta.setText("Citas");
				setClicked1(false);
				setClicked2(true);
				setClicked3(false);
			}
		});
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setBounds(0, 130, 229, 45);
		panelOpciones.add(panel_1);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-cita-24.png")));
		label_1.setBounds(10, 11, 24, 23);
		panel_1.add(label_1);

		JLabel lblCitas = new JLabel("Citas");
		lblCitas.setForeground(Color.BLACK);
		lblCitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCitas.setFont(new Font("Arial", Font.BOLD, 17));
		lblCitas.setBounds(78, 11, 82, 23);
		panel_1.add(lblCitas);

		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(102, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!isClicked3()){
					panel_2.setBackground(new Color(0, 102, 102));	
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setBackground(new Color(102, 153, 153));
				panel_1.setBackground(new Color(0, 102, 102));
				panel.setBackground(new Color(0, 102, 102));
				labelRuta.setText("Solicitar Empleo");
				setClicked1(false);
				setClicked2(false);
				setClicked3(true);
			}
		});
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 102, 102));
		panel_2.setBounds(0, 175, 229, 45);
		panelOpciones.add(panel_2);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-trabajo-24.png")));
		label_2.setBounds(10, 11, 24, 23);
		panel_2.add(label_2);

		JLabel lblSolicitarEmpleo = new JLabel("Solicitar Empleo");
		lblSolicitarEmpleo.setForeground(Color.BLACK);
		lblSolicitarEmpleo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSolicitarEmpleo.setFont(new Font("Arial", Font.BOLD, 17));
		lblSolicitarEmpleo.setBounds(74, 11, 127, 23);
		panel_2.add(lblSolicitarEmpleo);

		panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(102, 153, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(0, 102, 102));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(rootPane, "Cerrar Sesión?", null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					terminarVentana();
				}
			}
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 102, 102));
		panel_3.setBounds(0, 219, 229, 45);
		panelOpciones.add(panel_3);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-open-door-24.png")));
		label_9.setBounds(10, 11, 24, 23);
		panel_3.add(label_9);

		JLabel lblCerrarSesin = new JLabel("Cerrar Sesi\u00F3n");
		lblCerrarSesin.setForeground(Color.BLACK);
		lblCerrarSesin.setFont(new Font("Arial", Font.BOLD, 17));
		lblCerrarSesin.setBounds(74, 11, 127, 23);
		panel_3.add(lblCerrarSesin);

		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(0, 153, 153));
		panelFecha.setBounds(227, 51, 791, 132);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);

		JLabel labelFecha = new JLabel("");
		labelFecha.setForeground(new Color(0, 0, 0));
		labelFecha.setFont(new Font("Arial", Font.PLAIN, 18));
		labelFecha.setBounds(40, 74, 299, 30);
		panelFecha.add(labelFecha);

		LocalDateTime hoy = LocalDateTime.now();
		Mes mes = new Mes();
		String mesEs = mes.getMes();
		Dia dia = new Dia();
		String diaEs = dia.getDiaEs();

		labelFecha.setText(diaEs + " " + hoy.getDayOfMonth() + " " + "de " + mesEs + " " + "de " + hoy.getYear());

		labelRuta = new JLabel("Principal ");
		labelRuta.setFont(new Font("Calibri", Font.BOLD, 16));
		labelRuta.setBounds(40, 28, 780, 35);
		panelFecha.add(labelRuta);
		
		String nombreUsuario;
		if (user instanceof Usuario){
			nombreUsuario  = ((Usuario) user).getNombre();
		}
		else{
			nombreUsuario  = ((Empresa) user).getNombre();
		}
		
		JLabel label_10 = new JLabel("Usuario: " + nombreUsuario);
		label_10.setFont(new Font("Arial", Font.PLAIN, 17));
		label_10.setBounds(630, 99, 151, 22);
		panelFecha.add(label_10);

		JLabel label_3 = new JLabel("");
		if(user instanceof Usuario){
			label_3.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-user-80.png")));
		}
		else{
			label_3.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-empresas-relacionadas-100.png")));
		}
		label_3.setBounds(570, 215, 119, 119);
		contentPane.add(label_3);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-empresas-relacionadas-100.png")));
		lblNewLabel.setBounds(570, 485, 101, 100);
		contentPane.add(lblNewLabel);

		JLabel label_4 = new JLabel("500");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Arial", Font.PLAIN, 23));
		label_4.setBounds(570, 596, 104, 22);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("New label");
		label_5.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-usuario-100.png")));
		label_5.setBounds(389, 477, 101, 100);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("500");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Arial", Font.PLAIN, 23));
		label_6.setBounds(389, 596, 104, 22);
		contentPane.add(label_6);

		JLabel lblUsuariosDeLa = new JLabel("Datos de la Plataforma");
		lblUsuariosDeLa.setFont(new Font("Arial", Font.PLAIN, 27));
		lblUsuariosDeLa.setBounds(478, 434, 335, 32);
		contentPane.add(lblUsuariosDeLa);

		JLabel label_7 = new JLabel("New label");
		label_7.setIcon(new ImageIcon(InicioUsuario.class.getResource("/icons/icons8-checkmark-100.png")));
		label_7.setBounds(746, 485, 101, 100);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("4.8");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Arial", Font.PLAIN, 23));
		label_8.setBounds(743, 596, 104, 22);
		contentPane.add(label_8);
	}
}
