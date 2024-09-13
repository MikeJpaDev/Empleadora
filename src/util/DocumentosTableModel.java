package util;

import javax.swing.table.DefaultTableModel;

public class DocumentosTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	public DocumentosTableModel(){
		String[] columnNames = {"No","Nombre"};
		this.setColumnIdentifiers(columnNames);
	}
	public void adicionar(String no, String nombre){
		Object[] newRow = new Object[]{no, nombre};
		addRow(newRow);
	}
	
	
}
