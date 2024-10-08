package UI.admin.jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import componentesVisuales.BotonAnimacion;
import controlArchivos.BuscarArchivos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.candidato.Documento;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.ArrayList;

public class AnadirDocs extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextArea txaContenido;
	private boolean nombreClick = false;
	private BotonAnimacion btnOk;
	private BotonAnimacion btnCanc;
	private BotonAnimacion btnImport;
	
	
	public AnadirDocs(boolean editable, String nombreDoc) {
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearUsuario.class.getResource("/images/empresa/logo redondo 64.png")));
		setTitle("A�adir documento");
		setBounds(100, 100, 465, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 235));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                if (txtNombre.getText().equals("Nombre del Documento") && !nombreClick) {
                    txtNombre.setText("");
                    txtNombre.setForeground(Color.BLACK);
                    nombreClick = true;
                }
			}
			@Override
			public void focusLost(FocusEvent e) {
                if (txtNombre.getText().isEmpty()) {
                    txtNombre.setText("Nombre del Documento");
                    txtNombre.setForeground(Color.GRAY);
                    nombreClick = false;
                }
			}
		});
		txtNombre.setBorder(new EmptyBorder(0, 5, 0, 5));
		txtNombre.setBounds(107, 77, 337, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setEditable(editable);
		if(!editable)
			txtNombre.setText(nombreDoc);
		
		JLabel lblNewLabel = new JLabel("Nombre :");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 80, 87, 14);
		contentPanel.add(lblNewLabel);
		
		txaContenido = new JTextArea();
		txaContenido.setFont(new Font("Arial", Font.PLAIN, 12));
		txaContenido.setBounds(21, 146, 423, 236);
		contentPanel.add(txaContenido);
		
		JLabel lblNewLabel_1 = new JLabel("Contenido :");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 126, 423, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Documento");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(AnadirDocs.class.getResource("/images/empresa/Documetnto 50px.png")));
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 11, 434, 55);
		contentPanel.add(lblNewLabel_2);
		
		btnImport = new BotonAnimacion();
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				BuscarArchivos.getInstance().agregarCarpeta();
				ArrayList<File> archivos = BuscarArchivos.getInstance().buscadorTxt();
					ImportarDoc dialog = new ImportarDoc(archivos);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					Documento doc = dialog.anadirFile();
					if(doc != null){
						txtNombre.setText(doc.getNombre());
						txaContenido.setText(doc.getContenido());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnImport.setIcon(new ImageIcon(AnadirDocs.class.getResource("/icons/empresa/Importar 24pc.png")));
		btnImport.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnImport.setText("Importar");
		btnImport.setBounds(338, 402, 106, 32);
		contentPanel.add(btnImport);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(30, 144, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnOk = new BotonAnimacion();
			btnOk.setIcon(new ImageIcon(AnadirDocs.class.getResource("/icons/empresa/aceptar 24px.png")));
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						if(txtNombre.getText().equalsIgnoreCase("Otros Documentos"))
							throw new IllegalArgumentException("No se puede poner de nombre \"Otros Documentos\"");
						
						Documento doc = new Documento(txtNombre.getText(), txaContenido.getText());
						CrearUsuario.aggDocumento(doc);
						CrearUsuario.llenarTabla();
						dispose();
					}catch(IllegalArgumentException e1){
						JOptionPane.showMessageDialog(null,e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnOk.setFont(new Font("Roboto", Font.PLAIN, 14));
			btnOk.setText("A\u00F1adir");
			buttonPane.add(btnOk);
			
			btnCanc = new BotonAnimacion();
			btnCanc.setIcon(new ImageIcon(AnadirDocs.class.getResource("/icons/empresa/icons8-cancelar-24.png")));
			btnCanc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCanc.setFont(new Font("Roboto", Font.PLAIN, 14));
			btnCanc.setText("Cancelar");
			buttonPane.add(btnCanc);
		}
	}
	
	public void verDoc(Documento doc){
		txtNombre.setText(doc.getNombre());
		txaContenido.setText(doc.getContenido());
		txtNombre.setEditable(false);
		txaContenido.setEditable(false);
		btnOk.setVisible(false);
		btnCanc.setText("Salir");
		btnImport.setVisible(false);
		btnCanc.setIcon(new ImageIcon(AnadirDocs.class.getResource("/icons/empresa/Exit 24px.png")));
	}
}
