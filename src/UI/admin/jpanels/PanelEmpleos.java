package UI.admin.jpanels;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import UI.admin.jdialog.CrearCita;
import UI.admin.jdialog.CrearEmpleoPtllaEmp;
import componentesVisuales.BotonAnimacion;
import util.EmpleoTableModel;
import util.EmpresasTableModel;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import logica.Empleadora;
import logica.empleo.Empleo;
import logica.empresa.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;

public class PanelEmpleos extends JPanel {
	private JTextField txtBuscar;
	private static JTable tableEmps;
	private static EmpleoTableModel tableModel;
	private static int cont = 1;
	private BotonAnimacion btnAdd;
	private BotonAnimacion btnDel;
	private boolean okBusc = false;
	private boolean clickBusc = false;
	private BotonAnimacion btnRecargar;
	private BotonAnimacion btnmcnAadirCita;

	public PanelEmpleos(){
		InicializarComponentes();
	}

	private static void limpiarJTable(){
		int a = tableModel.getRowCount()-1;
		cont = 1;
		for(int i=a;i>=0;i--){ 
			tableModel.removeRow(i);
		}
	}

	public static void actTabla(){
		limpiarJTable();
		Object[] datos = new Object[6];
		for(Empresa emps: Empleadora.getInstancia().getEmpresas()){
			for (Empleo p: emps.getEmpleos()){
				datos[0] = cont++;
				datos[1] = p.getID();
				datos[2] = p.getRama();
				datos[3] = "$" + p.getSalario();
				datos[4] = p.getEmpOfertante().getNombre();
				datos[5] = p.getRamaEmp();
				tableModel.addRow(datos);
			}
		}
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
	
	private void busTabla(){
		limpiarJTable();
		if(Empleadora.getInstancia().buscarEmpleo(txtBuscar.getText()).size() != 0){
			for (int i = 0; i < Empleadora.getInstancia().buscarEmpleo(txtBuscar.getText()).size(); i++){
				Object[] datos = new Object[6];
				datos = (Object[]) Empleadora.getInstancia().buscarEmpleo(txtBuscar.getText()).get(i);
				tableModel.addRow(datos);
			}
		}
	}

	private void InicializarComponentes() {
		setBackground(new Color(135, 206, 235));
		setSize(new Dimension(884, 580));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 23, 884, 70);
		add(panel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/images/empresa/curriculum 64px.png")));
		label.setBounds(783, 0, 75, 70);
		panel.add(label);

		JLabel lblListaDeEmpleos = new JLabel("Lista de Empleos");
		lblListaDeEmpleos.setFont(new Font("Roboto Black", Font.BOLD, 25));
		lblListaDeEmpleos.setBounds(568, 11, 227, 48);
		panel.add(lblListaDeEmpleos);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/images/empresa/logo redondo 64.png")));
		label_1.setBounds(32, 0, 86, 70);
		panel.add(label_1);

		JLabel label_2 = new JLabel("SIGEM");
		label_2.setFont(new Font("Roboto Black", Font.BOLD, 24));
		label_2.setBounds(110, 11, 112, 48);
		panel.add(label_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(34, 157, 644, 384);
		add(scrollPane);

		tableEmps = new JTable();
		tableEmps.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableEmps.setGridColor(new Color(192, 192, 192));
		tableEmps.setBorder(null);
		scrollPane.setViewportView(tableEmps);

		tableModel = new EmpleoTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableEmps.setModel(tableModel);

		btnAdd = new BotonAnimacion();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEmpleoPtllaEmp ptlla = new CrearEmpleoPtllaEmp();
				ptlla.setVisible(true);
			}
		});
		btnAdd.setFocusPainted(false);
		btnAdd.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnAdd.setText("A\u00F1adir");
		btnAdd.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAdd.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAdd.setBounds(688, 177, 134, 42);
		add(btnAdd);

		btnDel = new BotonAnimacion();
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableEmps.getSelectedRow() != -1){
					Empleadora.getInstancia().elimEmpleo(tableEmps.getValueAt(tableEmps.getSelectedRow(), 1).toString());
					actTabla();
					PanelPrincipal.actualizarContadores();
				}
			}
		});
		btnDel.setFocusPainted(false);
		btnDel.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		btnDel.setText("Borrar");
		btnDel.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDel.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDel.setBounds(688, 231, 134, 42);
		add(btnDel);

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
		txtBuscar.setText("Introduce el Nombre");
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		txtBuscar.setFont(new Font("Arial", Font.ITALIC, 22));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtBuscar.setBounds(34, 104, 644, 42);
		add(txtBuscar);
		
		BotonAnimacion btnBuscar = new BotonAnimacion();
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBuscar.getText().trim().length() != 0 && okBusc){
					busTabla();
					btnRecargar.setVisible(true);
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		btnBuscar.setText("Buscar");
		btnBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBounds(688, 104, 134, 42);
		add(btnBuscar);
		
		btnRecargar = new BotonAnimacion();
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actTabla();
				btnRecargar.setVisible(false);
			}
		});
		btnRecargar.setVisible(false);
		btnRecargar.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-actualizar-24.png")));
		btnRecargar.setText("Recargar");
		btnRecargar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnRecargar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnRecargar.setFocusPainted(false);
		btnRecargar.setBounds(688, 424, 134, 42);
		add(btnRecargar);
		
		btnmcnAadirCita = new BotonAnimacion();
		btnmcnAadirCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelect = tableEmps.getSelectedRow();
				if(filaSelect != -1){
					
					Empleo empl = null;
					
					for (Empresa emp: Empleadora.getInstancia().getEmpresas()){
						if(emp.getNombre().equalsIgnoreCase(tableEmps.getValueAt(filaSelect, 4).toString())){
							for(Empleo empleo : emp.getEmpleos()){
								if (empleo.getID().equals(tableEmps.getValueAt(filaSelect, 1).toString())){
									empl = empleo;
								}
							}
						}
					}
					
					CrearCita cita = new CrearCita(empl);
					cita.setVisible(true);
					
				}
			}
		});
		btnmcnAadirCita.setIcon(new ImageIcon(PanelEmpleos.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		btnmcnAadirCita.setText("Crear Cita");
		btnmcnAadirCita.setHorizontalTextPosition(SwingConstants.LEFT);
		btnmcnAadirCita.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnmcnAadirCita.setFocusPainted(false);
		btnmcnAadirCita.setBounds(688, 284, 134, 42);
		add(btnmcnAadirCita);
	}
}
