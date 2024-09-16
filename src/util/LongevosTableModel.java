package util;

import javax.swing.table.DefaultTableModel;

public class LongevosTableModel extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	
	public LongevosTableModel(){
		String[] columnNames = {"No","CI","Nombre","Edad"};
		this.setColumnIdentifiers(columnNames);
	}
}
