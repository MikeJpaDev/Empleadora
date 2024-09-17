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

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import controlArchivos.BuscarArchivos;

import java.awt.SystemColor;
import java.io.File;
import java.util.ArrayList;

import logica.candidato.Documento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImportarDoc extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cmbNombre;
	private ArrayList<File> archivos;
	private Documento documento = null;

	public ImportarDoc(ArrayList<File> files) {
		archivos = files;
		setTitle("Importar Documento");
		setModal(true);
		setBounds(100, 100, 450, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del .txt :");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 81, 102, 14);
		contentPanel.add(lblNewLabel);
		
		cmbNombre = new JComboBox();
		cmbNombre.setBounds(117, 79, 291, 20);
		contentPanel.add(cmbNombre);
		
		JLabel lblSeleccioneElNombre = new JLabel("Seleccione el nombre del .txt que desee a\u00F1adir");
		lblSeleccioneElNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneElNombre.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblSeleccioneElNombre.setBounds(10, 11, 414, 20);
		contentPanel.add(lblSeleccioneElNombre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.textHighlight);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				BotonAnimacion btnmcnAceptar = new BotonAnimacion();
				btnmcnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							File file = archivos.get(cmbNombre.getSelectedIndex());
							String contenido = BuscarArchivos.getInstance().LeerArchivoTxt(file);
							documento = new Documento(file.getName(), contenido);
							dispose();
						}
						catch(IllegalArgumentException e1){
							JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnmcnAceptar.setText("Aceptar");
				buttonPane.add(btnmcnAceptar);
			}
			{
				BotonAnimacion btnmcnCancelar = new BotonAnimacion();
				btnmcnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnmcnCancelar.setText("Cancelar");
				buttonPane.add(btnmcnCancelar);
			}
		}
		llenarCmbBox();
	}
	
	private void llenarCmbBox(){
		for(File f : archivos)
			cmbNombre.addItem(f.getName());
	}
	
	public Documento anadirFile(){
		return documento; 
	}
}
