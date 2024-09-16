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
		if(nombre == null || nombre.trim().isEmpty())  //Comprobando nombre vacio
			throw new IllegalArgumentException("El nombre esta vacio");
		
		if(!nombre.equalsIgnoreCase(nombre.trim()))  //Espacios al principio o final
			throw new IllegalArgumentException("No deje espacios en blanco al principio o al final");
		
		if(!nombre.equalsIgnoreCase(nombre.replaceAll("  ", "")))
			throw new IllegalArgumentException("dos espacios en blanco juntos");
		this.nombre = nombre;
	}
	private void setContenido(String contenido) {
		if(contenido == null || contenido.trim().isEmpty())  //Comprobando nombre vacio
			throw new IllegalArgumentException("El contenido esta vacio");
		this.contenido = contenido;
	}
	public Documento(String nombre, String contenido) {
		this.setNombre(nombre);
		this.setContenido(contenido);
	}
	
	
	
}
