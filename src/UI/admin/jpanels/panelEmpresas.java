package UI.admin.jpanels;

//import javafx.scene.control.ComboBox;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.JButton;



import util.EmpresasTableModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
//import javax.swing.border.LineBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

//import org.omg.CORBA.PUBLIC_MEMBER;



import UI.admin.jdialog.CrearEmpleo;
import UI.admin.jdialog.CrearEmpresa;
import UI.admin.jdialog.EditarEmpresa;
//import UI.admin.jdialog.VerEmpresa;

//import java.awt.Component;

import componentesVisuales.BotonAnimacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Empleadora;
import logica.empresa.Empresa;
//import logica.enums.Sector;



import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
//import java.util.ArrayList;

public class panelEmpresas extends JPanel {
	private static JTable tableEmps;
	private static EmpresasTableModel tableModel;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	private static int cont = 1;
	private boolean clickBusc = false;
	private boolean okBusc = false;

	public panelEmpresas() {
		componentes();
	}

	//Enlazar esta funcion a La Clase Gestora
	private void verDatos(){
		int filaSelct = tableEmps.getSelectedRow();

		if(filaSelct != -1){
			Empleadora.getInstancia().verEmpresa(filaSelct);
		}
	}

	//Enlazar esta funcion a La Clase Gestora
	private void obtDatos(){
		int filaSelct = tableEmps.getSelectedRow();

		if(filaSelct != -1){
			Empleadora.getInstancia().editarDatos(filaSelct);
		}
	}

	private static void limpiarJTable(){
		int a = tableModel.getRowCount()-1;
		cont = 1;
		for(int i=a;i>=0;i--){ 
			tableModel.removeRow(i);
		}
	}
	
	public static void actEmpleos(Empresa emp){
		int filaSelct = tableEmps.getSelectedRow();
		tableModel.setValueAt(emp.getTamArray(), filaSelct, 5);
		actTabla();
	}

	//Enlazar esta funcion a La Clase Gestora
	public static void actTabla(){
		limpiarJTable();
		Object[] datos = new Object[6];
		for(Empresa emps: Empleadora.getInstancia().getEmpresas()){
			datos[0] = cont++;
			datos[1] = emps.getNombre();
			datos[2] = emps.getDireccion();
			datos[3] = emps.getTelefeno();
			datos[4] = emps.getSector();
			datos[5] = emps.getTamArray();
			tableModel.addRow(datos);
		}
	}

	//Enlazar esta funcion a La Clase Gestora
	private void busTabla(){
		limpiarJTable();
		if(Empleadora.getInstancia().buscarEmpresa(txtBuscar.getText()).size() != 0){
			for (int i = 0; i < Empleadora.getInstancia().buscarEmpresa(txtBuscar.getText()).size(); i++){
				Object[] datos = new Object[6];
				datos = (Object[]) Empleadora.getInstancia().buscarEmpresa(txtBuscar.getText()).get(i);
				tableModel.addRow(datos);
			}
		}
	}

	//Enlazar esta funcion a La Clase Gestora
	private void eliminarEmp(){
		int index = tableEmps.getSelectedRow();
		Empleadora.getInstancia().elimEmpresa(index);
		actTabla();
	}

	private void clicBorrar(JTextField jtext, boolean click){
		if(click){
			jtext.setFont(new Font("Arial", Font.ITALIC, 13));
		}
		else{
			jtext.setText("");
			jtext.setFont(new Font("Arial", Font.BOLD, 13));
		}
	}

	private void componentes(){
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(36, 186, 644, 358);
		add(scrollPane);

		tableEmps = new JTable();
		tableEmps.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableEmps.setGridColor(new Color(192, 192, 192));
		tableEmps.setBorder(null);
		scrollPane.setViewportView(tableEmps);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(panelEmpresas.class.getResource("/images/empresa/Empresa 64px.png")));
		label.setBounds(775, 0, 75, 70);
		panel.add(label);

		JLabel lblListaDeEmplesas = new JLabel("Lista de Empresas Empleadoras");
		lblListaDeEmplesas.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblListaDeEmplesas.setBounds(373, 11, 409, 48);
		panel.add(lblListaDeEmplesas);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(panelEmpresas.class.getResource("/images/empresa/logo redondo 64.png")));
		lblNewLabel.setBounds(32, 0, 86, 70);
		panel.add(lblNewLabel);

		JLabel lblSigem = new JLabel("SIGEM");
		lblSigem.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblSigem.setBounds(110, 11, 112, 48);
		panel.add(lblSigem);

		tableModel = new EmpresasTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableEmps.setModel(tableModel);

		txtBuscar = new JTextField();
		txtBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickBusc){
					clicBorrar(txtBuscar,clickBusc);
					clickBusc = true;
					txtBuscar.setFont(new Font("Arial", Font.ITALIC, 22));
					okBusc = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtBuscar.getText().isEmpty()){
					clicBorrar(txtBuscar,clickBusc);
					txtBuscar.setText("Introduce el Nombre");
					txtBuscar.setFont(new Font("Arial", Font.ITALIC, 22));
					clickBusc = false;
					okBusc = false;
				}
			}
		});
		txtBuscar.setForeground(new Color(192, 192, 192));
		txtBuscar.setText("Introduce el Nombre");
		txtBuscar.setFont(new Font("Arial", Font.ITALIC, 22));
		txtBuscar.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtBuscar.setBounds(36, 122, 644, 42);
		add(txtBuscar);
		txtBuscar.setColumns(10);

		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBuscar.getText().trim().length() != 0 && okBusc){
					busTabla();
				}
			}
		});
		botonAnimacion.setFocusPainted(false);
		botonAnimacion.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		botonAnimacion.setText("Buscar");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setBounds(715, 122, 134, 42);
		add(botonAnimacion);

		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verDatos();
			}
		});
		botonAnimacion_1.setFocusPainted(false);
		botonAnimacion_1.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion_1.setText("Ver");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(715, 197, 134, 42);
		add(botonAnimacion_1);

		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CrearEmpresa dialog = new CrearEmpresa();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		botonAnimacion_2.setFocusPainted(false);
		botonAnimacion_2.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_2.setText("A\u00F1adir");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(715, 263, 134, 42);
		add(botonAnimacion_2);

		BotonAnimacion botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setEnabled(false);
		botonAnimacion_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtDatos();
			}
		});
		botonAnimacion_3.setFocusPainted(false);
		botonAnimacion_3.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		botonAnimacion_3.setText("Editar");
		botonAnimacion_3.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_3.setBounds(715, 334, 134, 42);
		add(botonAnimacion_3);

		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.setFocusPainted(false);
		botonAnimacion_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableEmps.getSelectedRow() != -1){
					eliminarEmp();
				}
			}
		});
		botonAnimacion_4.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(715, 406, 134, 42);
		add(botonAnimacion_4);

		BotonAnimacion btnCrearEmpleo = new BotonAnimacion();
		btnCrearEmpleo.setFocusPainted(false);
		btnCrearEmpleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableEmps.getSelectedRow() != -1){
					CrearEmpleo empleo = new CrearEmpleo(Empleadora.getInstancia().getEmpresas().get(tableEmps.getSelectedRow()));
					empleo.setVisible(true);
				}
			}
		});
		btnCrearEmpleo.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnCrearEmpleo.setText("Empleo");
		btnCrearEmpleo.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCrearEmpleo.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCrearEmpleo.setBounds(715, 479, 134, 42);
		add(btnCrearEmpleo);
	}
}
