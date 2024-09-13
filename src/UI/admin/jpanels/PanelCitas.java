package UI.admin.jpanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.CitasTableModel;
import util.EmpresasTableModel;
import componentesVisuales.BotonAnimacion;
import javax.swing.SwingConstants;

public class PanelCitas extends JPanel {
	private JTable tableCitas;
	private static CitasTableModel tableModel;

	//Llenar tabla
	
	public PanelCitas() {
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelCitas.class.getResource("/images/empresa/Calendario 64px.png")));
		label.setBounds(763, 0, 75, 70);
		panel.add(label);
		
		JLabel lblCitas = new JLabel("Citas");
		lblCitas.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblCitas.setBounds(677, 11, 100, 48);
		panel.add(lblCitas);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PanelCitas.class.getResource("/images/empresa/logo redondo 64.png")));
		label_2.setBounds(32, 0, 86, 70);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("SIGEM");
		label_3.setFont(new Font("Roboto Black", Font.BOLD, 24));
		label_3.setBounds(110, 11, 112, 48);
		panel.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 130, 644, 419);
		add(scrollPane);
		
		tableCitas = new JTable();
		tableCitas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableCitas.setGridColor(new Color(192, 192, 192));
		tableCitas.setBorder(null);
		scrollPane.setViewportView(tableCitas);
		
		tableModel = new CitasTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableCitas.setModel(tableModel);
		
		BotonAnimacion btnAñadirCita = new BotonAnimacion();
		btnAñadirCita.setIcon(new ImageIcon(PanelCitas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnAñadirCita.setText("A\u00F1adir");
		btnAñadirCita.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAñadirCita.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAñadirCita.setFocusPainted(false);
		btnAñadirCita.setBounds(690, 130, 134, 42);
		add(btnAñadirCita);
		
		BotonAnimacion btnBorrar = new BotonAnimacion();
		btnBorrar.setIcon(new ImageIcon(PanelCitas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		btnBorrar.setText("Borrar");
		btnBorrar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBorrar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnBorrar.setFocusPainted(false);
		btnBorrar.setBounds(690, 196, 134, 42);
		add(btnBorrar);
		
	}
}
