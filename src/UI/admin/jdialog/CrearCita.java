package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

import componentesVisuales.BotonAnimacion;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import componentesVisuales.JTextFieldModificado;

import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import logica.Empleadora;
import logica.candidato.Candidato;
import logica.cita.Cita;
import logica.empleo.Empleo;
import logica.enums.Genero;
import logica.utilidades.logica.Sexo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.demo.JCalendarDemo;

public class CrearCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JTextFieldModificado txtNombre;
	private JCalendar cldFecha;
	
	private void inicializarComponentes(final Empleo emp){

		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Crear Cita");
		setBounds(100, 100, 465, 331);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 459, 258);
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblEmpleo = new JLabel("Empleo:");
		lblEmpleo.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblEmpleo.setBounds(10, 53, 80, 26);
		contentPanel.add(lblEmpleo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblFecha.setBounds(38, 164, 52, 26);
		contentPanel.add(lblFecha);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 459, 42);
		contentPanel.add(panel);
		
		JLabel lblCrearCita = new JLabel("Crear Cita");
		lblCrearCita.setIcon(new ImageIcon(CrearCita.class.getResource("/icons/empresa/aceptar 24px.png")));
		lblCrearCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearCita.setFont(new Font("Roboto Black", Font.BOLD, 20));
		lblCrearCita.setBounds(10, 0, 439, 42);
		panel.add(lblCrearCita);
		
		txtNombre = new JTextFieldModificado();
		txtNombre.setDisabledTextColor(Color.BLACK);
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setEnabled(false);
		txtNombre.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtNombre.setBeepActivado(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNombre.setValidacionPersonalizada("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ \u00E1\u00E9\u00ED\u00F3\u00C1\u00C9\u00CD\u00D3 \u00F1");
		txtNombre.setTipoValidacion(4);
		txtNombre.setBounds(100, 53, 349, 23);
		contentPanel.add(txtNombre);
		
		cldFecha = new JCalendar();
		cldFecha.setBounds(100, 94, 184, 153);
		contentPanel.add(cldFecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setBounds(0, 257, 459, 45);
			getContentPane().add(buttonPane);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT, 5, 5);
			buttonPane.setLayout(fl_buttonPane);
			{
				btnmcnCrear = new BotonAnimacion();
				btnmcnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean ok = false;
						Date fecha = new Date();
						int diaL = fecha.getDay();
						int mesL = fecha.getMonth();
						int anioL = fecha.getYear();
						
						int diaS = cldFecha.getDayChooser().getDay();
						int mesS = cldFecha.getMonthChooser().getMonth();
						int anioS = cldFecha.getYearChooser().getYear();
						
						
						LocalDate local = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						Empleadora.getInstancia().agregarCita(emp, local);
						dispose();
												
					}
				});
				/*btnmcnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							Candidato.validarNombre(txtNombre.getText());
							Candidato.validarTelef(txtTel.getText());
							Candidato.validarCi(txtCi.getText());
							Empleadora.getInstancia().esNuevo(txtCi.getText());
							dispose();
							crearUser();
						}catch(IllegalArgumentException e1){
							JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});*/
				btnmcnCrear.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
				btnmcnCrear.setText("Aceptar");
				buttonPane.add(btnmcnCrear);
			}
			{
				btnCancel = new BotonAnimacion();
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setFocusPainted(false);
				btnCancel.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
				btnCancel.setText("Cancelar");
				buttonPane.add(btnCancel);
			}
		}
	
	}
	
	public CrearCita(Empleo nom) {
		inicializarComponentes(nom);
		txtNombre.setText(nom.getID());
	}
}
