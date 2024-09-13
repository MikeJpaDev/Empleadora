package util;

import javax.swing.table.DefaultTableModel;

public class UsersTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	public UsersTableModel(){
		String[] columnNames = {"CI", "Nombre", "Sexo", "Años de exp", "Nivel de Escolaridad", "Rama"};
		this.setColumnIdentifiers(columnNames);
	}
	public void adicionar(String ci, String nombre ,String sexo, String
			edad, String nivelEsc, String rama){
		Object[] newRow = new Object[]{ci, nombre , sexo, edad, nivelEsc, rama};
		addRow(newRow);
	}
}
