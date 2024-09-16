package logica.cita;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import logica.candidato.Candidato;
import logica.empleo.Empleo;

public class Cita {
	private Empleo empleo;
	private ArrayList<Candidato> candidatos;
	private LocalDate fecha;
	
	public Cita(Empleo empleo, LocalDate fecha) {
		
		this.empleo = empleo;
		this.candidatos = new ArrayList<Candidato>();
		this.setFecha(fecha);
		
	}
	
	
	public Empleo getEmpleo() {
		return empleo;
	}
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setEmpleo(Empleo empleo) {
		this.empleo = empleo;
	}
	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	public void setFecha(LocalDate fecha) {
		LocalDate hoy = LocalDate.now();
		if(hoy.compareTo(fecha) > 0)
			throw new IllegalArgumentException("No se puede agregar una cita de una fecha pasada");
		else if(hoy.compareTo(fecha) == 0)
			throw new IllegalArgumentException("No se puede agregar una cita para el mismo dia actual");
		
		long diasDiferencia = ChronoUnit.DAYS.between(hoy, fecha);
		
		if(diasDiferencia > 31)
			throw new IllegalArgumentException("Planificar una cita tiene un maximo de 31 dias desde la fecha actual");
		
		this.fecha = fecha;
	}
	
	
}
