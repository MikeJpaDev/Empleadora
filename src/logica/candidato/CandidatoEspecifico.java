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
	
	public void setDocumentos(ArrayList<Documento> docs){
		if(docs.isEmpty())
			throw new IllegalArgumentException("Se esta creando un candidato específico sin documentos");
	}
	
	public void aggDocumento(Documento doc){
		if(doc.getNombre().trim().isEmpty())
			throw new IllegalArgumentException("El nombre del documento esta vacío");
		if(doc.getContenido().trim().isEmpty())
			throw new IllegalArgumentException("El Contenido esta vacío");
		for(Documento d : documentos)
			if(d.getNombre().equalsIgnoreCase(doc.getNombre()))
				throw new IllegalArgumentException("El nombre esta repetido");
		
		documentos.add(doc);
	}
	
	public CandidatoEspecifico(String nombre, String dir, String telef,
			String ci, int aniosExp, Genero genero, NivelEscolar nivelEscolar,ArrayList<Documento> docs, Rama rama,String especialidad) {
		
		super(nombre, dir, telef, ci, aniosExp, genero, nivelEscolar,rama,especialidad);
		documentos = docs;		
	}
	
	
}
