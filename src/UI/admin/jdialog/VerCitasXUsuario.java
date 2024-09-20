package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import componentesVisuales.BotonAnimacion;

import javax.swing.JLabel;

import java.awt.Font;

import componentesVisuales.JTextFieldModificado;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import logica.Empleadora;
import logica.candidato.Candidato;
import logica.candidato.CandidatoEspecifico;
import logica.candidato.Documento;
import logica.cita.Cita;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.CitasTableModel;
import util.DocumentosTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;

public class VerCitasXUsuario extends JDialog {

	private Candidato candidato;
	private JTextFieldModificado txtNombre;
	private JTextFieldModificado txtDir;
	private JTextFieldModificado txtTel;
	private JTextFieldModificado txtCi;
	private JTextFieldModificado txtGen;
	private JTextFieldModificado txtExp;
	private JTextFieldModificado txtNiv;
	private JTextFieldModificado txtEsp;
	private JTable tableCitas;
	private static CitasTableModel tableModel;
	private JTabbedPane tbdPane;
	private JTextFieldModificado txtRama;
	private JTable tableDocs;
	private static DocumentosTableModel tableModelD;



	private void llenarCampos(){
		txtNombre.setText(candidato.getNombre());
		txtDir.setText(candidato.getDir());
		txtTel.setText(candidato.getTelef());
		txtCi.setText(candidato.getCi());
		txtGen.setText(candidato.getGenero().name());
		txtExp.setText(String.valueOf(candidato.getAniosExp()));
		txtNiv.setText(candidato.getNivelEscolar().name());
		txtEsp.setText(candidato.getEspecialidad());
		txtRama.setText(candidato.getRama().toString());
	}

