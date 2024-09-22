package logica.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import logica.candidato.Candidato;
import logica.candidato.CandidatoEspecifico;
import logica.candidato.Documento;
import logica.cita.Cita;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreate {
	public static void crearPDF(Cita cita) throws FileNotFoundException, DocumentException{
		
		Document documento = new Document();
		FileOutputStream file = new FileOutputStream("Registros " + cita.getEmpleo().getID() + ".pdf");
		
		PdfWriter.getInstance(documento, file);
		
		try{
		//Abrir el documento
		documento.open();
		Paragraph personas = new Paragraph();
		
		Paragraph titulo =  new Paragraph("Lista de Candidatos \n\n",
				FontFactory.getFont("arial",
						22,
						Font.BOLD,
						BaseColor.BLUE
						)
				);
		
		//Añadiendo el titulo a el documento pdf
		documento.add(titulo);
		
		//Crear la tabla
		PdfPTable tabla = new PdfPTable(4);
		tabla.addCell("No");
		tabla.addCell("Nombre");
		tabla.addCell("Ci");
		tabla.addCell("Teléfono");
		
		
		for(int i = 0; i < cita.getCandidatos().size() ; i++){
			tabla.addCell("" + i+1);
			tabla.addCell(cita.getCandidatos().get(i).getNombre());
			tabla.addCell(cita.getCandidatos().get(i).getCi());
			tabla.addCell(cita.getCandidatos().get(i).getTelef());
		}
		
		Paragraph contenido;
		Paragraph contDoc;
		
		personas.clear();
		for(Candidato c : cita.getCandidatos()){
			contenido = new Paragraph("Nombre: " + c.getNombre() + "\n"
					+ "Ci: " + c.getCi() + "\n" 
					+ "Dirección: " + c.getDir() + "\n" 
					+ "Teléfono: " + c.getTelef() + "\n"
					+ "Especialidad: " + c.getEspecialidad() + "\n"
					+ "Años de Experiencia: " + c.getAniosExp() + "\n"
					+ "Genero: " + c.getGenero() + "\n"
					+ "Nivel Escolar: " + c.getNivelEscolar() + "\n" , 
					FontFactory.getFont("arial",12));
			
			documento.add(contenido);
			if(c instanceof CandidatoEspecifico){
				contDoc = new Paragraph("Documentos: \n", FontFactory.getFont("arial", 12));
				for(Documento d : ((CandidatoEspecifico) c).getDocumentos()){
					contDoc.add("Titulo: " + d.getNombre() + "\n"
							+ "Contenido: " + d.getContenido() + "\n");
				}
				personas.add(contDoc);
			}
			personas.add(contenido + "\n\n\n");
			documento.add(personas);
		}
		
		documento.add(tabla);
		
		}catch(Exception e){
			throw new IllegalArgumentException(e.getMessage());
		}finally{
			documento.close();
		}
	}
}
