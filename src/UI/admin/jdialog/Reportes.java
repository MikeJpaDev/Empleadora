package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import componentesVisuales.BotonAnimacion;

import javax.swing.JLabel;

import java.awt.Font;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import logica.Empleadora;
import logica.candidato.Candidato;
import logica.cita.Cita;
import logica.empleo.Empleo;
import logica.empresa.Empresa;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

import util.CitasTableModel;
import util.EmpresasTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reportes extends JDialog {
	
	private static EmpresasTableModel tableModel;
	private JTable tableEmps;

	private ArrayList<Empleo> empleos(){

		ArrayList<Empleo> empleos = new ArrayList<>();
		Double sal = Double.MIN_VALUE;

		for (Empresa e: Empleadora.getInstancia().getEmpresas()){
			for (Empleo emp: e.getEmpleos()){
				if(emp.getSalario() > sal){
					empleos.clear();
					sal = (Double)emp.getSalario();
					empleos.add(emp);
				}
				else if(emp.getSalario() == sal){
					empleos.add(emp);
				}				
			}
		}
		
		System.out.println(empleos.size());
		return empleos;
	}

	public void mejorPagados(){

		Object[] datos = new Object[6];
		int cont = 1;
		ArrayList<Empleo> empleos = empleos();
		for (Empleo p: empleos){
			datos[0] = cont++;
			datos[1] = p.getID();
			datos[2] = p.getRama();
			datos[3] = "$" + p.getSalario();
			datos[4] = p.getEmpOfertante().getNombre();
			datos[5] = p.getRamaEmp();
			tableModel.addRow(datos);
		}
	}

	public Reportes() {
		setTitle("Reportes");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reportes.class.getResource("/images/empresa/curriculum 64px.png")));
		setBounds(100, 100, 599, 531);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 467, 583, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				BotonAnimacion btnmcnAceptar = new BotonAnimacion();
				btnmcnAceptar.setText("Aceptar");
				buttonPane.add(btnmcnAceptar);
			}
		}

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tabbedPane.setBackground(new Color(0, 255, 255));
		tabbedPane.setBounds(0, 0, 593, 467);
		getContentPane().add(tabbedPane);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Candidatos Mas Longevos", null, panelInfo, null);
		panelInfo.setLayout(null);

		JLabel lblNewLabel = new JLabel("Empleado");
		lblNewLabel.setBackground(new Color(0, 204, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Reportes.class.getResource("/images/empresa/Usuarios 64px.png")));
		lblNewLabel.setBounds(0, 11, 511, 73);
		panelInfo.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Candidatos Con Mas Citas", null, panel, null);
		{
			JPanel panelCitas = new JPanel();
			panelCitas.setBackground(new Color(135, 206, 235));
			tabbedPane.addTab("Empleos Mejor Pagados", null, panelCitas, null);
			panelCitas.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 145, 568, 268);
			panelCitas.add(scrollPane);
			
			tableEmps = new JTable();
			scrollPane.setViewportView(tableEmps);
			tableModel = new EmpresasTableModel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int filas, int columnas){
					return false;
				}
			};
			tableEmps.setModel(tableModel);

			JLabel lblNewLabel_1 = new JLabel("Empleos Mejor Pagados");
			lblNewLabel_1.setIcon(new ImageIcon(Reportes.class.getResource("/images/empresa/Calendario 64px.png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
			lblNewLabel_1.setBounds(0, 11, 511, 70);
			panelCitas.add(lblNewLabel_1);
		}

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Mayores Ofertantes", null, panel1, null);
		
		mejorPagados();
	}


}
