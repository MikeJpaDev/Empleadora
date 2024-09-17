package controlArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BuscarArchivos {

	private final static String rutaDocumentos = System.getProperty("user.home") + File.separator + "Documents";
	private static ArrayList<File> archivosTxt;
	private File carpeta;
	private static BuscarArchivos instancia;

	private BuscarArchivos(){
		archivosTxt = new ArrayList<File>();
	}

	public static BuscarArchivos getInstance(){
		if(instancia == null)
			instancia = new BuscarArchivos();
		return instancia;
	}

	public void agregarCarpeta(){

		// Nombre de la nueva carpeta
		String nombreCarpeta = "Empleadora";

		// Crear el objeto File con la ruta completa
		File carpeta = new File(rutaDocumentos, nombreCarpeta);

		if (!carpeta.exists())
			carpeta.mkdir();

		this.carpeta = new File(rutaDocumentos + File.separator + nombreCarpeta); 

	}

	public ArrayList<File> buscadorTxt(){
		archivosTxt.clear();

		buscarTxt(carpeta);

		return archivosTxt;
	}

	private void buscarTxt(File origen){
		if(origen.exists() && origen.isDirectory()){
			File[] archivos = origen.listFiles();

			if(archivos != null)
				for(File f : archivos){
					if(f.isFile() && f.getName().toLowerCase().endsWith(".txt"))
						archivosTxt.add(f);
					else if(f.isDirectory())
						buscarTxt(f);
				}
		}
	}

	public String LeerArchivoTxt(File file) {

		if (file.exists() && file.isFile()) {
			StringBuilder contenido = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					contenido.append(linea).append("\n");
				}

				String contenidoArchivo = contenido.toString();
				return contenidoArchivo;
				
			} catch (IOException e) {
				throw new IllegalArgumentException("El archivo no se pudo leer");
			}
		} else {
			throw new IllegalArgumentException("El archivo no existe");
		}
		
		
	}
}
