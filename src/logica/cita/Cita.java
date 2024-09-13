package logica.cita;
import java.time.LocalDate;
import java.util.ArrayList;
import logica.candidato.Candidato;
import logica.empleo.Empleo;

public class Cita {
	private Empleo empleo;
	private ArrayList<Candidato> candidatos;
	private LocalDate fecha;
	
	public Cita(Empleo empleo, LocalDate fecha) {
		
		this.empleo = empleo;
		this.candidatos = new ArrayList<>();
		this.fecha = fecha;
		
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
		this.fecha = fecha;
	}
	
	
}
