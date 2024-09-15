package logica.candidato;

public class Documento {
	private String nombre;
	private String contenido;
	
	
	public String getNombre() {
		return nombre;
	}
	public String getContenido() {
		return contenido;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Documento(String nombre, String contenido) {
		this.setNombre(nombre);
		this.setContenido(contenido);
	}
	
	
	
}
