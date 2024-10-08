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
import logica.candidato.CandidatoEspecifico;
import logica.candidato.Documento;
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

import com.jgoodies.looks.plastic.theme.DarkStar;

public class CrearUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDir;
	private JComboBox cmbNvEscolar;
	private BotonAnimacion btnmcnCrear;
	private BotonAnimacion btnCancel;
	private JSpinner spnExp;
	private JTable tableDocs;
	private JTextField txtEspecialidad;
	private static DocumentosTableModel tableModel;
	private JComboBox<String> cmbDocs;
	private JComboBox cmbRama;
	private String nombre;
	private String ci;
	private Genero sexo;
	private String telef;
	private static ArrayList<Documento> documentos;
	
	private boolean dirClick = false;
	private boolean espClick = false;

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
		documentos = new ArrayList<Documento>();
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
	                if (txtDir.getText().equals("Direcci�n") && !dirClick) {
	                	txtDir.setText("");
	                	txtDir.setForeground(Color.BLACK);
	                	dirClick = true;
	                }
				}
				@Override
				public void focusLost(FocusEvent e) {
	                if (txtDir.getText().isEmpty()) {
	                	txtDir.setText("Direcci�n");
	                	txtDir.setForeground(Color.GRAY);
	                    dirClick = false;
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

		cmbNvEscolar = new JComboBox<NivelEscolar>();
		cmbNvEscolar.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbNvEscolar.setModel(new DefaultComboBoxModel(NivelEscolar.values()));
		cmbNvEscolar.setBounds(171, 90, 278, 26);
		contentPanel.add(cmbNvEscolar);

		cmbRama = new JComboBox<Rama>();
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
		btnmcnAadir.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnmcnAadir.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/Importar 24pc.png")));
		btnmcnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean anadido = false;

				try {
					if(!documentos.isEmpty()){
						String nombre;
						for(int i = 0; i < documentos.size() && !anadido;i++){
							nombre = documentos.get(i).getNombre();
							if(((String)cmbDocs.getSelectedItem()).equalsIgnoreCase(nombre))
								anadido = true;
						}
						if(anadido)
							throw new IllegalArgumentException("No se puede Crear dos veces el mismo documento");
					}

					boolean editable = true;
					if(cmbDocs.getSelectedIndex() != cmbDocs.getItemCount()-1)
						editable = false;
					AnadirDocs dialog = new AnadirDocs(editable, (String)cmbDocs.getSelectedItem());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch(IllegalArgumentException e2){
					JOptionPane.showMessageDialog(null,e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnmcnAadir.setText("A\u00F1adir");
		btnmcnAadir.setFocusPainted(false);
		btnmcnAadir.setBounds(81, 298, 84, 34);
		contentPanel.add(btnmcnAadir);

		BotonAnimacion btnmcnBorrar = new BotonAnimacion();
		btnmcnBorrar.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnmcnBorrar.setIcon(new ImageIcon(CrearUsuario.class.getResource("/icons/empresa/borrar 24px.png")));
		btnmcnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableDocs.getSelectedRow() != -1){
					int respuesta = JOptionPane.showConfirmDialog(null, "�Esta seguro que desea Eliminar?", "Confirmaci�n", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION){
						eliminarDocumento(tableDocs.getSelectedRow());
						llenarTabla();
					}
				}
			}
		});
		btnmcnBorrar.setText("Borrar");
		btnmcnBorrar.setFocusPainted(false);
		btnmcnBorrar.setBounds(276, 298, 84, 34);
		contentPanel.add(btnmcnBorrar);

		txtEspecialidad = new JTextField();
		txtEspecialidad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                if (txtEspecialidad.getText().equals("Especialidad") && !espClick) {
                	txtEspecialidad.setText("");
                	txtEspecialidad.setForeground(Color.BLACK);
                	espClick = true;
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (txtEspecialidad.getText().isEmpty()) {
                	txtEspecialidad.setText("Especialidad");
                	txtEspecialidad.setForeground(Color.GRAY);
                    espClick = false;
                }
			}
		});
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
			btnmcnCrear.setFont(new Font("Roboto", Font.PLAIN, 15));
			btnmcnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(!dirClick || !espClick)
							throw new IllegalArgumentException("Hay campos vacios");
						
						Empleadora emp = Empleadora.getInstancia();
						Candidato cand;					
						todosDocs();					
						if(documentos.isEmpty())
							cand = new Candidato(nombre,txtDir.getText() , telef, ci, (int)spnExp.getValue() ,sexo, (NivelEscolar)cmbNvEscolar.getSelectedItem(),
									(Rama)cmbRama.getSelectedItem(), txtEspecialidad.getText());
						else
							cand = new CandidatoEspecifico(nombre,txtDir.getText() , telef, ci, (int)spnExp.getValue() ,sexo, (NivelEscolar)cmbNvEscolar.getSelectedItem(),documentos,
									(Rama)cmbRama.getSelectedItem(), txtEspecialidad.getText());	

						emp.agCandidato(cand);
						Empleadora.getInstancia().citasDisponibles(cand);
						PanelUsuarios.llenarTabla();
						PanelPrincipal.actualizarContadores();
						setVisible(false);
						try {
							VerCitasXUsuario dialog = new VerCitasXUsuario(cand);
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setLocationRelativeTo(null);
							int index = 1;
							
							if(cand instanceof CandidatoEspecifico)
								index = 2;
							
							dialog.cambiarVentanaInicial(index);
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
			btnCancel.setFont(new Font("Roboto", Font.PLAIN, 15));
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


	//agregar documentos
	public static void aggDocumento(Documento doc){
		documentos.add(doc);
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
		Object datos[] = new Object[2];
		int num = 1;

		for(Documento d : documentos){
			datos[0] = num++;
			datos[1] = d.getNombre();
			tableModel.addRow(datos);
		}
	}


	//Eliminar un Candidato
	private void eliminarDocumento(int index){
		documentos.remove(index);
		llenarTabla();
	}
	
	private void todosDocs(){
		int cantDocImp = cmbDocs.getItemCount() - 1;
		int cantParcial = 0;
		
		for(int i = 0; i < documentos.size() && cantDocImp!=cantParcial; i++){
			for(int j = 0; j < cantDocImp; j++)
				if(documentos.get(i).getNombre().equalsIgnoreCase(cmbDocs.getItemAt(j).toString()))
					cantParcial++;
		}
		
		if(cantDocImp != cantParcial)
			throw new IllegalArgumentException("Faltan Documentos Importantes Por Agregar");
	}
}
