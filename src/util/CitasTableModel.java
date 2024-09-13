package util;

import javax.swing.table.DefaultTableModel;

public class CitasTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public CitasTableModel(){
		String[] columNames = {"No","Dia","Nombre","Rama","Cant Candidatos"};
		this.setColumnIdentifiers(columNames);
	}
}
