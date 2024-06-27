package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import panels.empresaR;
import panels.usuarioR;
import principal.Empleadora;
import principal.Empresa;
import principal.Usuario;
import componentesVisuales.Linea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import componentesVisuales.BotonAnimacion;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnEmpresa;
	private JRadioButton rdbtnPersona;
	private JPanel panelRepaint;
	/**
	 * @wbp.nonvisual location=472,59
	 */
	private ButtonGroup buttonGroup;
	
	private void terminarVentana(){
		this.dispose();
		IniciarSesion sesion = new IniciarSesion();
		sesion.setVisible(true);
	}
	
	public Registrarse() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 432);
		contentPane = new JPanel();
		contentPane.setFocusTraversalKeysEnabled(false);
		contentPane.setBackground(new Color(204, 230, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneSuRol = new JLabel("Seleccione su Rol");
		lblSeleccioneSuRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneSuRol.setFont(new Font("Arial", Font.BOLD, 17));
		lblSeleccioneSuRol.setBounds(139, 11, 153, 14);
		contentPane.add(lblSeleccioneSuRol);
		
		rdbtnEmpresa = new JRadioButton("Empresa");
		rdbtnEmpresa.setSelected(true);
		rdbtnEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				empresaR cambio = new empresaR();
				cambio.setLocation(0, -25);
				rdbtnPersona.setSelected(false);
				panelRepaint.removeAll();
				panelRepaint.setLayout(null);
				panelRepaint.add(cambio);
				panelRepaint.revalidate();
				panelRepaint.repaint();
			}
		});
		rdbtnEmpresa.setFocusPainted(false);
		rdbtnEmpresa.setContentAreaFilled(false);
		rdbtnEmpresa.setOpaque(false);
		rdbtnEmpresa.setBounds(91, 32, 77, 23);
		contentPane.add(rdbtnEmpresa);
		
		rdbtnPersona = new JRadioButton("Persona");
		rdbtnPersona.addMouseListener(new MouseAdapter() {
			usuarioR cambio;
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					cambio = new usuarioR();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				cambio.setLocation(0, -15);
				rdbtnEmpresa.setSelected(false);
				panelRepaint.removeAll();
				panelRepaint.setLayout(null);
				panelRepaint.add(cambio);
				panelRepaint.revalidate();
				panelRepaint.repaint();
			}
		});
		rdbtnPersona.setFocusPainted(false);
		rdbtnPersona.setOpaque(false);
		rdbtnPersona.setBounds(262, 32, 77, 23);
		contentPane.add(rdbtnPersona);
		
		panelRepaint = new JPanel();
		panelRepaint.setBackground(new Color(204, 230, 230));
		panelRepaint.setBounds(0, 53, 436, 292);
		contentPane.add(panelRepaint);
		panelRepaint.setLayout(null);
		
		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.setBounds(123, 356, 169, 36);
		contentPane.add(botonAnimacion);
		botonAnimacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				terminarVentana();
			}
		});
		botonAnimacion.setText("Cancelar");
		botonAnimacion.setFocusPainted(false);
		
		empresaR cambio = new empresaR();
		cambio.setLocation(0, -25);
		rdbtnPersona.setSelected(false);
		panelRepaint.removeAll();
		panelRepaint.setLayout(null);
		panelRepaint.add(cambio);
		panelRepaint.revalidate();
		panelRepaint.repaint();
		
		getButtonGroup();
	}
	
	private ButtonGroup getButtonGroup(){
		if(buttonGroup == null){
			buttonGroup = new ButtonGroup();
		}
		buttonGroup.add(rdbtnEmpresa);
		buttonGroup.add(rdbtnPersona);
		return buttonGroup;
	}
	
	private String obtenerRol(){
		
		String rol = "";
		if(rdbtnEmpresa.isSelected()){
			rol = "empresa";
		}
		else if(rdbtnPersona.isSelected()){
			rol = "persona";
		}
		return rol;
		
	}
}
