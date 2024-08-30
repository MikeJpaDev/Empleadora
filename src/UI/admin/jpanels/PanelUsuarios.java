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
		
		JButton button = new JButton("Buscar");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		button.setSize(new Dimension(5, 5));
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button.setFocusTraversalPolicyProvider(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(30, 144, 255));
		button.setBounds(715, 119, 134, 42);
		add(button);
		
		JButton button_1 = new JButton("Ver  ");
		button_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		button_1.setSize(new Dimension(5, 5));
		button_1.setHorizontalTextPosition(SwingConstants.LEFT);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_1.setFocusTraversalPolicyProvider(true);
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(30, 144, 255));
		button_1.setBounds(715, 222, 134, 42);
		add(button_1);
		
		JButton button_2 = new JButton("A\u00F1adir");
		button_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CrearUsuario dialog = new CrearUsuario();
					dialog.setLocationRelativeTo(null);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					txtBuscar.setText(dialog.cambTxt());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		button_2.setSize(new Dimension(5, 5));
		button_2.setHorizontalTextPosition(SwingConstants.LEFT);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_2.setFocusTraversalPolicyProvider(true);
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(30, 144, 255));
		button_2.setBounds(715, 297, 134, 42);
		add(button_2);
		
		JButton button_3 = new JButton("Editar");
		button_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		button_3.setSize(new Dimension(5, 5));
		button_3.setHorizontalTextPosition(SwingConstants.LEFT);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_3.setFocusTraversalPolicyProvider(true);
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(30, 144, 255));
		button_3.setBounds(715, 369, 134, 42);
		add(button_3);
		
		JButton button_4 = new JButton("Borrar");
		button_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_4.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		button_4.setSize(new Dimension(5, 5));
		button_4.setHorizontalTextPosition(SwingConstants.LEFT);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_4.setFocusTraversalPolicyProvider(true);
		button_4.setFocusPainted(false);
		button_4.setBorderPainted(false);
		button_4.setBorder(null);
		button_4.setBackground(new Color(30, 144, 255));
		button_4.setBounds(715, 445, 134, 42);
		add(button_4);

	}
}
