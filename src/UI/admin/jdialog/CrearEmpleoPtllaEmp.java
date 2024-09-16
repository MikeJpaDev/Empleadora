package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javafx.scene.control.ComboBox;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import UI.admin.pantallaAdmin;
import UI.admin.jpanels.PanelEmpleos;
import UI.admin.jpanels.PanelPrincipal;
import UI.admin.jpanels.panelEmpresas;
import componentesVisuales.CampoCIValidado;

import javax.swing.JLabel;

import componentesVisuales.AvatarCircular;

import javax.swing.ImageIcon;

import java.awt.Font;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import logica.Empleadora;
import logica.empleo.Empleo;
import logica.empresa.Empresa;
import logica.enums.Rama;
import logica.enums.Sector;
import componentesVisuales.BotonAnimacion;

import javax.swing.SwingConstants;
















import com.formdev.flatlaf.FlatLightLaf;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CrearEmpleoPtllaEmp extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextFieldModificado txtSal;
	private BotonAnimacion btnCancelar;
	private JTextFieldModificado txtSect;
	private boolean clickSal = false;
	private boolean okSal = false;

	private boolean clickEmp = false;
	private boolean okEmp = false;
	private JTextFieldModificado txtEmp;
	private JComboBox<Rama> cmbRamas;
	private JComboBox<String> cmbEmpleadoras;

	private void getEmpresasToCmb(JComboBox<String> cmb){
		for(Empresa emp:Empleadora.getInstancia().getEmpresas()){
			cmb.addItem(emp.getNombre());
		}
	}


	private void getRamas(Empresa emp, JComboBox<Rama> cmb){
		cmb.removeAllItems();
		ArrayList<Rama> ramas;

		if(emp.getSector().equalsIgnoreCase(Sector.EDUCACION.toString())){
			ramas = Rama.getRamasEducacion();
		}
		else if(emp.getSector().equalsIgnoreCase(Sector.SALUD.toString())){
			ramas = Rama.getRamasSalud();
		}
		else{
			ramas = Rama.getRamasTurPriv();
		}

		for (Rama r : ramas){
			cmbRamas.addItem(r);
		}
	}

	public CrearEmpleoPtllaEmp() {
		iniciarComponetes();
	}

	private Empleo agEmpleo(Empresa emp){
		Empleo empleo = new Empleo(txtEmp.getText(), emp.getSector(), Double.parseDouble(txtSal.getText()), emp, (Rama)cmbRamas.getSelectedItem());
		emp.getEmpleos().add(empleo);
		return empleo;
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

	private boolean verifPuntos(String txt){
		boolean retorno = true;
		int cont = 0;

		for(int i = 0; i < txt.length() && cont <= 1; i++){
			if (txt.charAt(i) == '.'){
				cont++;
			}
			if (cont > 1){
				retorno = false;
			}
		}

		return retorno;
	}

	private void iniciarComponetes(){
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Crear Empleo");
		setBounds(100, 100, 465, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(CrearEmpleoPtllaEmp.class.getResource("/icons/icons8-bank-building-80.png")));
			lblNewLabel.setBounds(196, 11, 82, 69);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Empresa: ");
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNombre.setBounds(10, 132, 111, 26);
			contentPanel.add(lblNombre);
		}

		JLabel lblEmpleo = new JLabel("Empleo:");
		lblEmpleo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmpleo.setBounds(10, 95, 111, 26);
		contentPanel.add(lblEmpleo);

		txtEmp = new JTextFieldModificado();
		txtEmp.setLimite(25);
		txtEmp.setValidacionPersonalizada("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ");
		txtEmp.setTipoValidacion(4);
		txtEmp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickEmp){
					clicBorrar(txtEmp,clickEmp);
					clickEmp = true;
					okEmp = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmp.getText().isEmpty()){
					clicBorrar(txtEmp,clickEmp);
					txtEmp.setText("Introduce el Nombre");
					clickEmp = false;
					okEmp = false;
				}
			}
		});
		txtEmp.setText("Introduce el Nombre");
		txtEmp.setFont(new Font("Arial", Font.ITALIC, 13));
		txtEmp.setDisabledTextColor(Color.BLACK);
		txtEmp.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtEmp.setBeepActivado(false);
		txtEmp.setBounds(131, 94, 311, 26);
		contentPanel.add(txtEmp);

		txtSect = new JTextFieldModificado();
		txtSect.setTipoValidacion(2);
		txtSect.setLimite(8);
		txtSect.setFont(new Font("Arial", Font.ITALIC, 13));
		txtSect.setEnabled(false);
		txtSect.setDisabledTextColor(Color.BLACK);
		txtSect.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtSect.setBeepActivado(false);
		txtSect.setBounds(131, 206, 311, 26);
		contentPanel.add(txtSect);
		{
			JLabel lblDireccin = new JLabel("Salario: ");
			lblDireccin.setFont(new Font("Arial", Font.PLAIN, 18));
			lblDireccin.setBounds(10, 169, 92, 26);
			contentPanel.add(lblDireccin);
		}

		txtSal = new JTextFieldModificado();
		txtSal.setLimite(9);
		txtSal.setValidacionPersonalizada("1234567890.");
		txtSal.setTipoValidacion(4);
		txtSal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickSal){
					txtSal.setForeground(null);
					clicBorrar(txtSal,clickSal);
					clickSal = true;
					okSal = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				boolean correcto = verifPuntos(txtSal.getText());
				if (txtSal.getText().isEmpty()){
					txtSal.setForeground(null);
					clicBorrar(txtSal,clickSal);
					txtSal.setText("Introduce el Salario");
					clickSal = false;
					okSal = false;
				}
				else if (txtSal.getText().charAt(0) == '0' || txtSal.getText().charAt(0) == '.' ||!correcto){
					clicBorrar(txtSal,clickSal);
					txtSal.setForeground(Color.red);
					txtSal.setText("Salario no válido");
					clickSal = false;
					okSal = false;
				}
			}
		});
		txtSal.setDisabledTextColor(Color.BLACK);
		txtSal.setBeepActivado(false);
		txtSal.setFont(new Font("Arial", Font.ITALIC, 13));
		txtSal.setText("Introduce el Salario");
		txtSal.setBorder(new EmptyBorder(0, 5, 0, 0));
		txtSal.setBounds(131, 168, 311, 26);
		contentPanel.add(txtSal);

		JLabel lblSector = new JLabel("Sector: ");
		lblSector.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSector.setBounds(10, 206, 92, 26);
		contentPanel.add(lblSector);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(135, 206, 235));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnCancelar = new BotonAnimacion();
			btnCancelar.setFocusPainted(false);
			btnCancelar.setFocusTraversalKeysEnabled(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			BotonAnimacion btnmcnCrear = new BotonAnimacion();
			btnmcnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(okEmp && okSal && cmbEmpleadoras.getSelectedIndex() != -1){
						try{
							Empleo empleo = agEmpleo(Empleadora.getInstancia().getEmpresas().get(cmbEmpleadoras.getSelectedIndex()));
							int respuesta = JOptionPane.showConfirmDialog(null, "Desea agendar una cita", "Confirmación", JOptionPane.YES_NO_OPTION);
							if (respuesta == JOptionPane.YES_OPTION){
								CrearCita cita = new CrearCita(empleo);
								cita.setVisible(true);
							}

							PanelEmpleos.actTabla();
							PanelPrincipal.actualizarContadores();
							dispose();
						}
						catch(Exception e1){
							JOptionPane.showMessageDialog(rootPane, e1.getMessage());
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Verifique los Datos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnmcnCrear.setIcon(new ImageIcon(CrearEmpleoPtllaEmp.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnmcnCrear.setText("Crear");
			btnmcnCrear.setFocusTraversalKeysEnabled(false);
			btnmcnCrear.setFocusPainted(false);
			btnmcnCrear.setBorderPainted(false);
			buttonPane.add(btnmcnCrear);
			btnCancelar.setIcon(new ImageIcon(CrearEmpleoPtllaEmp.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnCancelar.setText("Cancelar");
			btnCancelar.setBorderPainted(false);
			buttonPane.add(btnCancelar);

			JLabel lblRama = new JLabel("Rama: ");
			lblRama.setFont(new Font("Arial", Font.PLAIN, 18));
			lblRama.setBounds(10, 243, 92, 26);
			contentPanel.add(lblRama);

			cmbRamas = new JComboBox<Rama>();
			cmbRamas.setBorder(null);
			cmbRamas.setBounds(131, 243, 311, 26);
			contentPanel.add(cmbRamas);
			cmbEmpleadoras = new JComboBox<String>();
			cmbEmpleadoras.setBorder(null);
			cmbEmpleadoras.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (cmbEmpleadoras.getSelectedIndex()!= -1){
						txtSect.setText(Empleadora.getInstancia().getEmpresas().get(cmbEmpleadoras.getSelectedIndex()).getSector());
						getRamas(Empleadora.getInstancia().getEmpresas().get(cmbEmpleadoras.getSelectedIndex()), cmbRamas);
					}
				}
			});
			cmbEmpleadoras.setBounds(131, 132, 311, 26);
			contentPanel.add(cmbEmpleadoras);
			getEmpresasToCmb(cmbEmpleadoras);
			cmbEmpleadoras.setSelectedIndex(-1);
		}
	}
}
