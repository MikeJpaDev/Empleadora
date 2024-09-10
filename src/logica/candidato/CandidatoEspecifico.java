package logica.candidato;

import java.util.ArrayList;

import logica.enums.Genero;
import logica.enums.NivelEscolar;

public class CandidatoEspecifico extends Candidato {

	private ArrayList<Documento> documentos;

	public ArrayList<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(ArrayList<Documento> documentos) {
		this.documentos = documentos;
	}
	
	public CandidatoEspecifico(String nombre, String dir, String telef,
			String ci, int aniosExp, Genero genero, NivelEscolar nivelEscolar,ArrayList<Documento> docs) {
		
		super(nombre, dir, telef, ci, aniosExp, genero, nivelEscolar);
		documentos = new ArrayList<>(docs);
		
	}
	
	
}
