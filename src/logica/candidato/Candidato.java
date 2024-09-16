package logica.candidato;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import logica.cita.Cita;
import logica.empleo.Empleo;
import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;

public class Candidato implements Comparable<Candidato>{
	
				//Propiedades
	private String nombre;
	private String dir;
	private String telef;
	private String ci;
	private String especialidad;
	private int aniosExp;
	private Genero genero;
	private NivelEscolar nivelEscolar;
	private Rama rama;
	private ArrayList<Cita> citas;
	
	// Constructor
	
	
	public Candidato(String nombre, String dir, String telef, String ci,
			int aniosExp, Genero genero, NivelEscolar nivelEscolar,Rama rama,String especialidad) {
		this.setNombre(nombre);
		this.setDir(dir);
		this.setTelef(telef);
		this.setCi(ci);
		this.setAniosExp(aniosExp);
		this.setGenero(genero);
		this.setNivelEscolar(nivelEscolar);
		this.setRama(rama);
		this.setEspecialidad(especialidad);
		citas = new ArrayList<>();
	}
	
				//Metodos
	
	//Sets


	private void setCi(String ci) {
		
		try{
			Candidato.validarCi(ci);
			this.ci = ci;
		}
		catch(IllegalArgumentException e){
			throw e;
		}
		
	}
	
	private void setNombre(String nombre){
		
		try{
			Candidato.validarNombre(nombre);
			this.nombre = nombre;
		}
		catch(IllegalArgumentException e){
			throw e;
		}
		
	}

	private void setDir(String dir) {
		
		if(dir == null || dir.trim().isEmpty())  //Comprobando nombre vacio
			throw new IllegalArgumentException("esta vacia la direccion");
		
		if(!dir.equalsIgnoreCase(dir.trim()))  //Espacios al principio o final
			throw new IllegalArgumentException("No deje espacios en blanco al principio o al final");
		
		if(!dir.equalsIgnoreCase(dir.replaceAll("  ", "")))
			throw new IllegalArgumentException("dos espacios en blanco juntos");
		this.dir = dir;
	}

	private void setTelef(String telef) {
		
		try{
			Candidato.validarTelef(telef);
			this.telef = telef;
		}
		catch(IllegalArgumentException e){
			throw e;
		}
		
	}

