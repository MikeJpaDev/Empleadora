package util;

import javax.swing.table.DefaultTableModel;

public class CandidatosEnCitasTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	public CandidatosEnCitasTableModel(){
		String[] columnNames = {"No","CI", "Nombre"};
		this.setColumnIdentifiers(columnNames);
	}
}
