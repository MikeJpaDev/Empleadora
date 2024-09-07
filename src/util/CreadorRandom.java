package util;

import logica.Empleadora;

public class CreadorRandom {

	private static String[] nombres = {"Habana","HabanaTravel","Viajando","Super4","Revolico","Por La Libre","Coge lo Tuyo"};
	private static String[] direcciones = {"Calle 1", "Calle 6","Prado", "Cerro y Boyeros", "10 de Octubre", "Calle 4", "Calle 17"};
	private static String[] telefonos = {"55065148", "76836414", "51179157", "54636108", "50353680", "52321458", "53212045"};
	private static String[] sectores = {"SALUD", "EDUCACION", "TURISMO", "PRIVADO"};

	public static void creadorEmpresas(){
		int contSect = 0;

		for(int i = 0; i < 7; i++){
			if(contSect == 4){
				contSect = 1;
			}
			Empleadora.getInstancia().agEmpresa(nombres[i], direcciones[i], telefonos[i], sectores[contSect++]);
		}
	}

}
