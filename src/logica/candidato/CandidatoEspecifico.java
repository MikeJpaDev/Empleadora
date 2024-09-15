package logica.candidato;

import java.util.ArrayList;

import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;

public class CandidatoEspecifico extends Candidato {

	private ArrayList<Documento> documentos;
	

	public ArrayList<Documento> getDocumentos() {
		return documentos;
	}
	
	public CandidatoEspecifico(String nombre, String dir, String telef,
			String ci, int aniosExp, Genero genero, NivelEscolar nivelEscolar,ArrayList<Documento> docs, Rama rama,String especialidad) {
		
		super(nombre, dir, telef, ci, aniosExp, genero, nivelEscolar,rama,especialidad);
		documentos = docs;		
	}
	
	
}
