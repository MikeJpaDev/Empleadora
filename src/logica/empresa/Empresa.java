package logica.empresa;

public class Empresa {
	
	private String nombre;
	private String direccion;
	private String telefeno;
	private String sector;
	
	
	public Empresa(String nombre, String direccion, String telefeno, String sector) {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefeno(telefeno);
		setSector(sector);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefeno() {
		return telefeno;
	}

	public void setTelefeno(String telefeno) {
		this.telefeno = telefeno;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	
}
