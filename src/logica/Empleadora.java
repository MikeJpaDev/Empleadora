package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import UI.admin.jdialog.EditarEmpresa;
import UI.admin.jdialog.VerEmpresa;
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

	public void agCandidato(Candidato u){
		candidatos.add(u);
	}

	public ArrayList<Candidato> getUsuarios(){
		return candidatos;
	}

	public ArrayList<Empresa> getEmpresas(){
		return empresas;
	}

	//Metodos para trabajar con Las Empresas
	public ArrayList<Object[]> buscarEmpresa(String nom){
		
		Object[] datos = null;
		ArrayList<Object[]> datosNuevos = new ArrayList<Object[]>();
		int cont = 0;
		for(int i = 0; i < empresas.size(); i++){
			if(empresas.get(i).getNombre().contains(nom) 
					|| empresas.get(i).getNombre().contains(nom.toUpperCase()) || empresas.get(i).getNombre().contains(nom.toLowerCase())){
				datos = new Object[6];
				datos[0] = cont+1;
				datos[1] = empresas.get(i).getNombre();
				datos[2] = empresas.get(i).getDireccion();
				datos[3] = empresas.get(i).getTelefeno();
				datos[4] = empresas.get(i).getSector();
				datos[5] = 0;
				cont++;
				datosNuevos.add(datos);
			}
		}

		if(cont == 0){
			JOptionPane.showMessageDialog(null, "No se han registrados Empresas bajo ese nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}

		return datosNuevos;

	}

	public void verEmpresa(int index){

		try {
			VerEmpresa dialog = new VerEmpresa(empresas.get(index));	
			dialog.setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean existe(String nom){

		boolean encontrado = false;

		for(int i = 0; i < empresas.size() && !encontrado; i++){
			if(empresas.get(i).getNombre().equalsIgnoreCase(nom)){
				encontrado = true;
			}
		}

		return encontrado;
	}

	public boolean agEmpresa(String nom, String dir, String tel, String sec){

		boolean retorno = false;


		if(empresas.size() != 0){
			if(!existe(nom)){
				empresas.add(new Empresa(nom, dir, tel, sec));
				retorno = true;
			}
		}
		else{
			empresas.add(new Empresa(nom, dir, tel, sec));
			retorno = true;
		}

		return retorno;
	}

	public void editarDatos(int indice){

		try {
			EditarEmpresa dialog = new EditarEmpresa(empresas.get(indice), indice);	
			dialog.setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void elimEmpresa(int emp){
		empresas.remove(emp);
	}

}
