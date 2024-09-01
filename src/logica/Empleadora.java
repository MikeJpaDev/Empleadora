package logica;

import java.util.ArrayList;

import logica.candidato.Candidato;
import logica.empresa.Empresa;

public class Empleadora {
	
	private static Empleadora instancia;
	private ArrayList<Empresa> empresas;
	private ArrayList<Candidato> candidatos;
	
	public static Empleadora getInstancia(){
		if (instancia == null){
			instancia = new Empleadora();
		}
		return instancia;
	}
	
	private Empleadora(){
		empresas = new ArrayList<Empresa>();
		candidatos = new ArrayList<Candidato>();
	}
	
	public void agEmpresa(Empresa e){
		empresas.add(e);
	}
	
	public void agCandidato(Candidato u){
		candidatos.add(u);
	}
	
	public ArrayList<Candidato> getUsuarios(){
		return candidatos;
	}
	
	public ArrayList<Empresa> getEmpresas(){
		return empresas;
	}

}
