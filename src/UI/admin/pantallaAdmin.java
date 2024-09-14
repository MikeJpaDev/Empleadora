package UI.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;

import UI.IniciarSesion;
import UI.admin.jdialog.CrearEmpresa;
import UI.admin.jdialog.CrearUsuario;
import UI.admin.jdialog.Reportes;
import UI.admin.jpanels.PanelCitas;
import UI.admin.jpanels.PanelEmpleos;
import UI.admin.jpanels.PanelPrincipal;
import UI.admin.jpanels.PanelRegistros;
import UI.admin.jpanels.PanelUsuarios;
import UI.admin.jpanels.panelEmpresas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.Principal;

import javax.swing.JCheckBoxMenuItem;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

public class pantallaAdmin extends JFrame {

	private JPanel contentPane;
	private panelEmpresas verEmpr;
	private static JPanel contentPanels;
	private PanelUsuarios verUsers = new PanelUsuarios();
	private PanelEmpleos pEmpleos;
	private PanelCitas pCitas;
	private PanelRegistros pRegistros;
	private PanelPrincipal pPrincipal = new PanelPrincipal();
	

	
	public pantallaAdmin() {
		llenarComponentes();
		cambiarPantalla(pPrincipal);
	}
	
	private void terminarVentana(){
		this.dispose();
		IniciarSesion sesion = new IniciarSesion();
		sesion.setVisible(true);
	}
	
	private void llenarComponentes(){
		setTitle("SIGEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaAdmin.class.getResource("/images/empresa/logo redondo 64.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 640);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(rootPane, "Cerrar Sesión?", null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					terminarVentana();
				}
			}
		});
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mntmInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPantalla(pPrincipal);
			}
		});
		mnArchivo.add(mntmInicio);
		mnArchivo.add(mntmSalir);
		
		JMenu mnEmpresas = new JMenu("Empresas");
		menuBar.add(mnEmpresas);
		
		JMenuItem mntmVerEmpresas = new JMenuItem("Ver Empresas");
		mntmVerEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verEmpr = new panelEmpresas();
				cambiarPantalla(verEmpr);
				panelEmpresas.actTabla();
			}
		});
		mnEmpresas.add(mntmVerEmpresas);
		
		JMenu mnEmpleos = new JMenu("Empleos");
		menuBar.add(mnEmpleos);
		
		JMenuItem mntmListaDeEmpleos = new JMenuItem("Lista de Empleos");
		mntmListaDeEmpleos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pEmpleos = new PanelEmpleos();
				cambiarPantalla(pEmpleos);
				PanelEmpleos.actTabla();
			}
		});
		mnEmpleos.add(mntmListaDeEmpleos);
		
		JMenuItem mntmCrearEmpleo = new JMenuItem("Crear Empleo");
		mnEmpleos.add(mntmCrearEmpleo);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmListaDeUsuarios = new JMenuItem("Lista de Usuarios");
		mntmListaDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPantalla(verUsers);
			}
		});
		mnUsuarios.add(mntmListaDeUsuarios);
		
		JMenuItem mntmCrearUsuario = new JMenuItem("Crear Usuario");
		mntmCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnUsuarios.add(mntmCrearUsuario);
		
		JMenu mnCitas = new JMenu("Citas");
		menuBar.add(mnCitas);
		
		JMenuItem mntmVerCitas = new JMenuItem("Ver Citas");
		mntmVerCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pCitas = new PanelCitas();
				PanelCitas.llenarTabla();
				cambiarPantalla(pCitas);
			}
		});
		mnCitas.add(mntmVerCitas);
		
		JMenuItem mntmAdministrarCitas = new JMenuItem("Administrar Citas");
		mnCitas.add(mntmAdministrarCitas);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmAbrirRegistros = new JMenuItem("Abrir Registros");
		mntmAbrirRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes r = new Reportes();
				r.setVisible(true);
			}
		});
		mnRegistro.add(mntmAbrirRegistros);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanels = new JPanel();
		contentPanels.setPreferredSize(new Dimension(884, 580));
		contentPanels.setSize(new Dimension(884, 580));
		contentPanels.setBackground(new Color(135, 206, 235));
		contentPanels.setMaximumSize(new Dimension(884, 580));
		contentPane.add(contentPanels);
		contentPanels.setLayout(new BorderLayout(0, 0));
	
	}
	
	public static void cambiarPantalla(JPanel pantalla){
		pantalla.setSize(884, 580);
		pantalla.setLocation(284, 0);
		contentPanels.removeAll();
		contentPanels.setLayout(new BorderLayout(0, 0));
		contentPanels.add(pantalla);
		contentPanels.revalidate();
		contentPanels.repaint();
	}
}
