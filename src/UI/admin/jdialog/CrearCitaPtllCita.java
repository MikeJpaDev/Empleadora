package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentesVisuales.BotonAnimacion;

import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import logica.Empleadora;
import logica.cita.Cita;
import logica.empleo.Empleo;
import logica.empresa.Empresa;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCitaPtllCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<Empresa> empresas;
	private JComboBox<String> cmbEmpresa;
	private JComboBox<String> cmbEmpleo;
	private JCalendar calendar;

	public CrearCitaPtllCita(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
		setTitle("Crear Cita");
		setBounds(100, 100, 465, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblEmpresa.setBounds(10, 23, 109, 25);
		contentPanel.add(lblEmpresa);
		
		JLabel lblEmpleo = new JLabel("Empleo:");
		lblEmpleo.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblEmpleo.setBounds(10, 78, 109, 25);
		contentPanel.add(lblEmpleo);
		
		cmbEmpresa = new JComboBox();
		cmbEmpresa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = cmbEmpresa.getSelectedIndex();
				llenarCmbEmpleos(index);
			}
		});
		cmbEmpresa.setBounds(107, 23, 257, 25);
		contentPanel.add(cmbEmpresa);
		
		cmbEmpleo = new JComboBox();
		cmbEmpleo.setBounds(91, 78, 273, 25);
		contentPanel.add(cmbEmpleo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblFecha.setBounds(10, 144, 86, 25);
		contentPanel.add(lblFecha);
		
		calendar = new JCalendar();
		calendar.setBounds(107, 144, 239, 181);
		contentPanel.add(calendar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			BotonAnimacion btnmcnAceptar = new BotonAnimacion();
			btnmcnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						int dia = calendar.getDayChooser().getDay();
						int mes = calendar.getMonthChooser().getMonth() + 1;
						int anio = calendar.getYearChooser().getYear();
						
						LocalDate fecha = LocalDate.of(anio, mes, dia);
						
						Cita cita = new Cita(obtenerEmpleo(), fecha);
						
						Empleadora.getInstancia().getCitas().add(cita);
					}
					catch(IllegalArgumentException e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			});
			btnmcnAceptar.setFont(new Font("Roboto", Font.PLAIN, 15));
			btnmcnAceptar.setText("Aceptar");
			buttonPane.add(btnmcnAceptar);
			
			BotonAnimacion btnmcnCancelar = new BotonAnimacion();
			btnmcnCancelar.setFont(new Font("Roboto", Font.PLAIN, 15));
			btnmcnCancelar.setText("Cancelar");
			buttonPane.add(btnmcnCancelar);
		}
		llenarCmbEmpresas();
	}
	
	private void llenarCmbEmpresas(){
		for(Empresa c : empresas)
			cmbEmpresa.addItem(c.getNombre());
	}
	
	private void llenarCmbEmpleos(int index){
		cmbEmpleo.removeAllItems();
		for(Empleo e : empresas.get(index).getEmpleos())
			cmbEmpleo.addItem(e.toString());
	}
	
	private Empleo obtenerEmpleo(){
		int indexEmpleo = cmbEmpleo.getSelectedIndex();
		int indexEmpresa = cmbEmpresa.getSelectedIndex();
		
		return empresas.get(indexEmpresa).getEmpleos().get(indexEmpleo);
	}
}
