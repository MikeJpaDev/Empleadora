package UI.admin.jpanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.CitasTableModel;
import util.EmpresasTableModel;
import componentesVisuales.BotonAnimacion;

import javax.swing.SwingConstants;

import logica.Empleadora;
import logica.cita.Cita;

public class PanelCitas extends JPanel {
	private JTable tableCitas;
	private static CitasTableModel tableModel;

	/*private void pruebas(){
		Cita a = new Cita(Empleadora.getInstancia().getEmpresas().get(0).getEmpleos().get(0), null, LocalDate.of(2024, 10, 1));
		Empleadora.getInstancia().getCitas().add(a);
	}*/
	
	
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
		Object datos[] = new Object[5];
		int num = 1;
		String fechaFormateada = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		if(!(Empleadora.getInstancia().getCitas().isEmpty()))
			for(Cita c : Empleadora.getInstancia().getCitas()){
				fechaFormateada = c.getFecha().format(formato);
				datos[0] = num++;
				datos[1] = fechaFormateada;
				datos[2] = c.getEmpleo().getID();
				datos[3] = c.getEmpleo().getRama();
				datos[4] = c.getCandidatos().size();
				tableModel.addRow(datos);
			}
	}


	//Eliminar un Candidato
	private void eliminarCita(int index){
		Empleadora.getInstancia().getCitas().remove(index);
		llenarTabla();
	}
	
	
	public PanelCitas() {
		//pruebas();
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
		
		
		llenarTabla();
	}
}
