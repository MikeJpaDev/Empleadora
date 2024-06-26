package principal;

public class Usuario {

	private String CI;
	private String nombre;
	private String psswd;
	private char sexo;
	private String direccion;
	private String telefono;
	private String nivelEsc;
	private String especialidad;
	private int exp;
	private int edad;


	public Usuario(String CI, String nombre, String psswd, char sexo, String direccion, String telefono, String nivelEsc, String especialidad, int exp, int edad) {
		setCI(CI);
		setNombre(nombre);
		setPsswd(psswd);
		setSexo(sexo);
		setDireccion(direccion);
		setTelefono(telefono);
		setNivelEsc(nivelEsc);
		setEspecialidad(especialidad);
		setExp(exp);
		setEdad(edad);
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCI() {
		return CI;
	}
	public void setCI(String cI) {
		CI = cI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPsswd() {
		return psswd;
	}
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNivelEsc() {
		return nivelEsc;
	}
	public void setNivelEsc(String nivelEsc) {
		this.nivelEsc = nivelEsc;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;

	}



}
