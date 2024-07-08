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
		
		JButton button = new JButton("Ver  ");
		button.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		button.setSize(new Dimension(5, 5));
		button.setHorizontalTextPosition(SwingConstants.LEFT);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button.setFocusTraversalPolicyProvider(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(30, 144, 255));
		button.setAlignmentX(0.5f);
		button.setBounds(713, 191, 134, 42);
		add(button);
		
		JButton button_1 = new JButton("A\u00F1adir");
		button_1.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		button_1.setSize(new Dimension(5, 5));
		button_1.setHorizontalTextPosition(SwingConstants.LEFT);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_1.setFocusTraversalPolicyProvider(true);
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(30, 144, 255));
		button_1.setAlignmentX(0.5f);
		button_1.setBounds(713, 266, 134, 42);
		add(button_1);
		
		JButton button_2 = new JButton("Editar");
		button_2.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		button_2.setSize(new Dimension(5, 5));
		button_2.setHorizontalTextPosition(SwingConstants.LEFT);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_2.setFocusTraversalPolicyProvider(true);
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(30, 144, 255));
		button_2.setAlignmentX(0.5f);
		button_2.setBounds(713, 338, 134, 42);
		add(button_2);
		
		JButton button_3 = new JButton("Borrar");
		button_3.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		button_3.setSize(new Dimension(5, 5));
		button_3.setHorizontalTextPosition(SwingConstants.LEFT);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		button_3.setFocusTraversalPolicyProvider(true);
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(30, 144, 255));
		button_3.setAlignmentX(0.5f);
		button_3.setBounds(713, 414, 134, 42);
		add(button_3);
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
