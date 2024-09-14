package logica.empresa;

import java.util.ArrayList;

import logica.empleo.Empleo;
import logica.enums.Rama;

public class Empresa {
	
	private String nombre;
	private String direccion;
	private String telefeno;
	private String sector;
	private ArrayList<Empleo> empleos;
	
	public int getTamArray(){
		return empleos.size();
	}
	
	
	public Empresa(String nombre, String direccion, String telefeno, String sector) {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefeno(telefeno);
		setSector(sector);
		empleos = new ArrayList<Empleo>();
	}
	
	public void agEmpleo(String id, String rama, Double sal, Empresa ofer, Rama ramaE){
		empleos.add(new Empleo(id, rama, sal, ofer, ramaE));
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
