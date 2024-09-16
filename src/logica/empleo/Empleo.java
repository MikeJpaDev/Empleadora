package logica.empleo;

import logica.empresa.Empresa;
import logica.enums.Rama;

public class Empleo {

	private String ID;
	private String rama;
	private Double salario;
	private Empresa empOfertante;
	private Rama ramaEmp;

	public Empleo( String id, String rama, double sal, Empresa empO, Rama ramaEmp){
		this.setID(id);
		this.setRama(rama);
		this.setSalario(sal);
		this.setEmpOfertante(empO);	
		this.setRamaEmp(ramaEmp);
	}
	
	private void validarRamaEmp(Rama r){
		if (r == null){
			throw new IllegalArgumentException("Rama de empleo vacia");
		}
	}
	
	private void setRamaEmp(Rama r){
		try {
			validarRamaEmp(r);
			this.ramaEmp = r;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	private void validarSalario(Double sal){
		if(sal <= 0){
			throw new IllegalArgumentException("Salario no valido");
		}
	}
	
	private void validarOfertante(Empresa emp){
		if(emp == null){
			throw new IllegalArgumentException("Empresa ofertante null");
		}
	}

	public static void validar(String text){

		if(text.trim().length() == 0){ 
			throw new IllegalArgumentException("Hay un campo vacio");
		}

		for (int i = 0; i < text.length(); i++){
			if (text.charAt(i) == ' ')
				if (i == 0){
					if(text.charAt(i+1) == ' ' || text.charAt(i) == ' ')
						throw new IllegalArgumentException("Los campos rellenables no deben comenzar con espacios");
				}
				else if(i+1 < text.length()){
					if(text.charAt(i+1) == ' ' || text.charAt(i-1) == ' ')
						throw new IllegalArgumentException("Espacios Juntos");
				}
				else if(text.charAt(text.length()-1) == ' ')
					throw new IllegalArgumentException("Los campos rellenables no deben terminar en espacio");
		}
	}

	public Rama getRamaEmp(){
		return this.ramaEmp;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id2) {
		try {
			validar(id2);
			this.ID = id2;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public String getRama() {
		return rama;
	}

	public void setRama(String rama) {
		try {
			validar(rama);
			this.rama = rama;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		try {
			validarSalario(salario);
			this.salario = salario;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public Empresa getEmpOfertante() {
		return empOfertante;
	}

	public void setEmpOfertante(Empresa empO) {
		try {
			validarOfertante(empO);
			this.empOfertante = empO;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}


}
