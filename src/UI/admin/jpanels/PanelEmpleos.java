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

public class PanelEmpleos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEmpleos() {
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
		scrollPane.setBounds(34, 136, 644, 405);
		add(scrollPane);
		
		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion_1.setText("Ver");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(688, 179, 134, 42);
		add(botonAnimacion_1);
		
		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_2.setText("A\u00F1adir");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(688, 245, 134, 42);
		add(botonAnimacion_2);
		
		BotonAnimacion botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		botonAnimacion_3.setText("Editar");
		botonAnimacion_3.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_3.setBounds(688, 316, 134, 42);
		add(botonAnimacion_3);
		
		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(688, 388, 134, 42);
		add(botonAnimacion_4);
		
		BotonAnimacion botonAnimacion_5 = new BotonAnimacion();
		botonAnimacion_5.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-actualizar-24.png")));
		botonAnimacion_5.setText("Actualizar");
		botonAnimacion_5.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_5.setBounds(688, 461, 134, 42);
		add(botonAnimacion_5);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
