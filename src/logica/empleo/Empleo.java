package logica.empleo;

public class Empleo {
	
	private String ID;
	private String rama;
	private Double salario;
	private String empOfertante;
	
	public Empleo( String id, String rama, double sal, String empO){
		this.setID(id);
		this.setRama(rama);
		this.setSalario(sal);
		this.setEmpOfertante(empO);		
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

	public String getEmpOfertante() {
		return empOfertante;
	}

	public void setEmpOfertante(String empOfertante) {
		this.empOfertante = empOfertante;
	}
	

}
