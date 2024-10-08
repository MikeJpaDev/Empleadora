package UI.admin.jpanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.CitasTableModel;
import util.EmpresasTableModel;
import UI.admin.jdialog.CrearCitaPtllCita;
import UI.admin.jdialog.VerCita;
import componentesVisuales.BotonAnimacion;

import javax.swing.SwingConstants;

import logica.Empleadora;
import logica.cita.Cita;
import logica.empresa.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCitas extends JPanel {
	private JTable tableCitas;
	private static CitasTableModel tableModel;

	/*private void pruebas(){
		Cita a = new Cita(Empleadora.getInstancia().getEmpresas().get(0).getEmpleos().get(0), null, LocalDate.of(2024, 10, 1));
		Empleadora.getInstancia().getCitas().add(a);
	}*/
	
	
	//Limpiar Tabla 

	private static void limpiarTabla(){
		int cantFil = tableModel.getRowCount()-1;
		for(int i=cantFil ; i>=0 ; i--){ 
			tableModel.removeRow(i);
		}
	}

	//Llenar Tabla

	public static void llenarTabla(){
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
				datos[3] = c.getEmpleo().getRamaEmp().toString();;
				datos[4] = c.getCandidatos().size();
				tableModel.addRow(datos);
			}
	}


	//Eliminar una cita
	private void eliminarCita(int index){
		Cita cita = Empleadora.getInstancia().getCitas().get(index);
		Empleadora.getInstancia().eliminarCita(cita);
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
		btnAñadirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						ArrayList<Empresa> ofertantes = Empleadora.getInstancia().empresasConEmpleos();
						if(ofertantes.isEmpty())
							throw new IllegalArgumentException("No hay empleos en el sistema");
						CrearCitaPtllCita dialog = new CrearCitaPtllCita(ofertantes);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}catch(IllegalArgumentException e2){
						JOptionPane.showMessageDialog(null,e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnAñadirCita.setIcon(new ImageIcon(PanelCitas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnAñadirCita.setText("A\u00F1adir");
		btnAñadirCita.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAñadirCita.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAñadirCita.setFocusPainted(false);
		btnAñadirCita.setBounds(690, 210, 134, 42);
		add(btnAñadirCita);
		
		BotonAnimacion btnBorrar = new BotonAnimacion();
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCitas.getSelectedRow() != -1){
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION){
						eliminarCita(tableCitas.getSelectedRow());
					}
				}
			}
		});
		btnBorrar.setIcon(new ImageIcon(PanelCitas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		btnBorrar.setText("Borrar");
		btnBorrar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBorrar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnBorrar.setFocusPainted(false);
		btnBorrar.setBounds(690, 275, 134, 42);
		add(btnBorrar);
		
		BotonAnimacion btnVer = new BotonAnimacion();
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCitas.getSelectedRow() != -1){
					try {
						VerCita dialog = new VerCita(Empleadora.getInstancia().getCitas().get(tableCitas.getSelectedRow()));
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnVer.setIcon(new ImageIcon(PanelCitas.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		btnVer.setText("Ver");
		btnVer.setHorizontalTextPosition(SwingConstants.LEFT);
		btnVer.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnVer.setFocusPainted(false);
		btnVer.setBounds(690, 144, 134, 42);
		add(btnVer);
		
		
		llenarTabla();
	}
}
