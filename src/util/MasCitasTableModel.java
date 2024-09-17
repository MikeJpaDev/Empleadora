package util;

import javax.swing.table.DefaultTableModel;

public class MasCitasTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public MasCitasTableModel(){
		String[] columnNames = {"No","CI","Nombre","No citas"};
		this.setColumnIdentifiers(columnNames);
	}
}
