package UI.admin.jpanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PanelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		
		JLabel lblBiembenidoA = new JLabel("Bienvenido a");
		lblBiembenidoA.setFont(new Font("Roboto Black", Font.BOLD, 30));
		lblBiembenidoA.setBounds(209, 11, 211, 48);
		panel.add(lblBiembenidoA);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/empresa/logo redondo 64.png")));
		label_2.setBounds(525, 0, 86, 70);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("SIGEM");
		label_3.setFont(new Font("Roboto Black", Font.BOLD, 30));
		label_3.setBounds(415, 11, 112, 48);
		panel.add(label_3);
	}

}
