package logica.candidato;

import java.util.ArrayList;

import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;

public class CandidatoEspecifico extends Candidato {

	private ArrayList<Documento> documentos;
	private Rama rama;
	

	public ArrayList<Documento> getDocumentos() {
		return documentos;
	}
	
	public CandidatoEspecifico(String nombre, String dir, String telef,
			String ci, int aniosExp, Genero genero, NivelEscolar nivelEscolar,ArrayList<Documento> docs, Rama rama) {
		
		super(nombre, dir, telef, ci, aniosExp, genero, nivelEscolar);
		documentos = new ArrayList<>(docs);
		this.setRama(rama);
		
	}
	
	private void setRama(Rama rama){
		this.rama = rama;
	}
	
	
}
