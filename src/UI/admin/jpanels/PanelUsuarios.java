package UI.admin.jpanels;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import UI.admin.jdialog.CrearEmpresa;
import UI.admin.jdialog.CrearUsuario;
import UI.admin.jdialog.CrearUsuarioNomb;
import util.UsersTableModel;
import logica.Empleadora;
import logica.candidato.Candidato;
import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;
import componentesVisuales.BotonAnimacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuarios extends JPanel {
	private JTextField txtBuscar;
	private JTable table;
	private static UsersTableModel tableModel;

	public PanelUsuarios() {
		llenarComponentes();
		prueba();
		llenarTabla();
	}
	
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
		Object datos[] = new Object[6];
		
		for(Candidato c: Empleadora.getInstancia().getUsuarios()){
			datos[0] = c.getCi();
			datos[1] = c.getNombre();
			datos[2] = c.getGenero().name();
			datos[3] = c.getAniosExp();
			datos[4] = c.getNivelEscolar().name();
			datos[5] = c.getRama().name();
			tableModel.addRow(datos);
		}
	}
	
	
	//Eliminar un Candidato
	private void eliminarCandidato(int index){
		Empleadora.getInstancia().getUsuarios().remove(index);
		llenarTabla();
	}
	
	private void prueba(){
		Candidato can = new Candidato("Juan Arturo", "Atocha", "76400063", "04010266989", 0, Genero.MASCULINO, NivelEscolar.UNIVERSITARIO,Rama.CHOFER,"asdasdasd");
		Empleadora.getInstancia().agCandidato(can);
		
		try{
			Candidato can2 = new Candidato("Carlos Arturo", "Atocha", "76400063", "02010266989", 0, Genero.MASCULINO, NivelEscolar.UNIVERSITARIO,Rama.ENFERMERA,"asdasdasd");
			Empleadora.getInstancia().agCandidato(can2);
		}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void llenarComponentes(){
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setMaximumSize(new Dimension(884, 580));
		setMinimumSize(new Dimension(884, 580));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/images/empresa/Usuarios 64px.png")));
		label.setBounds(778, 0, 75, 70);
		panel.add(label);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de Usuarios");
		lblListaDeUsuarios.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblListaDeUsuarios.setBounds(555, 11, 306, 48);
		panel.add(lblListaDeUsuarios);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/images/empresa/logo redondo 64.png")));
		label_1.setBounds(32, 0, 86, 70);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("SIGEM");
		label_2.setFont(new Font("Roboto Black", Font.BOLD, 24));
		label_2.setBounds(110, 11, 112, 48);
		panel.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(36, 183, 644, 358);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableModel = new UsersTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		table.setModel(tableModel);
		
		txtBuscar = new JTextField();
		txtBuscar.setText("Nombre/CI");
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(36, 119, 644, 42);
		add(txtBuscar);
		
		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		botonAnimacion.setText("Buscar");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setBounds(697, 119, 134, 42);
		add(botonAnimacion);
		
		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion_1.setText("Ver");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(697, 194, 134, 42);
		add(botonAnimacion_1);
		
		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CrearUsuarioNomb dialog = new CrearUsuarioNomb();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		botonAnimacion_2.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_2.setText("A\u00F1adir");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(697, 260, 134, 42);
		add(botonAnimacion_2);
		
		BotonAnimacion botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setEnabled(false);
		botonAnimacion_3.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		botonAnimacion_3.setText("Editar");
		botonAnimacion_3.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_3.setBounds(697, 331, 134, 42);
		add(botonAnimacion_3);
		
		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION)
						eliminarCandidato(table.getSelectedRow());
				}
			}
		});
		botonAnimacion_4.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(697, 403, 134, 42);
		add(botonAnimacion_4);
	}
}
