package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javafx.scene.control.TableColumn;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Insets;

import javax.swing.ButtonGroup;

import UI.admin.jpanels.PanelPrincipal;
import UI.admin.jpanels.PanelUsuarios;
import componentesVisuales.JTextFieldModificado;

import java.awt.Dimension;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import sun.security.jca.GetInstance;
import util.DocumentosTableModel;
import util.EmpresasTableModel;
import logica.Empleadora;
import logica.candidato.Candidato;
import logica.enums.NivelEscolar;
import logica.enums.Rama;
import logica.enums.Sector;
import componentesVisuales.BotonAnimacion;
import logica.enums.Genero;
import logica.utilidades.logica.Sexo;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.SpinnerNumberModel;

public class CrearUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDir;
	private boolean clickDir = false;
	private JComboBox cmbNvEscolar;
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JSpinner spnExp;
	private JTable tableDocs;
	private JTextField txtEspecialidad;
	private DocumentosTableModel tableModel;
	private JComboBox<String> cmbDocs;
	private JComboBox cmbRama;
	private String nombre;
	private String ci;
	private Genero sexo;
	private String telef;
	
	private void clicBorrar(JTextField jtext, boolean click){
		if(click){
			jtext.setFont(new Font("Arial", Font.ITALIC, 13));
		}
		else{
			jtext.setText("");
			jtext.setFont(new Font("Arial", Font.BOLD, 13));
		}
	}
	
	
	private void llenarCmbDocs(String ramaSelect){
		ArrayList<String> docNecesarios = null;
		
		cmbDocs.removeAllItems();
		
		if(ramaSelect.equalsIgnoreCase(Rama.SEGURIDAD.toString())){
			docNecesarios = Rama.getDocSeguridad();
		}
		else if(ramaSelect.equalsIgnoreCase(Rama.DOCTOR.toString())){
			docNecesarios = Rama.getDocSalud();
		}
		
		
		if(!(docNecesarios == null))
			for(String s: docNecesarios){
				cmbDocs.addItem(s);
			}
		cmbDocs.addItem("Otros Documentos");
		
	}

	public CrearUsuario(String nombre, String ci, Genero sexo, String telef) {
		this.nombre = nombre;
		this.ci = ci;
		this.sexo = sexo;
		this.telef = telef;
		iniciarComponentes();
		llenarCmbDocs(cmbRama.getSelectedItem().toString());
	}
	
	
	private void iniciarComponentes(){
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("Crear usuario");
		setBounds(100, 100, 465, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 191, 255));
			panel.setBounds(0, 0, 459, 42);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblCrearUsuario = new JLabel("Crear Usuario");
				lblCrearUsuario.setIcon(new ImageIcon(CrearUsuario.class.getResource("/images/empresa/Usuarios 38px.png")));
				lblCrearUsuario.setHorizontalAlignment(SwingConstants.CENTER);
				lblCrearUsuario.setFont(new Font("Roboto Black", Font.BOLD, 20));
				lblCrearUsuario.setBounds(10, 0, 439, 42);
				panel.add(lblCrearUsuario);
			}
		}
		{
			JLabel lblDireccin = new JLabel("Direcci\u00F3n");
			lblDireccin.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblDireccin.setBounds(10, 53, 80, 26);
			contentPanel.add(lblDireccin);
		}
		{
			txtDir = new JTextField();
			txtDir.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(!clickDir){
						clicBorrar(txtDir,clickDir);
						clickDir = true;
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtDir.getText().isEmpty()){
						clicBorrar(txtDir,clickDir);
						txtDir.setText("Direcci\u00F3n");
						clickDir = false;
					}
				}
			});
			txtDir.setText("Direcci\u00F3n");
			txtDir.setFont(new Font("Arial", Font.ITALIC, 13));
			txtDir.setColumns(10);
			txtDir.setBorder(new EmptyBorder(0, 5, 0, 5));
			txtDir.setBounds(100, 53, 349, 26);
			contentPanel.add(txtDir);
		}
		{
			JLabel lblNivelDeEscolaridad = new JLabel("Nivel de Escolaridad");
			lblNivelDeEscolaridad.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblNivelDeEscolaridad.setBounds(10, 90, 155, 26);
			contentPanel.add(lblNivelDeEscolaridad);
		}
		{
			JLabel lblEspecialidad = new JLabel("Especialidad");
			lblEspecialidad.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblEspecialidad.setBounds(10, 130, 118, 26);
			contentPanel.add(lblEspecialidad);
		}
		{
			JLabel lblRama = new JLabel("Rama");
			lblRama.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblRama.setBounds(10, 170, 80, 26);
			contentPanel.add(lblRama);
		}
		{
			JLabel lblAosDeExperiencia = new JLabel("A\u00F1os de Experiencia");
			lblAosDeExperiencia.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
			lblAosDeExperiencia.setBounds(10, 210, 136, 26);
			contentPanel.add(lblAosDeExperiencia);
		}

		cmbNvEscolar = new JComboBox();
		cmbNvEscolar.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbNvEscolar.setModel(new DefaultComboBoxModel(NivelEscolar.values()));
		cmbNvEscolar.setBounds(171, 90, 278, 26);
		contentPanel.add(cmbNvEscolar);

		cmbRama = new JComboBox();
		cmbRama.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmbRama.getSelectedIndex() != -1){
					llenarCmbDocs(cmbRama.getSelectedItem().toString());
				}
			}
		});
		cmbRama.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbRama.setModel(new DefaultComboBoxModel(Rama.values()));
		cmbRama.setBounds(100, 170, 249, 26);
		contentPanel.add(cmbRama);

		spnExp = new JSpinner();
		spnExp.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExp.setBounds(156, 210, 84, 26);
		contentPanel.add(spnExp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 343, 415, 73);
		contentPanel.add(scrollPane);
		
		tableDocs = new JTable();
		scrollPane.setViewportView(tableDocs);
		
		JLabel lblDoc = new JLabel("Documentos Necesarios");
		lblDoc.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		lblDoc.setBounds(10, 254, 166, 26);
		contentPanel.add(lblDoc);
		
		BotonAnimacion btnmcnAadir = new BotonAnimacion();
		btnmcnAadir.setText("A\u00F1adir");
		btnmcnAadir.setFocusPainted(false);
		btnmcnAadir.setBounds(81, 298, 84, 34);
		contentPanel.add(btnmcnAadir);
		
		BotonAnimacion btnmcnBorrar = new BotonAnimacion();
		btnmcnBorrar.setText("Borrar");
		btnmcnBorrar.setFocusPainted(false);
		btnmcnBorrar.setBounds(276, 298, 84, 34);
		contentPanel.add(btnmcnBorrar);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setText("Especialidad");
		txtEspecialidad.setFont(new Font("Arial", Font.ITALIC, 13));
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtEspecialidad.setBounds(100, 130, 349, 26);
		contentPanel.add(txtEspecialidad);
		
		tableModel = new DocumentosTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableDocs.setModel(tableModel);
		TableColumnModel columnModel1 = tableDocs.getColumnModel();
		columnModel1.getColumn(0).setMaxWidth(50);
		
		
		cmbDocs = new JComboBox();
		cmbDocs.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbDocs.setBounds(186, 254, 249, 26);
		contentPanel.add(cmbDocs);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 191, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnmcnCrear = new BotonAnimacion();
			btnmcnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						Empleadora emp = Empleadora.getInstancia();
						Candidato cand = new Candidato(nombre,txtDir.getText() , telef, ci, (int)spnExp.getValue() ,sexo, (NivelEscolar)cmbNvEscolar.getSelectedItem(), (Rama)cmbRama.getSelectedItem(), txtEspecialidad.getText());
						emp.agCandidato(cand);
						Empleadora.getInstancia().citasDisponibles(cand);
						PanelUsuarios.llenarTabla();
						PanelPrincipal.actualizarContadores();
						setVisible(false);
						try {
							VerCitasXUsuario dialog = new VerCitasXUsuario(cand);
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setLocationRelativeTo(null);
							dialog.cambiarVentanaInicial(1);
							dialog.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						dispose();
					}
					catch(IllegalArgumentException e1){
						JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			btnmcnCrear.setFocusPainted(false);
			btnmcnCrear.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnmcnCrear.setText("Crear");
			buttonPane.add(btnmcnCrear);
			
			btnCancel = new BotonAnimacion();
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					dispose();
				}
			});
			btnCancel.setFocusPainted(false);
			btnCancel.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
			btnCancel.setText("Atras");
			buttonPane.add(btnCancel);
		}
	}
}
