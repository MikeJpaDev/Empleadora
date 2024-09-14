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
		this.ramaEmp = ramaEmp;
	}
	
	public Rama getRamaEmp(){
		return this.ramaEmp;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id2) {
		ID = id2;
	}

	public String getRama() {
		return rama;
	}

	public void setRama(String rama) {
		this.rama = rama;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Empresa getEmpOfertante() {
		return empOfertante;
	}

	public void setEmpOfertante(Empresa empO) {
		this.empOfertante = empO;
	}
	

}
