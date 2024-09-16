package UI.admin.jpanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import logica.Empleadora;
import util.JContador;
import javax.swing.SwingConstants;

public class PanelPrincipal extends JPanel {
	private static JContador cntEmpresas;
	private static JContador cntEmpleos;
	private static JContador cntCand;

	public static void actualizarContadores(){
		cntCand.actualizarContador(Empleadora.getInstancia().getCandidatos().size());
		cntEmpresas.actualizarContador(Empleadora.getInstancia().getEmpresas().size());
		cntEmpleos.actualizarContador(Empleadora.getInstancia().cantEmpelos());
	}
	
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
		
		JLabel lblFotoEmpresa = new JLabel("");
		lblFotoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoEmpresa.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/empresa/Empresa 100px.png")));
		lblFotoEmpresa.setBounds(120, 250, 150, 150);
		add(lblFotoEmpresa);
		
		JLabel lblFotoEmpleos = new JLabel("");
		lblFotoEmpleos.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/empresa/Curriculum 100px.png")));
		lblFotoEmpleos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoEmpleos.setBounds(342, 250, 150, 150);
		add(lblFotoEmpleos);
		
		JLabel lblFotoUsers = new JLabel("");
		lblFotoUsers.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsers.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/empresa/Usuarios 100px.png")));
		lblFotoUsers.setBounds(580, 250, 150, 150);
		add(lblFotoUsers);
		
		cntEmpresas = new JContador(Empleadora.getInstancia().getEmpresas().size());
		cntEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		cntEmpresas.setBounds(120, 399, 150, 23);
		add(cntEmpresas);
		
		cntEmpleos = new JContador(Empleadora.getInstancia().cantEmpelos());
		cntEmpleos.setHorizontalAlignment(SwingConstants.CENTER);
		cntEmpleos.setBounds(342, 399, 150, 23);
		add(cntEmpleos);
		
		cntCand = new JContador(Empleadora.getInstancia().getCandidatos().size());
		cntCand.setHorizontalAlignment(SwingConstants.CENTER);
		cntCand.setBounds(580, 399, 150, 23);
		add(cntCand);
		
		JLabel lblNewLabel = new JLabel("Empleos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(342, 230, 150, 31);
		add(lblNewLabel);
		
		JLabel lblEmpresas = new JLabel("Empresas");
		lblEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresas.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 19));
		lblEmpresas.setBounds(120, 230, 150, 31);
		add(lblEmpresas);
		
		JLabel lblCandidatos = new JLabel("Candidatos");
		lblCandidatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandidatos.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 19));
		lblCandidatos.setBounds(580, 230, 150, 31);
		add(lblCandidatos);
	}
	

}
