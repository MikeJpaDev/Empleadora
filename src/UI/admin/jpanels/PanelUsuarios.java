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
import UI.admin.jdialog.VerCitasXUsuario;
import util.UsersTableModel;
import logica.Empleadora;
import logica.algoritmos.Busqueda;
import logica.candidato.Candidato;
import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;
import componentesVisuales.BotonAnimacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelUsuarios extends JPanel {
	private JTextField txtBuscar;
	private JTable table;
	private boolean buscarClick = false;
	private static UsersTableModel tableModel;
	private static boolean busqueda = false;
	private ArrayList<Candidato> busquedas;

	public PanelUsuarios() {
		llenarComponentes();
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
		busqueda = false;
		for(Candidato c: Empleadora.getInstancia().getCandidatos()){
			datos[0] = c.getCi();
			datos[1] = c.getNombre();
			datos[2] = c.getGenero().name();
			datos[3] = c.getAniosExp();
			datos[4] = c.getNivelEscolar().name();
			datos[5] = c.getRama().name();
			tableModel.addRow(datos);
		}
	}

	//Llenar tabla busqueda

	private void llenarTablaBusq(){
		limpiarTabla();
		Object datos[] = new Object[6];
		busqueda = true;

		for(Candidato c: busquedas){
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
		Empleadora.getInstancia().getCandidatos().remove(index);
		llenarTabla();
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
		txtBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtBuscar.getText().equals("Nombre/CI") && !buscarClick) {
					txtBuscar.setText("");
					txtBuscar.setForeground(Color.BLACK);
					buscarClick = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscar.getText().isEmpty()) {
					txtBuscar.setText("Nombre/CI");
					txtBuscar.setForeground(Color.GRAY);
					buscarClick = false;
				}
			}
		});
		txtBuscar.setText("Nombre/CI");
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(36, 119, 644, 42);
		add(txtBuscar);

		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!buscarClick || txtBuscar.getText().equalsIgnoreCase("")){
					llenarTabla();
					busquedas = null;
				}
				else{
					String buscar = txtBuscar.getText();
					busquedas = Empleadora.getInstancia().buscarCand(buscar);
					llenarTablaBusq();
				}
			}
		});
		botonAnimacion.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		botonAnimacion.setText("Buscar");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setBounds(697, 119, 134, 42);
		add(botonAnimacion);

		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					try {
						Candidato cand = null;
						int select = 0;
						select = table.getSelectedRow();

						if(!busqueda)					
							cand = Empleadora.getInstancia().getCandidatos().get(select);
						else
							cand = busquedas.get(select);

						VerCitasXUsuario dialog = new VerCitasXUsuario(cand);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		botonAnimacion_1.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion_1.setText("Ver");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(697, 194, 134, 42);
		add(botonAnimacion_1);

		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCandidato();
			}
		});
		botonAnimacion_2.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_2.setText("A\u00F1adir");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(697, 260, 134, 42);
		add(botonAnimacion_2);

		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1){
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION){
						
						Candidato cand = null;
						int select = 0;
						select = table.getSelectedRow();

						if(!busqueda){					
							cand = Empleadora.getInstancia().getCandidatos().get(select);
							Empleadora.getInstancia().getCandidatos().remove(select);
							llenarTabla();
						}
						else{
							cand = busquedas.get(select);
							Empleadora.getInstancia().getCandidatos().remove(cand);
							busquedas.remove(select);
							llenarTablaBusq();
						}
						
						
						PanelPrincipal.actualizarContadores();
					}
				}
			}
		});
		botonAnimacion_4.setIcon(new ImageIcon(PanelUsuarios.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(697, 319, 134, 42);
		add(botonAnimacion_4);
	}

	// Crear usuario

	private void crearCandidato(){
		try {
			buscarClick = false;
			CrearUsuarioNomb dialog = new CrearUsuarioNomb();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
