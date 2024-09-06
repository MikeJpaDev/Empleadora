package util;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class EmpresasTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	public EmpresasTableModel(){
		String[] columnNames = {"IDs","Nombre", "Direccion", "Telefono", "Sector", "Total Empleos"};
		this.setColumnIdentifiers(columnNames);
	}
	public void adicionar(String ids, String nombre ,String direccion, String telefono, String
			sector, String totalEmpleos){
		Object[] newRow = new Object[]{ids, nombre , direccion, telefono, sector, totalEmpleos};
		addRow(newRow); 
	}

}
