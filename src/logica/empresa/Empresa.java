package logica.empresa;

import java.io.Serializable;
import java.util.ArrayList;

import logica.empleo.Empleo;
import logica.enums.Rama;

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String direccion;
	private String telefeno;
	private String sector;
	private ArrayList<Empleo> empleos;
	
	public int getTamArray(){
		return empleos.size();
	}
	
	public static void validarNomyDir(String text){
		
		if(text.trim().length() == 0){ 
			throw new IllegalArgumentException("El nombre o direccion esta vacio");
		}
		
		for (int i = 0; i < text.length(); i++){
			if (text.charAt(i) == ' ')
				if (i == 0){
					if(text.charAt(i+1) == ' ' || text.charAt(i) == ' ')
						throw new IllegalArgumentException("El nombre o direcion no debe comenzar con espacios");
				}
				else if(i+1 < text.length()){
					if(text.charAt(i+1) == ' ' || text.charAt(i-1) == ' ')
						throw new IllegalArgumentException("Espacios Juntos");
				}
				else if(text.charAt(text.length()-1) == ' ')
					throw new IllegalArgumentException("El nombre o direccion no debe terminar en espacio");
		}
	}
	
	
	public Empresa(String nombre, String direccion, String telefeno, String sector) {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefeno(telefeno);
		setSector(sector);
		empleos = new ArrayList<Empleo>();
	}
	
	public boolean agEmpleo(String id, String rama, Double sal, Empresa ofer, Rama ramaE){
		empleos.add(new Empleo(id, rama, sal, ofer, ramaE));
		return true;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		try{
			validarNomyDir(nombre);
			this.nombre = nombre;
		}
		catch(IllegalArgumentException e){
			throw e;
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		try{
			validarNomyDir(direccion);
			this.direccion = direccion;
		}
		catch(IllegalArgumentException e){
			throw e;
		}
	}

	public String getTelefeno() {
		return telefeno;
	}

	public void setTelefeno(String telefeno) {
			this.telefeno = telefeno;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}


	public ArrayList<Empleo> getEmpleos() {
		return empleos;
	}
	
	
	
}
