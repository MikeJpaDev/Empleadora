package util;

import javax.swing.table.DefaultTableModel;

public class EmpleoTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public EmpleoTableModel(){
		String[] columNames = {"N�", "ID", "Sector", "Salario", "Empleadora", "Rama"};
		this.setColumnIdentifiers(columNames);
	}
	
}
