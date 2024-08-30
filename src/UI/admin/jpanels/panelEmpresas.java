package UI.admin.jpanels;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import util.EmpresasTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Component;
import componentesVisuales.BotonAnimacion;

public class panelEmpresas extends JPanel {
	private JTable table;
	private EmpresasTableModel tableModel;
	private JTextField textFieldBuscar;
	
	public panelEmpresas() {
		componentes();
	}
	
	private void componentes(){
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(36, 186, 644, 358);
		add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(192, 192, 192));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(panelEmpresas.class.getResource("/images/empresa/Empresa 64px.png")));
		label.setBounds(775, 0, 75, 70);
		panel.add(label);
		
		JLabel lblListaDeEmplesas = new JLabel("Lista de Empresas Empleadoras");
		lblListaDeEmplesas.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblListaDeEmplesas.setBounds(373, 11, 409, 48);
		panel.add(lblListaDeEmplesas);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(panelEmpresas.class.getResource("/images/empresa/logo redondo 64.png")));
		lblNewLabel.setBounds(32, 0, 86, 70);
		panel.add(lblNewLabel);
		
		JLabel lblSigem = new JLabel("SIGEM");
		lblSigem.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblSigem.setBounds(110, 11, 112, 48);
		panel.add(lblSigem);
		
		tableModel = new EmpresasTableModel();
		table.setModel(tableModel);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setForeground(new Color(192, 192, 192));
		textFieldBuscar.setText("Nombre/IDs");
		textFieldBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBuscar.setBorder(null);
		textFieldBuscar.setBounds(36, 122, 644, 42);
		add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		botonAnimacion.setText("Buscar");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setBounds(715, 122, 134, 42);
		add(botonAnimacion);
		
		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion_1.setText("Ver");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(715, 225, 134, 42);
		add(botonAnimacion_1);
		
		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_2.setText("A\u00F1adir");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(715, 300, 134, 42);
		add(botonAnimacion_2);
		
		BotonAnimacion botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		botonAnimacion_3.setText("Editar");
		botonAnimacion_3.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_3.setBounds(715, 372, 134, 42);
		add(botonAnimacion_3);
		
		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(715, 448, 134, 42);
		add(botonAnimacion_4);
	}
}
