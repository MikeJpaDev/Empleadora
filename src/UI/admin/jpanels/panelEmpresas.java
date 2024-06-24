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
		
		JButton btnVer = new JButton("Ver  ");
		btnVer.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVer.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		btnVer.setSize(new Dimension(5, 5));
		btnVer.setHorizontalTextPosition(SwingConstants.LEFT);
		btnVer.setForeground(Color.WHITE);
		btnVer.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnVer.setFocusTraversalPolicyProvider(true);
		btnVer.setFocusPainted(false);
		btnVer.setBorderPainted(false);
		btnVer.setBorder(null);
		btnVer.setBackground(new Color(30, 144, 255));
		btnVer.setBounds(715, 225, 134, 42);
		add(btnVer);
		
		JButton btnEditar = new JButton("A\u00F1adir");
		btnEditar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEditar.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnEditar.setSize(new Dimension(5, 5));
		btnEditar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnEditar.setFocusTraversalPolicyProvider(true);
		btnEditar.setFocusPainted(false);
		btnEditar.setBorderPainted(false);
		btnEditar.setBorder(null);
		btnEditar.setBackground(new Color(30, 144, 255));
		btnEditar.setBounds(715, 300, 134, 42);
		add(btnEditar);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEditar_1.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		btnEditar_1.setSize(new Dimension(5, 5));
		btnEditar_1.setHorizontalTextPosition(SwingConstants.LEFT);
		btnEditar_1.setForeground(Color.WHITE);
		btnEditar_1.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnEditar_1.setFocusTraversalPolicyProvider(true);
		btnEditar_1.setFocusPainted(false);
		btnEditar_1.setBorderPainted(false);
		btnEditar_1.setBorder(null);
		btnEditar_1.setBackground(new Color(30, 144, 255));
		btnEditar_1.setBounds(715, 372, 134, 42);
		add(btnEditar_1);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBorrar.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		btnBorrar.setSize(new Dimension(5, 5));
		btnBorrar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnBorrar.setFocusTraversalPolicyProvider(true);
		btnBorrar.setFocusPainted(false);
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBorder(null);
		btnBorrar.setBackground(new Color(30, 144, 255));
		btnBorrar.setBounds(715, 448, 134, 42);
		add(btnBorrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBuscar.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		btnBuscar.setSize(new Dimension(5, 5));
		btnBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		btnBuscar.setFocusTraversalPolicyProvider(true);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(30, 144, 255));
		btnBuscar.setBounds(715, 122, 134, 42);
		add(btnBuscar);
	}
}
