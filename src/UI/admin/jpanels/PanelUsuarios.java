package UI.admin.jpanels;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import UI.admin.pantallaAdmin;
import UI.admin.jdialog.CrearUsuario;
import util.EmpresasTableModel;
import util.UsersTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import componentesVisuales.BotonAnimacion;

public class PanelUsuarios extends JPanel {
	private JTextField txtBuscar;
	private JTable table;
	private UsersTableModel tableModel;

	public PanelUsuarios() {
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setMaximumSize(new Dimension(884, 580));
		setMinimumSize(new Dimension(884, 580));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/images/empresa/Usuarios 64px.png")));
		label.setBounds(778, 0, 75, 70);
		panel.add(label);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de Usuarios");
		lblListaDeUsuarios.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblListaDeUsuarios.setBounds(555, 11, 306, 48);
		panel.add(lblListaDeUsuarios);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/images/empresa/logo redondo 64.png")));
		label_1.setBounds(32, 0, 86, 70);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("SIGEM");
		label_2.setFont(new Font("Roboto Black", Font.BOLD, 24));
		label_2.setBounds(110, 11, 112, 48);
		panel.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(36, 183, 644, 358);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableModel = new UsersTableModel();
		table.setModel(tableModel);
		
		txtBuscar = new JTextField();
		txtBuscar.setText("Nombre/CI");
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(36, 119, 644, 42);
		add(txtBuscar);
		
		BotonAnimacion btnmcnBuscar = new BotonAnimacion();
		btnmcnBuscar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnBuscar.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		btnmcnBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnBuscar.setText("Buscar");
		btnmcnBuscar.setBounds(715, 119, 134, 42);
		add(btnmcnBuscar);
		
		BotonAnimacion btnmcnVer = new BotonAnimacion();
		btnmcnVer.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		btnmcnVer.setText("Ver");
		btnmcnVer.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnVer.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnVer.setBounds(715, 222, 134, 42);
		add(btnmcnVer);
		
		BotonAnimacion btnmcnAadir = new BotonAnimacion();
		btnmcnAadir.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnmcnAadir.setText("A\u00F1adir");
		btnmcnAadir.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnAadir.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnAadir.setBounds(715, 297, 134, 42);
		add(btnmcnAadir);
		
		BotonAnimacion btnmcnEditar = new BotonAnimacion();
		btnmcnEditar.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		btnmcnEditar.setText("Editar");
		btnmcnEditar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnEditar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnEditar.setBounds(715, 369, 134, 42);
		add(btnmcnEditar);
		
		BotonAnimacion btnmcnBorrar = new BotonAnimacion();
		btnmcnBorrar.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		btnmcnBorrar.setText("Borrar");
		btnmcnBorrar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnBorrar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnBorrar.setBounds(715, 445, 134, 42);
		add(btnmcnBorrar);

	}
}
