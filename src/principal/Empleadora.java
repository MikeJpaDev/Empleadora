package principal;

import java.util.ArrayList;

public class Empleadora {
	
	private static Empleadora instancia;
	private ArrayList<Empresa> empresas;
	private ArrayList<Usuario> usuarios;
	
	public static Empleadora getInstancia(){
		if (instancia == null){
			instancia = new Empleadora();
		}
		
		return instancia;
	}
	
	private Empleadora(){
		empresas = new ArrayList<Empresa>();
		usuarios = new ArrayList<Usuario>();
	}
	
	public void agEmpresa(Empresa e){
		empresas.add(e);
	}
	
	public void agUsuario(Usuario u){
		usuarios.add(u);
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public ArrayList<Empresa> getEmpresas(){
		return empresas;
	}

}
