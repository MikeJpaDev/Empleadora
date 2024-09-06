package util;

import javax.swing.table.DefaultTableModel;

public class EmpleoTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public EmpleoTableModel(){
		String[] columNames = {"Nº", "ID", "Rama", "Salario", "Empleadora"};
		this.setColumnIdentifiers(columNames);
	}
	
}
