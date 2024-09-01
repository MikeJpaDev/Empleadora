package UI.admin.jpanels;

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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import org.omg.CORBA.PUBLIC_MEMBER;

import UI.admin.jdialog.CrearEmpresa;

import java.awt.Component;

import componentesVisuales.BotonAnimacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Empleadora;
import logica.empresa.Empresa;

public class panelEmpresas extends JPanel {
	private JTable tableEmps;
	private EmpresasTableModel tableModel;
	private JTextField textFieldBuscar;
	private JScrollPane scrollPane;
	private int cont = 1;
	
	public panelEmpresas() {
		componentes();
	}
	
	private void limpiarJTable(){
        int a = tableModel.getRowCount()-1;
        this.cont = 1;
        for(int i=a;i>=0;i--){ 
            tableModel.removeRow(i);
        }
    }
	
	//Mejorar
	private void actTabla(){
		limpiarJTable();
		Empleadora emp = Empleadora.getInstancia();
		Object[] datos = new Object[5];
		for(Empresa emps: emp.getEmpresas()){
			datos[0] = cont++;
			datos[1] = emps.getNombre();
			datos[2] = emps.getTelefeno();
			datos[3] = emps.getSector();
			datos[4] = 0;
			tableModel.addRow(datos);
		}
	}
	
	//Implementar
	private boolean eliminarEmp(Empresa emprD){
		boolean retorno = false;
		
		return retorno;
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
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setForeground(new Color(192, 192, 192));
		textFieldBuscar.setText("Nombre/IDs");
		textFieldBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldBuscar.setBorder(null);
		textFieldBuscar.setBounds(36, 122, 644, 42);
		add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		BotonAnimacion botonAnimacion = new BotonAnimacion();
		botonAnimacion.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
		botonAnimacion.setText("Buscar");
		botonAnimacion.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion.setBounds(715, 122, 134, 42);
		add(botonAnimacion);
		
		BotonAnimacion botonAnimacion_1 = new BotonAnimacion();
		botonAnimacion_1.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		botonAnimacion_1.setText("Ver");
		botonAnimacion_1.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_1.setBounds(715, 197, 134, 42);
		add(botonAnimacion_1);
		
		BotonAnimacion botonAnimacion_2 = new BotonAnimacion();
		botonAnimacion_2.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-a\u00F1adir-50.png")));
		botonAnimacion_2.setText("A\u00F1adir");
		botonAnimacion_2.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_2.setBounds(715, 263, 134, 42);
		add(botonAnimacion_2);
		
		BotonAnimacion botonAnimacion_3 = new BotonAnimacion();
		botonAnimacion_3.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		botonAnimacion_3.setText("Editar");
		botonAnimacion_3.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_3.setBounds(715, 334, 134, 42);
		add(botonAnimacion_3);
		
		BotonAnimacion botonAnimacion_4 = new BotonAnimacion();
		botonAnimacion_4.setIcon(new ImageIcon(panelEmpresas.class.getResource("/icons/empresa/icons8-papelera-50.png")));
		botonAnimacion_4.setText("Borrar");
		botonAnimacion_4.setHorizontalTextPosition(SwingConstants.LEFT);
		botonAnimacion_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		botonAnimacion_4.setBounds(715, 406, 134, 42);
		add(botonAnimacion_4);
		
		BotonAnimacion btnmcnActualizar = new BotonAnimacion();
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
