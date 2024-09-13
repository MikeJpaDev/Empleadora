package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import UI.admin.jdialog.EditarEmpresa;
import UI.admin.jdialog.VerEmpresa;
import logica.candidato.Candidato;
import logica.cita.Cita;
import logica.empleo.Empleo;
import logica.empresa.Empresa;

public class Empleadora {

	private static Empleadora instancia;
	private ArrayList<Empresa> empresas;
	private ArrayList<Candidato> candidatos;
	private ArrayList<Cita> citas;

	public static Empleadora getInstancia(){
		if (instancia == null){
			instancia = new Empleadora();
		}
		return instancia;
	}

	private Empleadora(){
		empresas = new ArrayList<Empresa>();
		candidatos = new ArrayList<Candidato>();
		citas = new ArrayList<Cita>();
	}

	public ArrayList<Candidato> getUsuarios(){
		return candidatos;
	}

	public ArrayList<Empresa> getEmpresas(){
		return empresas;
	}
	
	public ArrayList<Cita> getCitas() {
		return citas;
	}

	//Metodos para trabajar con Las Empresas


	public ArrayList<Object[]> buscarEmpresa(String nom){

		Object[] datos = null;
		ArrayList<Object[]> datosNuevos = new ArrayList<Object[]>();
		int cont = 0;
		for(int i = 0; i < empresas.size(); i++){
			if(empresas.get(i).getNombre().contains(nom) 
					|| empresas.get(i).getNombre().toUpperCase().contains(nom.toUpperCase()) || 
					empresas.get(i).getNombre().toLowerCase().contains(nom.toLowerCase()) ||
					empresas.get(i).getNombre().contains(nom)){

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

	public ArrayList<Object[]> buscarEmpleo(String nom){

		Object[] datos = null;
		ArrayList<Object[]> datosNuevos = new ArrayList<Object[]>();
		int cont = 0;
		for(int i = 0; i < empresas.size(); i++){
			for(Empleo empleo: empresas.get(i).getEmpleos()){
				if(empleo.getID().contains(nom) 
						|| empleo.getID().toUpperCase().contains(nom.toUpperCase()) || 
						empleo.getID().toLowerCase().contains(nom.toLowerCase()) ||
						empleo.getID().contains(nom)){

					datos = new Object[6];
					datos[0] = cont+1;
					datos[1] = empleo.getID();
					datos[2] = empleo.getRama();
					datos[3] = empleo.getSalario();
					datos[4] = empleo.getEmpOfertante();
					datos[5] = empleo.getRamaEmp();
					cont++;

					datosNuevos.add(datos);
				}
			}
		}

		if(cont == 0){
			JOptionPane.showMessageDialog(null, "No se han registrados Empleos bajo ese nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
	
	public void elimEmpleo(String nom){
		boolean encontrado = false;
		for (int i = 0; i < empresas.size() && !encontrado; i++){
			for (int j = 0; j < empresas.get(i).getEmpleos().size() && !encontrado; j++){
				if (empresas.get(i).getEmpleos().get(j).getID().equalsIgnoreCase(nom)){
					empresas.get(i).getEmpleos().remove(j);
					encontrado = true;
				}
			}
		}
	}
	
	
	//Logica Empleados
	
	public void agCandidato(Candidato can){
		
		for(int i = 0; i<candidatos.size();i++){
			if(candidatos.get(i).getCi().equals(can.getCi()))
				throw new IllegalArgumentException("Usuario Repetido");
		}
		candidatos.add(can);
		Collections.sort(candidatos);
	}
	
	public void esNuevo(String ci){
		try{
			for(Candidato c : candidatos)
				c.esNuevo(ci);
		}
		catch(IllegalArgumentException e){
			throw e;
		}
	}
	
	public ArrayList<Candidato> disponiblesFecha(LocalDate fecha){
		ArrayList<Candidato> disponibles = new ArrayList<Candidato>();
		
		for(Candidato c : candidatos){
			if(c.disponible(fecha))
				disponibles.add(c);
		}
		
		return disponibles;
	}
	
	public void citasDisponibles(Candidato candidato){
		
		for(Cita c : citas){
			if(candidato.esValido(c.getEmpleo()))
				if(candidato.disponible(c.getFecha()))
					candidato.aggCitas(c);
		}
	}
	
	//Logica Citas
	
	public void aggCita(Cita cita){
		
	}

}
