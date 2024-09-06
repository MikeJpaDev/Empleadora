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
import logica.enums.Sector;
import componentesVisuales.BotonAnimacion;

import javax.swing.SwingConstants;







import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearEmpleo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextFieldModificado txtNom;
	private JTextFieldModificado txtSal;
	private BotonAnimacion btnCancelar;
	private JTextFieldModificado txtSect;
	private boolean clickSal = false;
	private boolean okSal = false;
	
	private boolean clickEmp = false;
	private boolean okEmp = false;
	private JTextFieldModificado txtEmp;
	
	
	

	public CrearEmpleo(Empresa emp) {
		iniciarComponetes(emp);
		txtNom.setText(emp.getNombre());
		txtSect.setText(emp.getSector());		
	}
	
	private void agEmpleo(Empresa emp){
		emp.agEmpleo("Emp", emp.getSector(), Double.parseDouble(txtSal.getText()), emp.getNombre());
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

	private void iniciarComponetes(final Empresa emp){
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Ver Empresa");
		setBounds(100, 100, 465, 424);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(CrearEmpleo.class.getResource("/icons/icons8-bank-building-80.png")));
			lblNewLabel.setBounds(196, 11, 82, 69);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Empleadora: ");
			lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
			lblNombre.setBounds(10, 132, 111, 26);
			contentPanel.add(lblNombre);
		}
		
		JLabel lblEmpleo = new JLabel("Empleo:");
		lblEmpleo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmpleo.setBounds(10, 95, 111, 26);
		contentPanel.add(lblEmpleo);
		
		txtEmp = new JTextFieldModificado();
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
		txtEmp.setBorder(null);
		txtEmp.setBeepActivado(false);
		txtEmp.setBounds(131, 94, 311, 26);
		contentPanel.add(txtEmp);
		
		txtSect = new JTextFieldModificado();
		txtSect.setTipoValidacion(2);
		txtSect.setLimite(8);
		txtSect.setFont(new Font("Arial", Font.ITALIC, 13));
		txtSect.setEnabled(false);
		txtSect.setDisabledTextColor(Color.BLACK);
		txtSect.setBorder(null);
		txtSect.setBeepActivado(false);
		txtSect.setBounds(131, 206, 311, 26);
		contentPanel.add(txtSect);

		txtNom = new JTextFieldModificado();
		txtNom.setDisabledTextColor(Color.BLACK);
		txtNom.setEnabled(false);
		txtNom.setBeepActivado(false);
		txtNom.setFont(new Font("Arial", Font.ITALIC, 13));
		txtNom.setText("Introduce el Nombre");
		txtNom.setBorder(null);
		txtNom.setBounds(131, 131, 311, 26);
		contentPanel.add(txtNom);
		{
			JLabel lblDireccin = new JLabel("Salario: ");
			lblDireccin.setFont(new Font("Arial", Font.PLAIN, 18));
			lblDireccin.setBounds(10, 169, 92, 26);
			contentPanel.add(lblDireccin);
		}

		txtSal = new JTextFieldModificado();
		txtSal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(!clickSal){
					clicBorrar(txtSal,clickSal);
					clickSal = true;
					okSal = true;
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSal.getText().isEmpty()){
					clicBorrar(txtSal,clickSal);
					txtSal.setText("Introduce el Salario");
					clickSal = false;
					okSal = false;
				}
			}
		});
		txtSal.setDisabledTextColor(Color.BLACK);
		txtSal.setBeepActivado(false);
		txtSal.setFont(new Font("Arial", Font.ITALIC, 13));
		txtSal.setText("Introduce el Salario");
		txtSal.setBorder(null);
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
					if(okEmp && okSal){
						agEmpleo(emp);
						panelEmpresas.actEmpleos(emp);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Verifique los Datos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnmcnCrear.setIcon(new ImageIcon(CrearEmpleo.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnmcnCrear.setText("Crear");
			btnmcnCrear.setFocusTraversalKeysEnabled(false);
			btnmcnCrear.setFocusPainted(false);
			btnmcnCrear.setBorderPainted(false);
			buttonPane.add(btnmcnCrear);
			btnCancelar.setIcon(new ImageIcon(CrearEmpleo.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnCancelar.setText("Cancelar");
			btnCancelar.setBorderPainted(false);
			buttonPane.add(btnCancelar);


			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
				}
			});
		}
	}
}
