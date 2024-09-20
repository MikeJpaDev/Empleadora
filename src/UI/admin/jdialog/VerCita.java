package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentesVisuales.BotonAnimacion;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import logica.Empleadora;
import logica.candidato.Candidato;
import logica.cita.Cita;
import util.CandidatosEnCitasTableModel;
import util.UsersTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.awt.Toolkit;

public class VerCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableCand;
	private CandidatosEnCitasTableModel tableModel;
	private Cita citaPanel;
	private JLabel lblEmpresa;
	private JLabel lblEmpleo;
	private JLabel lblFecha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the dialog.
	 */
	
	
	//Limpiar Tabla 

	private void limpiarTabla(){
		int cantFil = tableModel.getRowCount()-1;
		for(int i=cantFil ; i>=0 ; i--){ 
			tableModel.removeRow(i);
		}
	}

	//Llenar Tabla

	public void llenarTabla(){
		limpiarTabla();
		Object datos[] = new Object[3];
		int num = 1;
		for(Candidato c: citaPanel.getCandidatos()){
			datos[0] = num++;
			datos[1] = c.getCi();
			datos[2] = c.getNombre();
			tableModel.addRow(datos);
		}
	}
	
	//Llenar Campos de texto
	
	private void llenarComponentes(Cita cita){
		this.citaPanel = cita;
		lblEmpleo.setText(cita.getEmpleo().getID());
		lblEmpresa.setText(cita.getEmpleo().getEmpOfertante().getNombre());
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		lblFecha.setText(cita.getFecha().format(formato));
	}
	
	public VerCita(Cita cita) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerCita.class.getResource("/images/empresa/logo redondo 64.png")));
		setModal(true);
		setResizable(false);
		setTitle("Candidatos Disponibles");
		setBounds(100, 100, 450, 509);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(135, 206, 235));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEm = new JLabel("Empresa: ");
			lblEm.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblEm.setBounds(10, 129, 109, 14);
			contentPanel.add(lblEm);
		}
		{
			JLabel lblCita = new JLabel(" Cita");
			lblCita.setIcon(new ImageIcon(VerCita.class.getResource("/images/empresa/Calendario 64px.png")));
			lblCita.setHorizontalTextPosition(SwingConstants.RIGHT);
			lblCita.setHorizontalAlignment(SwingConstants.CENTER);
			lblCita.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
			lblCita.setBackground(new Color(0, 204, 255));
			lblCita.setBounds(0, 11, 444, 73);
			contentPanel.add(lblCita);
		}
		{
			JLabel lblEmpl = new JLabel("Empleo: ");
			lblEmpl.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblEmpl.setBounds(10, 155, 109, 14);
			contentPanel.add(lblEmpl);
		}
		{
			lblEmpresa = new JLabel("Nombre Empreas");
			lblEmpresa.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblEmpresa.setBounds(90, 129, 322, 14);
			contentPanel.add(lblEmpresa);
		}
		{
			lblEmpleo = new JLabel("Nombre Empleo");
			lblEmpleo.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblEmpleo.setBounds(81, 155, 322, 14);
			contentPanel.add(lblEmpleo);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 192, 293, 229);
			contentPanel.add(scrollPane);
			{
				tableCand = new JTable();
				tableModel = new CandidatosEnCitasTableModel(){
					private static final long serialVersionUID = 1L;
					@Override
					public boolean isCellEditable(int filas, int columnas){
						return false;
					}
				};
				tableCand.setModel(tableModel);
				scrollPane.setViewportView(tableCand);
			}
		}
		
		BotonAnimacion btnBuscar = new BotonAnimacion();
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleadora.getInstancia().llenarCita(citaPanel);
				llenarTabla();
			}
		});
		btnBuscar.setIcon(new ImageIcon(VerCita.class.getResource("/icons/empresa/Buscar 24px.png")));
		btnBuscar.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnBuscar.setText("Buscar");
		btnBuscar.setBounds(313, 252, 109, 32);
		contentPanel.add(btnBuscar);
		
		BotonAnimacion btnEliminar = new BotonAnimacion();
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCand.getSelectedRow() != -1)
					eliminarCita(tableCand.getSelectedRow());
			}
		});
		btnEliminar.setIcon(new ImageIcon(VerCita.class.getResource("/icons/empresa/borrar 24px.png")));
		btnEliminar.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnEliminar.setText("Eliminar");
		btnEliminar.setBounds(313, 302, 109, 32);
		contentPanel.add(btnEliminar);
		
		BotonAnimacion btnver = new BotonAnimacion();
		btnver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCand.getSelectedRow() != -1){
					try {
						Candidato cand = null;
						int select = 0;
						select = tableCand.getSelectedRow();
			
							cand = Empleadora.getInstancia().getCandidatos().get(select);
							cand = citaPanel.getCandidatos().get(select);

						VerCitasXUsuario dialog = new VerCitasXUsuario(cand);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						llenarTabla();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnver.setIcon(new ImageIcon(VerCita.class.getResource("/icons/empresa/ver 24px.png")));
		btnver.setText("Ver");
		btnver.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnver.setBounds(313, 202, 109, 32);
		contentPanel.add(btnver);
		{
			JLabel lblFec = new JLabel("Fecha: ");
			lblFec.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblFec.setBounds(10, 104, 109, 14);
			contentPanel.add(lblFec);
		}
		{
			lblFecha = new JLabel((String) null);
			lblFecha.setFont(new Font("Roboto", Font.PLAIN, 17));
			lblFecha.setBounds(90, 104, 322, 14);
			contentPanel.add(lblFecha);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				BotonAnimacion btnmcnAceptar = new BotonAnimacion();
				btnmcnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnmcnAceptar.setIcon(new ImageIcon(VerCita.class.getResource("/icons/empresa/Exit 24px.png")));
				btnmcnAceptar.setFont(new Font("Roboto", Font.PLAIN, 15));
				btnmcnAceptar.setText("Salir");
				buttonPane.add(btnmcnAceptar);
			}
		}
		llenarComponentes(cita);
		llenarTabla();
	}
	
	//Eliminar una Cita
	private void eliminarCita(int index){
		Empleadora.getInstancia().eliminarCandidaroCita(citaPanel, citaPanel.getCandidatos().get(index));
		llenarTabla();
	}
}
