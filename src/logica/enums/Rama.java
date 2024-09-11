package logica.enums;

import java.util.ArrayList;

public enum Rama {
	DIRECTIVO,
	SEGURIDAD,
	SECRETARIO,
	RECURSOS_HUMANOS, 
	DOCTOR,
	MAESTRO,
	LIMPIEZA,
	EJECUTIVO,
	CHOFER,
	ENFERMERA;
	

	static ArrayList<Rama> ramas;
	
	
	public static ArrayList<Rama> getRamasSalud(){
		
		ramas = new ArrayList<>();
		ramas.add(DIRECTIVO);
		ramas.add(SECRETARIO);
		ramas.add(RECURSOS_HUMANOS);
		ramas.add(DOCTOR);
		ramas.add(LIMPIEZA);
		ramas.add(EJECUTIVO);
		ramas.add(SEGURIDAD);
		
		return ramas;
	}
	
	public static ArrayList<Rama> getRamasEducacion(){
		
		ramas = new ArrayList<>();
		
		ramas.add(DIRECTIVO);
		ramas.add(SEGURIDAD);
		ramas.add(SECRETARIO);
		ramas.add(RECURSOS_HUMANOS);
		ramas.add(MAESTRO);
		ramas.add(LIMPIEZA);
		ramas.add(EJECUTIVO);
		
		return ramas;
	}
	
	public static ArrayList<Rama> getRamasTurPriv(){
		
		ramas = new ArrayList<>();
		
		ramas.add(DIRECTIVO);
		ramas.add(SECRETARIO);
		ramas.add(RECURSOS_HUMANOS);
		ramas.add(LIMPIEZA);
		ramas.add(EJECUTIVO);
		ramas.add(CHOFER);
		ramas.add(SEGURIDAD);
		
		return ramas;
	}
	
	
	
	
	
	
	
	
	
	
	
}