	private void setAniosExp(int aniosExp) {
		
		int diaSiglo = Character.getNumericValue(ci.charAt(6));
		
		String anio = null;
		if(diaSiglo <= 5  && diaSiglo >=0)
			anio = "19" + ci.substring(0, 2);
		else if(diaSiglo <= 8  && diaSiglo >=6)
			anio = "20" + ci.substring(0, 2);
		
		int anioInt = Integer.parseInt(anio);
		
		LocalDate nacido = LocalDate.of(anioInt + 18, 1, 1);
		LocalDate hoy = LocalDate.now();
		
		int difAnios = (int)ChronoUnit.YEARS.between(nacido, hoy);
		
		if (aniosExp >= 0 && aniosExp<= difAnios)
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
	
	private void setRama(Rama rama){
		this.rama = rama;
	}
	
	private void setEspecialidad(String especialidad) {
		if(especialidad.trim().isEmpty())
			throw new IllegalArgumentException("La especialidad esta vacia");
		this.especialidad = especialidad;
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
	public String getEspecialidad() {
		return especialidad;
	}

	public Rama getRama() {
		return rama;
	}

	public ArrayList<Cita> getCitas() {
		return citas;
	}

	@Override
	public int compareTo(Candidato o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
	//Metodos
	
	//Saber si el CI ya esta en el sistema
	
	public void esNuevo(String ci){
		if(this.ci.equals(ci))
			throw new IllegalArgumentException("El Carnet de Identidad ya esta en el sistemaa");
	}
	
	public boolean aggCitas(Cita cita, Candidato c){
		boolean agregado = true;
		if(!(citas.isEmpty())){
			for(int i = 0; i < citas.size() && agregado; i++){
				if(citas.get(i).getFecha().compareTo(cita.getFecha()) == 0)
					agregado = false;
			}
		}
		
		if(agregado){
			citas.add(cita);
			cita.getCandidatos().add(c);
		}
		
		return agregado;
	}
	
	// Saber si es valido para un Empleo
	
	public boolean disponible(LocalDate date){
		boolean disponible = true;
		
		if(!(citas.isEmpty())){
			for(int i = 0; i < citas.size() && disponible; i++)
				if((citas.get(i).getFecha().compareTo(date)) == 0)
					disponible = false;
		}
		
		return disponible;
	}
	
	public boolean esValido(Empleo empleo){
		boolean valido = false;
		
		if(empleo.getRamaEmp().toString().equals(rama.toString())){
			valido = true;
		}
		
		return valido;
	}
	
	public static void validarNombre(String nombre){
		
		if(nombre == null || nombre.trim().isEmpty())  //Comprobando nombre vacio
			throw new IllegalArgumentException("esta vacio el nombre");
		
		if(!nombre.equalsIgnoreCase(nombre.trim()))  //Espacios al principio o final
			throw new IllegalArgumentException("No deje espacios en blanco al principio o al final");
		
		if(!nombre.equalsIgnoreCase(nombre.replaceAll("  ", "")))
			throw new IllegalArgumentException("dos espacios en blanco juntos");
		
		String test = new String(nombre.replace(" ", "")); //Comprobando caracteres especiales
		for(int i = 0; i < test.length(); i++)
			if(!Character.isAlphabetic(test.charAt(i)))
				throw new IllegalArgumentException("El nombre contiene caracteres no validos");
	}
	
	public static void validarTelef(String telef){
		
		if(telef == null || telef.trim().isEmpty())
			throw new IllegalArgumentException("El telefono esta vacio");
		
		String test = new String(telef); //Comprobando caracteres no númericos
		for(int i = 0; i < test.length(); i++)
			if(!Character.isDigit(test.charAt(i)))
				throw new IllegalArgumentException("El telefono contiene caracteres no numericos");
		
		if(telef.trim().length() > 12)
			throw new IllegalArgumentException("La cantidad de digitos del telefono tiene que ser menor que 12");
		if(telef.trim().length() < 8)
			throw new IllegalArgumentException("La cantidad de digitos del telefono tiene que ser mayor que 8");
		long valorNum = Long.parseLong(telef);
		if(valorNum < 10000000)
			throw new IllegalArgumentException("El numero de teléfono no puede tener muchos 0 a la izquierda");
	}
	
	public static void validarCi(String ci){    //Validacion Del Ci
		
		
		String anio = null;
		if(ci == null || ci.isEmpty())
			throw new IllegalArgumentException("esta vacio el campo del ci");
		
		String test = new String(ci); //Comprobando caracteres especiales
		for(int i = 0; i < test.length(); i++)
			if(!Character.isDigit(test.charAt(i)))
				throw new IllegalArgumentException("el carnet de identidad contiene caracteres no numericos");
		
		if(ci.length() != 11)
			throw new IllegalArgumentException("La longitud del CI no es correcta");
		
		int diaSiglo = Character.getNumericValue(ci.charAt(6));
		
		if(diaSiglo <= 5  && diaSiglo >=0)
			anio = "19" + ci.substring(0, 2);
		else if(diaSiglo <= 8  && diaSiglo >=6)
			anio = "20" + ci.substring(0, 2);
		else
			throw new IllegalArgumentException("El septimo digito del ci es incorrecto");
		
		int mesInt = Integer.parseInt(ci.substring(2, 4));
		
		if(mesInt < 1 || mesInt > 12)
			throw new IllegalArgumentException("El mes del ci es incorrecto");
		
		Month mes = Month.of(mesInt);
		int cantDias = mes.length(false);
		int dia = Integer.parseInt(ci.substring(4, 6));
		
		if(dia <=0 || dia> cantDias)
			throw new IllegalArgumentException("Los dias no coinciden con el mes del ci, es incorrecto");
		
		int anioInt = Integer.parseInt(anio);
		
		LocalDate fechaCi = LocalDate.of(anioInt, mes, dia);
		LocalDate hoy = LocalDate.now();
		
		if(hoy.compareTo(fechaCi) <= 0)
			throw new IllegalArgumentException("fecha mayor que la actual en el Ci");
		
		int difAnios = (int)ChronoUnit.YEARS.between(fechaCi, hoy);
		
		if(difAnios < 18)
			throw new IllegalArgumentException("Menor de 18 aÑos");
		
	}
	
	public int getEdad(){	
		int diaSiglo = Character.getNumericValue(ci.charAt(6));
		String anio = null;
		
		if(diaSiglo <= 5  && diaSiglo >=0)
			anio = "19" + ci.substring(0, 2);
		else if(diaSiglo <= 8  && diaSiglo >=6)
			anio = "20" + ci.substring(0, 2);
		
		int mesInt = Integer.parseInt(ci.substring(2, 4));
		Month mes = Month.of(mesInt);
		
		int cantDias = mes.length(false);
		int dia = Integer.parseInt(ci.substring(4, 6));
		
		int anioInt = Integer.parseInt(anio);
		
		LocalDate fechaCi = LocalDate.of(anioInt, mes, dia);
		LocalDate hoy = LocalDate.now();
		
		return (int)ChronoUnit.YEARS.between(fechaCi, hoy);
	}
}
