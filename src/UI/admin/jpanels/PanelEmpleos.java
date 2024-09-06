package UI.admin.jpanels;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import componentesVisuales.BotonAnimacion;
import util.EmpleoTableModel;
import util.EmpresasTableModel;

import javax.swing.JTable;

public class PanelEmpleos extends JPanel {
	private JTextField textField;
	private static JTable tableEmps;
	private static EmpleoTableModel tableModel;
	private BotonAnimacion botonAnimacion;
	private BotonAnimacion botonAnimacion_1;
	private BotonAnimacion botonAnimacion_2;
	private BotonAnimacion botonAnimacion_3;
	private BotonAnimacion botonAnimacion_4;

	public PanelEmpleos(){
		InicializarComponentes();
	}
	
	private void InicializarComponentes() {
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/images/empresa/curriculum 64px.png")));
		label.setBounds(783, 0, 75, 70);
		panel.add(label);
		
		JLabel lblListaDeEmpleos = new JLabel("Lista de Empleos");
		lblListaDeEmpleos.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblListaDeEmpleos.setBounds(568, 11, 227, 48);
		panel.add(lblListaDeEmpleos);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/images/empresa/logo redondo 64.png")));
		label_1.setBounds(32, 0, 86, 70);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("SIGEM");
		label_2.setFont(new Font("Roboto Black", Font.BOLD, 24));
		label_2.setBounds(110, 11, 112, 48);
		panel.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(34, 157, 644, 384);
		add(scrollPane);
		
		tableEmps = new JTable();
		tableEmps.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableEmps.setGridColor(new Color(192, 192, 192));
		tableEmps.setBorder(null);
		scrollPane.setViewportView(tableEmps);
		
		tableModel = new EmpleoTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableEmps.setModel(tableModel);
		
		botonAnimacion = new BotonAnimacion();
		botonAnimacion.setFocusPainted(false);
		botonAnimacion.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion.setText("Ver");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setBounds(688, 179, 134, 42);
		add(botonAnimacion);
		
		botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.setFocusPainted(false);
		botonAnimacion_1.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_1.setText("A\u00F1adir");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(688, 245, 134, 42);
		add(botonAnimacion_1);
		
		botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.setFocusPainted(false);
		botonAnimacion_2.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		botonAnimacion_2.setText("Editar");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(688, 316, 134, 42);
		add(botonAnimacion_2);
		
		botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setFocusPainted(false);
		botonAnimacion_3.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_3.setText("Borrar");
		botonAnimacion_3.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_3.setBounds(688, 388, 134, 42);
		add(botonAnimacion_3);
		
		botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-actualizar-24.png")));
		botonAnimacion_4.setText("Actualizar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(688, 461, 134, 42);
		add(botonAnimacion_4);
		
		textField = new JTextField();
		textField.setText("Introduce el Nombre");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Arial", Font.ITALIC, 22));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(34, 104, 644, 42);
		add(textField);
	}
}
