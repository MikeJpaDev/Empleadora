package util;

import javax.swing.table.DefaultTableModel;

public class EmpresasTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	public EmpresasTableModel(){
		String[] columnNames = {"IDs","Nombre", "Telefono", "Sector", "Total Empleos"};
		this.setColumnIdentifiers(columnNames);
	}
	public void adicionar(String ids, String nombre ,String telefono, String
			sector, String totalEmpleos){
		Object[] newRow = new Object[]{ids, nombre , telefono, sector, totalEmpleos};
		addRow(newRow);
	}

}
