package UI.admin.jpanels;

import javafx.scene.control.ComboBox;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import util.EmpresasTableModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import org.omg.CORBA.PUBLIC_MEMBER;

import UI.admin.jdialog.CrearEmpresa;
import UI.admin.jdialog.EditarEmpresa;
import UI.admin.jdialog.VerEmpresa;

import java.awt.Component;

import componentesVisuales.BotonAnimacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Empleadora;
import logica.empresa.Empresa;
import logica.enums.Sector;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class panelEmpresas extends JPanel {
	private JTable tableEmps;
	private EmpresasTableModel tableModel;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	private int cont = 1;
	private boolean clickBusc = false;
	private boolean okBusc = false;

	public panelEmpresas() {
		componentes();
	}
	
	private void verDatos(){
		int filaSelct = tableEmps.getSelectedRow();

		if(filaSelct != -1){
			Empleadora emp = Empleadora.getInstancia();
			
			try {
				VerEmpresa dialog = new VerEmpresa(emp.getEmpresas().get(filaSelct));	
				dialog.setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void obtDatos(){
		int filaSelct = tableEmps.getSelectedRow();

		if(filaSelct != -1){
			Empleadora emp = Empleadora.getInstancia();
			
			try {
				EditarEmpresa dialog = new EditarEmpresa(emp.getEmpresas().get(filaSelct), filaSelct);	
				dialog.setVisible(true);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void limpiarJTable(){
		int a = tableModel.getRowCount()-1;
		this.cont = 1;
		for(int i=a;i>=0;i--){ 
			tableModel.removeRow(i);
		}
	}

	private void actTabla(){
		limpiarJTable();
		Empleadora emp = Empleadora.getInstancia();
		Object[] datos = new Object[6];
		for(Empresa emps: emp.getEmpresas()){
			datos[0] = cont++;
			datos[1] = emps.getNombre();
			datos[2] = emps.getDireccion();
			datos[3] = emps.getTelefeno();
			datos[4] = emps.getSector();
			datos[5] = 0;
			tableModel.addRow(datos);
		}
	}
	
	private void busTabla(String nom){
		limpiarJTable();
		Empleadora emp = Empleadora.getInstancia();
		Object[] datos = new Object[6];
		int cont = 0;
		for(Empresa emps: emp.getEmpresas()){
			if(emps.getNombre().equalsIgnoreCase(nom)){
				datos[0] = cont++;
				datos[1] = emps.getNombre();
				datos[2] = emps.getDireccion();
				datos[3] = emps.getTelefeno();
				datos[4] = emps.getSector();
				datos[5] = 0;
				tableModel.addRow(datos);
				cont++;
			}
		}
		
		if(cont == 0){
			JOptionPane.showMessageDialog(null, "No se han registrados Empresas bajo ese nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void eliminarEmp(Empresa emprD){
		Empleadora emp = Empleadora.getInstancia();
		emp.getEmpresas().remove(emprD);
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
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(36, 122, 644, 42);
		add(txtBuscar);
		txtBuscar.setColumns(10);

		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBuscar.getText().trim().length() != 0){
					busTabla(txtBuscar.getText());
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
				Empleadora emp = Empleadora.getInstancia();
				if(tableEmps.getSelectedRow() != -1){
					eliminarEmp(emp.getEmpresas().get(tableEmps.getSelectedRow()));
				}
			}
		});
		botonAnimacion_4.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(715, 406, 134, 42);
		add(botonAnimacion_4);

		BotonAnimacion btnmcnActualizar = new BotonAnimacion();
		btnmcnActualizar.setFocusPainted(false);
		btnmcnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actTabla();
			}
		});
		btnmcnActualizar.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-actualizar-24.png")));
		btnmcnActualizar.setText("Actualizar");
		btnmcnActualizar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnActualizar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnActualizar.setBounds(715, 479, 134, 42);
		add(btnmcnActualizar);
	}
}