	public VerCitasXUsuario(Candidato cand) {
		this.candidato = cand;
		setTitle("Candidato");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerCitasXUsuario.class.getResource("/images/empresa/curriculum 64px.png")));
		setBounds(100, 100, 522, 575);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 499, 516, 47);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				BotonAnimacion btnmcnAceptar = new BotonAnimacion();
				btnmcnAceptar.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/icons/empresa/aceptar 24px.png")));
				btnmcnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnmcnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnmcnAceptar.setText("Aceptar");
				buttonPane.add(btnmcnAceptar);
			}
		}

		tbdPane = new JTabbedPane(JTabbedPane.TOP);
		tbdPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tbdPane.setBackground(new Color(0, 255, 255));
		tbdPane.setBounds(0, 0, 516, 499);
		getContentPane().add(tbdPane);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(new Color(135, 206, 235));
		tbdPane.addTab("Información", null, panelInfo, null);
		panelInfo.setLayout(null);

		JLabel label = new JLabel("Nombre: ");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(38, 110, 73, 26);
		panelInfo.add(label);

		txtNombre = new JTextFieldModificado();
		txtNombre.setText("Introduce el Nombre");
		txtNombre.setFont(new Font("Arial", Font.ITALIC, 13));
		txtNombre.setEnabled(false);
		txtNombre.setDisabledTextColor(Color.BLACK);
		txtNombre.setBorder(null);
		txtNombre.setBeepActivado(false);
		txtNombre.setBounds(121, 109, 349, 26);
		panelInfo.add(txtNombre);

		JLabel label_1 = new JLabel("Direcci\u00F3n: ");
		label_1.setFont(new Font("Arial", Font.PLAIN, 18));
		label_1.setBounds(38, 147, 92, 26);
		panelInfo.add(label_1);

		txtDir = new JTextFieldModificado();
		txtDir.setText("Introduce la Direcci\u00F3n");
		txtDir.setFont(new Font("Arial", Font.ITALIC, 13));
		txtDir.setEnabled(false);
		txtDir.setDisabledTextColor(Color.BLACK);
		txtDir.setBorder(null);
		txtDir.setBeepActivado(false);
		txtDir.setBounds(121, 146, 349, 26);
		panelInfo.add(txtDir);

		JLabel label_2 = new JLabel("Tel\u00E9fono: ");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(38, 184, 92, 26);
		panelInfo.add(label_2);

		txtTel = new JTextFieldModificado();
		txtTel.setTipoValidacion(2);
		txtTel.setText("Introduce el Tel\u00E9fono");
		txtTel.setLimite(8);
		txtTel.setFont(new Font("Arial", Font.ITALIC, 13));
		txtTel.setEnabled(false);
		txtTel.setDisabledTextColor(Color.BLACK);
		txtTel.setBorder(null);
		txtTel.setBeepActivado(false);
		txtTel.setBounds(121, 184, 349, 26);
		panelInfo.add(txtTel);

		JLabel lblCarnet = new JLabel("Carnet:");
		lblCarnet.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCarnet.setBounds(38, 259, 73, 26);
		panelInfo.add(lblCarnet);

		txtCi = new JTextFieldModificado();
		txtCi.setText("Introduce el Nombre");
		txtCi.setFont(new Font("Arial", Font.ITALIC, 13));
		txtCi.setEnabled(false);
		txtCi.setDisabledTextColor(Color.BLACK);
		txtCi.setBorder(null);
		txtCi.setBeepActivado(false);
		txtCi.setBounds(121, 258, 349, 26);
		panelInfo.add(txtCi);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGenero.setBounds(38, 296, 92, 26);
		panelInfo.add(lblGenero);

		txtGen = new JTextFieldModificado();
		txtGen.setText("Introduce la Direcci\u00F3n");
		txtGen.setFont(new Font("Arial", Font.ITALIC, 13));
		txtGen.setEnabled(false);
		txtGen.setDisabledTextColor(Color.BLACK);
		txtGen.setBorder(null);
		txtGen.setBeepActivado(false);
		txtGen.setBounds(121, 295, 349, 26);
		panelInfo.add(txtGen);

		JLabel lblAiosDeExperiencia = new JLabel("A\u00F1os de experiencia: ");
		lblAiosDeExperiencia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAiosDeExperiencia.setBounds(38, 333, 180, 26);
		panelInfo.add(lblAiosDeExperiencia);

		txtExp = new JTextFieldModificado();
		txtExp.setTipoValidacion(2);
		txtExp.setText("Introduce el Tel\u00E9fono");
		txtExp.setLimite(8);
		txtExp.setFont(new Font("Arial", Font.ITALIC, 13));
		txtExp.setEnabled(false);
		txtExp.setDisabledTextColor(Color.BLACK);
		txtExp.setBorder(null);
		txtExp.setBeepActivado(false);
		txtExp.setBounds(228, 332, 136, 26);
		panelInfo.add(txtExp);

		JLabel lblNivelEscolar = new JLabel("Nivel Escolar:");
		lblNivelEscolar.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNivelEscolar.setBounds(38, 370, 119, 26);
		panelInfo.add(lblNivelEscolar);

		txtNiv = new JTextFieldModificado();
		txtNiv.setTipoValidacion(2);
		txtNiv.setText((String) null);
		txtNiv.setLimite(8);
		txtNiv.setFont(new Font("Arial", Font.ITALIC, 13));
		txtNiv.setEnabled(false);
		txtNiv.setDisabledTextColor(Color.BLACK);
		txtNiv.setBorder(null);
		txtNiv.setBeepActivado(false);
		txtNiv.setBounds(178, 370, 292, 26);
		panelInfo.add(txtNiv);

		JLabel lblNewLabel = new JLabel("Empleado");
		lblNewLabel.setBackground(new Color(0, 204, 255));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/images/empresa/Usuarios 64px.png")));
		lblNewLabel.setBounds(0, 11, 511, 73);
		panelInfo.add(lblNewLabel);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEspecialidad.setBounds(38, 221, 119, 26);
		panelInfo.add(lblEspecialidad);

		txtEsp = new JTextFieldModificado();
		txtEsp.setTipoValidacion(2);
		txtEsp.setText((String) null);
		txtEsp.setLimite(8);
		txtEsp.setFont(new Font("Arial", Font.ITALIC, 13));
		txtEsp.setEnabled(false);
		txtEsp.setDisabledTextColor(Color.BLACK);
		txtEsp.setBorder(null);
		txtEsp.setBeepActivado(false);
		txtEsp.setBounds(178, 221, 292, 26);
		panelInfo.add(txtEsp);

		JLabel lblRama = new JLabel("Rama: ");
		lblRama.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRama.setBounds(38, 407, 119, 26);
		panelInfo.add(lblRama);

		txtRama = new JTextFieldModificado();
		txtRama.setTipoValidacion(2);
		txtRama.setText((String) null);
		txtRama.setLimite(8);
		txtRama.setFont(new Font("Arial", Font.ITALIC, 13));
		txtRama.setEnabled(false);
		txtRama.setDisabledTextColor(Color.BLACK);
		txtRama.setBorder(null);
		txtRama.setBeepActivado(false);
		txtRama.setBounds(178, 407, 292, 26);
		panelInfo.add(txtRama);

		JPanel panelDoc = new JPanel();
		tbdPane.addTab("Documentos", null, panelDoc, null);
		panelDoc.setBackground(new Color(135, 206, 235));
		panelDoc.setLayout(null);

		JLabel label_3 = new JLabel("Documento");
		label_3.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/images/empresa/Documetnto 50px.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Roboto Black", Font.BOLD, 20));
		label_3.setBounds(0, 11, 511, 55);
		panelDoc.add(label_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 118, 350, 327);
		panelDoc.add(scrollPane_1);

		tableDocs = new JTable();
		tableModelD = new DocumentosTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int filas, int columnas){
				return false;
			}
		};
		tableDocs.setModel(tableModelD);
		scrollPane_1.setViewportView(tableDocs);

		BotonAnimacion btnmcnVer = new BotonAnimacion();
		btnmcnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableDocs.getSelectedRow() != -1){
					try{
						AnadirDocs dialog = new AnadirDocs(false, "");
						int index = tableDocs.getSelectedRow();
						dialog.verDoc(((CandidatoEspecifico)candidato).getDocumentos().get(index));
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnmcnVer.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/icons/empresa/binoculars-solid-36.png")));
		btnmcnVer.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnmcnVer.setText("Ver");
		btnmcnVer.setBounds(390, 138, 109, 41);
		panelDoc.add(btnmcnVer);

		BotonAnimacion btnmcnEditar = new BotonAnimacion();
		btnmcnEditar.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/icons/empresa/edit-alt-solid-36.png")));
		btnmcnEditar.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		btnmcnEditar.setText("Editar");
		btnmcnEditar.setBounds(390, 207, 111, 41);
		panelDoc.add(btnmcnEditar);
		{
			JPanel panelCitas = new JPanel();
			panelCitas.setBackground(new Color(135, 206, 235));
			tbdPane.addTab("Citas", null, panelCitas, null);
			panelCitas.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 145, 346, 281);
			panelCitas.add(scrollPane);

			tableCitas = new JTable();
			scrollPane.setViewportView(tableCitas);
			tableModel = new CitasTableModel(){
				private static final long serialVersionUID = 1L;
				@Override
				public boolean isCellEditable(int filas, int columnas){
					return false;
				}
			};
			tableCitas.setModel(tableModel);

			JLabel lblNewLabel_1 = new JLabel("Citas");
			lblNewLabel_1.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/images/empresa/Calendario 64px.png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 23));
			lblNewLabel_1.setBounds(0, 11, 511, 70);
			panelCitas.add(lblNewLabel_1);

			BotonAnimacion btnmcnBuscar = new BotonAnimacion();
			btnmcnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cantActual = tableCitas.getRowCount();
					Empleadora.getInstancia().citasDisponibles(candidato);
					if(cantActual != candidato.getCitas().size()){
						llenarTabla();
					}
					else
						JOptionPane.showMessageDialog(null, "No hay Citas Disponibles", "No hay nuevas citas", 2);
				}
			});
			btnmcnBuscar.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 13));
			btnmcnBuscar.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/icons/empresa/search-alt-2-regular-36.png")));
			btnmcnBuscar.setText("Buscar");
			btnmcnBuscar.setBounds(366, 243, 118, 41);
			panelCitas.add(btnmcnBuscar);

			BotonAnimacion btnmcnEliminar = new BotonAnimacion();
			btnmcnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tableCitas.getSelectedRow() != -1)
						eliminarCita(tableCitas.getSelectedRow());
				}
			});
			btnmcnEliminar.setIcon(new ImageIcon(VerCitasXUsuario.class.getResource("/icons/empresa/icons8-papelera-50.png")));
			btnmcnEliminar.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 13));
			btnmcnEliminar.setText("Eliminar");
			btnmcnEliminar.setBounds(366, 295, 118, 41);
			panelCitas.add(btnmcnEliminar);
		}

		llenarCampos();
		llenarTabla();
		if(candidato instanceof CandidatoEspecifico)
			llenarTablaDoc();
		else
			tbdPane.removeTabAt(1);
	}



	//Limpiar Tabla Citas

	private void limpiarTabla(){
		int cantFil = tableModel.getRowCount()-1;
		for(int i=cantFil ; i>=0 ; i--){ 
			tableModel.removeRow(i);
		}
	}

	//Limpiar Tabla Documentos

	private void limpiarTablaDocs(){
		int cantFil = tableModelD.getRowCount()-1;
		for(int i=cantFil ; i>=0 ; i--){ 
			tableModelD.removeRow(i);
		}
	}

	//Llenar Tabla Citas

	public void llenarTabla(){

		limpiarTabla();
		Object datos[] = new Object[5];
		int num = 1;
		String fechaFormateada = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		if(!(candidato.getCitas().isEmpty()))
			for(Cita c : candidato.getCitas()){
				fechaFormateada = c.getFecha().format(formato);
				datos[0] = num++;
				datos[1] = fechaFormateada;
				datos[2] = c.getEmpleo().getID();
				datos[3] = c.getEmpleo().getRamaEmp();
				datos[4] = c.getCandidatos().size();
				tableModel.addRow(datos);
			}
	}

	//Llenar Tabla Documentos
	public void llenarTablaDoc(){
		limpiarTablaDocs();
		Object datos[] = new Object[2];
		int num = 1;

		for(Documento d : ((CandidatoEspecifico)candidato).getDocumentos()){
			datos[0] = num++;
			datos[1] = d.getNombre();
			tableModelD.addRow(datos);
		}
	}


	//Eliminar una Cita
	private void eliminarCita(int index){
		Empleadora.getInstancia().eliminarCandidaroCita(candidato.getCitas().get(index), candidato);
		llenarTabla();
	}

	//Cambiar Ventana Inicial

	public void cambiarVentanaInicial(int index){
		tbdPane.setSelectedIndex(index);
	}


}
