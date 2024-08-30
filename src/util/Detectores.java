package util;

import javax.swing.JOptionPane;

public final class Detectores {
	
	private Detectores(){};
	
	public static char determinarSexo(String ci) {
		char sexo = 'N';
		if(ci==null || ci.length()!=11)
			JOptionPane.showMessageDialog(null, "Carnet de Identidad no válido", "Error CI", JOptionPane.ERROR_MESSAGE);
		else{
			sexo = 'F';
			int aux = ci.charAt(9);
			if(aux%2==0)
				sexo = 'M';
		}
		return sexo;
	}

}
