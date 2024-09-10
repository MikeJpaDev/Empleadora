package logica.candidato;

import java.util.ArrayList;
import java.util.Date;

import logica.enums.Genero;
import logica.enums.NivelEscolar;

public class Candidato implements Comparable<Candidato>{
	
				//Propiedades
	private String nombre;
	private String dir;
	private String telef;
	private String ci;
	private int aniosExp;
	private Genero genero;
	private NivelEscolar nivelEscolar;
	//falta rama
	
	// Constructor
	
	
	public Candidato(String nombre, String dir, String telef, String ci,
			int aniosExp, Genero genero, NivelEscolar nivelEscolar) {
		super();
		this.setNombre(nombre);
		this.setDir(dir);
		this.setTelef(telef);
		this.ci = ci;
		this.setAniosExp(aniosExp);
		this.setGenero(genero);
		this.setNivelEscolar(nivelEscolar);
	}
	
				//Metodos
	
	//Sets


	private void setCi(String ci) {
		if(ci != null && !ci.isEmpty())
			throw new IllegalArgumentException("esta vacio el campo del ci");
		
		String test = new String(ci); //Comprobando caracteres especiales
		for(int i = 0; i < test.length(); i++)
			if(!Character.isDigit(test.charAt(i)))
				throw new IllegalArgumentException("el carnet de identidad contiene caracteres no numericos");
		
		if(ci.length() != 11)
			throw new IllegalArgumentException("La longitud del CI no es correcta");
		
		/*if()  falta validacion carnet de identidad*/
	}
	
	private void setNombre(String nombre){
		
		if(nombre == null && nombre.isEmpty())  //Comprobando nombre vacio
			throw new IllegalArgumentException("esta vacio el nombre");
		
		if(!nombre.equalsIgnoreCase(nombre.trim()))  //Espacios al principio o final
			throw new IllegalArgumentException("No deje espacios en blanco al principio o al final");
		
		if(!nombre.equalsIgnoreCase(nombre.replaceAll("  ", "")))
			throw new IllegalArgumentException("dos espacios en blanco juntos");
		
		String test = new String(nombre.replace(" ", "")); //Comprobando caracteres especiales
		for(int i = 0; i < test.length(); i++)
			if(!Character.isAlphabetic(test.charAt(i)))
				throw new IllegalArgumentException("El nombre contiene caracteres no validos");
		
		this.nombre = nombre;
	}

	private void setDir(String dir) {
		
		if(dir == null && dir.isEmpty())  //Comprobando nombre vacio
			throw new IllegalArgumentException("esta vacia la direccion");
		
		if(!dir.equalsIgnoreCase(dir.trim()))  //Espacios al principio o final
			throw new IllegalArgumentException("No deje espacios en blanco al principio o al final");
		
		if(!dir.equalsIgnoreCase(dir.replaceAll("  ", "")))
			throw new IllegalArgumentException("dos espacios en blanco juntos");
		
		String test = new String(dir.replace(" ", "")); //Comprobando caracteres especiales
		for(int i = 0; i < test.length(); i++)
			if(!Character.isAlphabetic(test.charAt(i)))
				throw new IllegalArgumentException("La direccion contiene caracteres no validos");
		
		this.dir = dir;
	}

	private void setTelef(String telef) {
		
		if(telef == null && telef.isEmpty())
			throw new IllegalArgumentException("el telefono esta vacio");
		
		String test = new String(telef); //Comprobando caracteres no númericos
		for(int i = 0; i < test.length(); i++)
			if(!Character.isDigit(test.charAt(i)))
				throw new IllegalArgumentException("el telefono contiene caracteres no numericos");
		
		if(telef.length() > 9)
			throw new IllegalArgumentException("la cantidad de digitos es mayor de 9");
		
		this.telef = telef;
	}

	private void setAniosExp(int aniosExp) {
		if (aniosExp >= 0 && aniosExp <= 100)
			this.aniosExp = aniosExp;
		else
			throw new IllegalArgumentException("años de experiencias no volido");
	}
	private void setGenero(Genero genero) {
		this.genero = genero;
	}
	private void setNivelEscolar(NivelEscolar nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}
	
	//Gets
	
	public String getCi() {
		return ci;
	}
	public int getAniosExp() {
		return aniosExp;
	}
	public Genero getGenero() {
		return genero;
	}
	public NivelEscolar getNivelEscolar() {
		return nivelEscolar;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDir() {
		return dir;
	}
	public String getTelef() {
		return telef;
	}

	@Override
	public int compareTo(Candidato o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
}
