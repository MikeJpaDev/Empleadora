package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import util.EmpleoTableModel;
import util.EmpresasTableModel;
import util.LongevosTableModel;
import util.MasCitasTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reportes extends JDialog {

	private static EmpresasTableModel tableModelEmpresas;
	private static EmpleoTableModel tableModelEmp;
	private static LongevosTableModel tableModelL;
	private static MasCitasTableModel tableModelC;
	private JTable tableEmps;
	private JTable tableLongevos;
	private JTable tableOfertantes;
	static int cont = 1;

	static Object[] datos = new Object[6];
	private JTable tableCitas;

	private static void limpiarJTable(DefaultTableModel table){
		int a = table.getRowCount()-1;
		cont = 1;
		for(int i=a;i>=0;i--){
			table.removeRow(i);
		}
	}
	
	public static void actTablaMayOfertantes(ArrayList<Empresa> empresas){
		limpiarJTable(tableModelEmpresas);
		for(Empresa emps: empresas){
			
			datos[0] = cont++;
			datos[1] = emps.getNombre();
			datos[2] = emps.getDireccion();
			datos[3] = emps.getTelefeno();
			datos[4] = emps.getSector();
			datos[5] = emps.getTamArray();
			
			tableModelEmpresas.addRow(datos);
		}
	}

	public static void actTablaMejPagados(ArrayList<Empleo> empleos){
		limpiarJTable(tableModelEmp);
		for(Empleo p: empleos){
			datos[0] = cont++;
			datos[1] = p.getID();
			datos[2] = p.getRama();
			datos[3] = "$" + p.getSalario();
			datos[4] = p.getEmpOfertante().getNombre();
			datos[5] = p.getRamaEmp();
			tableModelEmp.addRow(datos);
		}
	}

	public Reportes() {
		setTitle("Reportes");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reportes.class.getResource("/images/empresa/curriculum 64px.png")));
		setBounds(100, 100, 681, 531);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 467, 675, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				BotonAnimacion btnmcnAceptar = new BotonAnimacion();
				btnmcnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnmcnAceptar.setText("Aceptar");
				buttonPane.add(btnmcnAceptar);
			}
		}

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tabbedPane.setBackground(new Color(0, 255, 255));
		tabbedPane.setBounds(0, 0, 675, 467);
		getContentPane().add(tabbedPane);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Candidatos Mas Longevos", null, panelInfo, null);
		panelInfo.setLayout(null);

		JLabel lblNewLabel = new JLabel("Candidatos m\u00E1s Longevos");
		lblNewLabel.setBackground(new Color(0, 204, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Reportes.class.getResource("/images/empresa/Usuarios 64px.png")));
		lblNewLabel.setBounds(0, 11, 670, 73);
		panelInfo.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 124, 531, 302);
		panelInfo.add(scrollPane_1);

		tableLongevos = new JTable();
		scrollPane_1.setViewportView(tableLongevos);
		tableModelEmpresas = new EmpresasTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Candidatos Con Mas Citas", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblCandidatosConMas = new JLabel("Candidatos con mas citas");
		lblCandidatosConMas.setIcon(new ImageIcon(Reportes.class.getResource("/images/empresa/Usuarios 64px.png")));
		lblCandidatosConMas.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblCandidatosConMas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandidatosConMas.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
		lblCandidatosConMas.setBackground(new Color(0, 204, 255));
		lblCandidatosConMas.setBounds(0, 11, 670, 73);
		panel.add(lblCandidatosConMas);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(21, 124, 622, 302);
		panel.add(scrollPane_3);
		
		tableCitas = new JTable();
		tableModelC = new MasCitasTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableCitas.setModel(tableModelC);
		scrollPane_3.setViewportView(tableCitas);

		JPanel panelMayoresOfertantes = new JPanel();
		panelMayoresOfertantes.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Mayores Ofertantes", null, panelMayoresOfertantes, null);
		panelMayoresOfertantes.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 90, 650, 270);
		panelMayoresOfertantes.add(scrollPane_2);

		tableOfertantes = new JTable();
		scrollPane_2.setViewportView(tableOfertantes);

		tableOfertantes.setModel(tableModelEmpresas);

		JLabel lblMayoresOfertantes = new JLabel("Mayores Ofertantes");
		lblMayoresOfertantes.setIcon(new ImageIcon(Reportes.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		lblMayoresOfertantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayoresOfertantes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 23));
		lblMayoresOfertantes.setBounds(10, 11, 650, 70);
		panelMayoresOfertantes.add(lblMayoresOfertantes);

		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actTablaMayOfertantes(Empleadora.mayoresOfertantes());
			}
		});
		botonAnimacion.setIcon(new ImageIcon(Reportes.class.getResource("/icons/empresa/Buscar 24px.png")));
		botonAnimacion.setText("Buscar");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setFocusPainted(false);
		botonAnimacion.setBounds(268, 371, 134, 42);
		panelMayoresOfertantes.add(botonAnimacion);
		{
			JPanel panelCitas = new JPanel();
			panelCitas.setBackground(new Color(135, 206, 235));
			tabbedPane.addTab("Empleos Mejor Pagados", null, panelCitas, null);
			panelCitas.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 145, 650, 228);
			panelCitas.add(scrollPane);

			tableEmps = new JTable();
			scrollPane.setViewportView(tableEmps);
			
			tableModelEmp = new EmpleoTableModel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int filas, int columnas){
					return false;
				}
			};
			tableEmps.setModel(tableModelEmp);

			JLabel lblNewLabel_1 = new JLabel("Empleos Mejor Pagados");
			lblNewLabel_1.setIcon(new ImageIcon(Reportes.class.getResource("/images/empresa/Calendario 64px.png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
			lblNewLabel_1.setBounds(0, 11, 670, 70);
			panelCitas.add(lblNewLabel_1);
			
			BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
			botonAnimacion_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actTablaMejPagados(Empleadora.mejoresPagados());
				}
			});
			botonAnimacion_1.setIcon(new ImageIcon(Reportes.class.getResource("/icons/empresa/Buscar 24px.png")));
			botonAnimacion_1.setText("Buscar");
			botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
			botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
			botonAnimacion_1.setFocusPainted(false);
			botonAnimacion_1.setBounds(268, 384, 134, 42);
			panelCitas.add(botonAnimacion_1);
		}
		tableModelL = new LongevosTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableLongevos.setModel(tableModelL);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Reportes.class.getResource("/icons/empresa/flecha A 60px.png")));
		lblNewLabel_2.setBounds(572, 307, 72, 59);
		panelInfo.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto Black", Font.BOLD, 26));
		lblNewLabel_3.setBounds(585, 174, 46, 45);
		panelInfo.add(lblNewLabel_3);

		JLabel lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Roboto Black", Font.BOLD, 26));
		lblD.setBounds(585, 204, 46, 45);
		panelInfo.add(lblD);

		JLabel lblA = new JLabel("A");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Roboto Black", Font.BOLD, 26));
		lblA.setBounds(585, 234, 46, 45);
		panelInfo.add(lblA);

		JLabel lblD_1 = new JLabel("D");
		lblD_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblD_1.setFont(new Font("Roboto Black", Font.BOLD, 26));
		lblD_1.setBounds(585, 264, 46, 45);
		panelInfo.add(lblD_1);
		
		masLong();
		masCitas();
	}

	private void masCitas(){
		Object datos[] = new Object[4];
		int num = 1;
		ArrayList<Candidato> citas = Empleadora.getInstancia().candidatosMasCitas();

		if(!citas.isEmpty())
			for(Candidato c : citas){
				datos[0] = num++;
				datos[1] = c.getCi();
				datos[2] = c.getNombre();
				datos[3] = c.getCitas().size();

				tableModelC.addRow(datos);
			}
	}
	
	private void masLong(){
		Object datos[] = new Object[4];
		int num = 1;
		ArrayList<Candidato> longev = Empleadora.getInstancia().candidatosMasLongevos();

		if(!longev.isEmpty())
			for(Candidato c : longev){
				datos[0] = num++;
				datos[1] = c.getCi();
				datos[2] = c.getNombre();
				datos[3] = c.getEdad();

				tableModelL.addRow(datos);
			}
	}
}
