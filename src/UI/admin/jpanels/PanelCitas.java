package UI.admin.jpanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelCitas extends JPanel {

	/**
	 * Create the panel.
	 */
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
	}

}
