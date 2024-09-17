package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import comparadores.CompararCandPorEdad;
import comparadores.CompararPorCitas;
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
	
	
	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public static ArrayList<Empleo> mejoresPagados(){
		ArrayList<Empleo> empleos = obtEmpleos();
		ArrayList<Empleo> mejPagados = new ArrayList<>();
		
		Double sal = Double.MIN_VALUE;

		for(Empleo emp : empleos){
			if(emp.getSalario().compareTo(sal) == 0){
				mejPagados.add(emp);
			}
			else if(emp.getSalario().compareTo(sal) > 0){
				mejPagados.clear();
				sal = emp.getSalario();
				mejPagados.add(emp);
			}
		}
		
		return mejPagados;
		
		
	}
	
	private static ArrayList<Empleo> obtEmpleos(){
		ArrayList<Empleo> empleos = new ArrayList<>();
		
		for(Empresa e : Empleadora.getInstancia().getEmpresas())
			for(Empleo em : e.getEmpleos())
				empleos.add(em);
		return empleos;
	}
	
	
	public static ArrayList<Empresa> mayoresOfertantes(){
		ArrayList<Empresa> mayoresOfertantes = new ArrayList<>();
		int mayCantOfertas = Integer.MIN_VALUE;

		for(Empresa emp : Empleadora.getInstancia().getEmpresas()){
			if(emp.getEmpleos().size() == mayCantOfertas){
				mayoresOfertantes.add(emp);
			}
			else if(emp.getEmpleos().size() > mayCantOfertas){
				mayoresOfertantes.clear();
				mayCantOfertas = emp.getEmpleos().size();
				mayoresOfertantes.add(emp);
			}
		}
		
		return mayoresOfertantes;
	}


	public static Empleadora getInstancia(){
		if (instancia == null){
			instancia = new Empleadora();
		}
		return instancia;
	}
	
	public void agregarCita(Cita cita){
		citas.add(cita);
	}
	
	public void agregarCita(Empleo empleo, LocalDate fecha){
		citas.add(new Cita(empleo, fecha));
	}

	private Empleadora(){
		empresas = new ArrayList<Empresa>();
		candidatos = new ArrayList<Candidato>();
		citas = new ArrayList<Cita>();
	}

	public ArrayList<Empresa> getEmpresas(){
		return empresas;
	}
	
	public ArrayList<Cita> getCitas() {
		return citas;
	}

	//Contador cantidad de Empleos
	public int cantEmpelos(){
		int cantEmp = 0;
		
		for(Empresa e : empresas)
			cantEmp += e.getTamArray();
		
		return cantEmp;
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

		Object[] datos = new Object[6];
		ArrayList<Object[]> datosNuevos = new ArrayList<>();
		int cont = 0;
		for(int i = 0; i < empresas.size(); i++){
			for(Empleo empleo: empresas.get(i).getEmpleos()){
				if(empleo.getRamaEmp().toString().contains(nom) 
						|| empleo.getRamaEmp().toString().toUpperCase().contains(nom.toUpperCase()) || 
						empleo.getRamaEmp().toString().toLowerCase().contains(nom.toLowerCase()) ||
						empleo.getRamaEmp().toString().contains(nom)){
					
					datos[0] = cont+1;
					datos[1] = empleo.getID();
					datos[2] = empleo.getRama();
					datos[3] = "$" + empleo.getSalario();
					datos[4] = empleo.getEmpOfertante();
					datos[5] = empleo.getRamaEmp();
					cont++;

					datosNuevos.add(datos);
				}
			}
		}

		if(datosNuevos.size() == 0){
			JOptionPane.showMessageDialog(null, "No se han registrados Empleos bajo relacionados a esta rama", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
			else{
				throw new IllegalArgumentException("Ya existe la empresa");
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
		eliminarEmpleosEmpresa(empresas.get(emp));
		empresas.remove(emp);
	}
	
	public Empleo elimEmpleo(String nom){
		boolean encontrado = false;
		Empleo empleo = null;
		for (int i = 0; i < empresas.size() && !encontrado; i++){
			for (int j = 0; j < empresas.get(i).getEmpleos().size() && !encontrado; j++){
				if (empresas.get(i).getEmpleos().get(j).getID().equalsIgnoreCase(nom)){
					empleo = empresas.get(i).getEmpleos().get(j);
					empresas.get(i).getEmpleos().remove(j);
					encontrado = true;
				}
			}
		}
		return empleo;
	}
	
	public void eliminarCitasDeUnEmpleo(Empleo empleo){
		
		for(int i = 0; i < citas.size(); i++){
			if(citas.get(i).getEmpleo().equals(empleo)){
				citas.remove(i--);
			}
		}
		
		for(Candidato c : candidatos)
			for(int i = 0; i < c.getCitas().size(); i++){
				if(c.getCitas().get(i).getEmpleo().equals(empleo))
					c.getCitas().remove(i--);
			}
	}
	
	public void eliminarEmpleosEmpresa(Empresa empresa){
		for(int i = 0; i < empresa.getEmpleos().size(); i++)
			eliminarCitasDeUnEmpleo(empresa.getEmpleos().get(i));
		empresa.getEmpleos().clear();
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

	public void llenarCita(Cita cita){
		ArrayList<Candidato> cand = candiatosDisponibles(cita);
		for(int i = 0; i < cand.size(); i++)
			aggCitas(cita, cand.get(i));
	}
	
	public void citasDisponibles(Candidato candidato){
		
		for(Cita c : citas){
			if(candidato.esValido(c.getEmpleo()))
				if(candidato.disponible(c.getFecha()))
					aggCitas(c, candidato);
		}
	}
	
	private ArrayList<Candidato> buscarXNombre(String nombre){
		ArrayList<Candidato> encontrados = new ArrayList<Candidato>();
		nombre = nombre.toUpperCase();
		for(Candidato c : candidatos)
			if(c.getNombreBus().contains(nombre))
				encontrados.add(c);
			
		return encontrados;
	}
	
	private ArrayList<Candidato> buscarXCi(String ci){
		ArrayList<Candidato> encontrados = new ArrayList<Candidato>();
		
		for(Candidato c : candidatos)
			if(c.getCi().contains(ci))
				encontrados.add(c);
		
		return encontrados;
	}
	
	public ArrayList<Candidato> buscarCand(String cadena){
		ArrayList<Candidato> encontrados = null;
		boolean contieneLetras = false;
		boolean contieneNumeros = false;
		
		for(int i = 0; i < cadena.length() && !(contieneLetras && contieneNumeros); i++)
			if(Character.isAlphabetic(cadena.charAt(i)))
				contieneLetras = true;
			else if(Character.isDigit(cadena.charAt(i)))
				contieneNumeros = true;
			else
				throw new IllegalArgumentException("La cadena de busqueda no puede contener caracteres especiales");
		
		if(contieneLetras && contieneNumeros)
			throw new IllegalArgumentException("La cadena de busqueda no puede contener números y letras a la misma vez");
		else if(contieneLetras)
			encontrados = buscarXNombre(cadena);
		else if(contieneNumeros)
			encontrados = buscarXCi(cadena);
		
		return encontrados;
	}
	
	public ArrayList<Candidato> candiatosDisponibles(Cita cita){
		ArrayList<Candidato> disponible = new ArrayList<Candidato>();
		
		for(Candidato c :  candidatos)
			if(c.aptoEmpleo(cita))
				disponible.add(c);
		
		return disponible;
	}
	
	public boolean aggCitas(Cita cita, Candidato c){
		boolean agregado = true;
		ArrayList<Cita> citaC = c.getCitas();
		if(!(citaC.isEmpty())){
			for(int i = 0; i < citaC.size() && agregado; i++){
				if(citaC.get(i).getFecha().compareTo(cita.getFecha()) == 0)
					agregado = false;
			}
		}
		
		if(agregado){
			c.getCitas().add(cita);
			cita.getCandidatos().add(c);
		}
		
		return agregado;
	}
	
	//Logica Citas
	
	public void eliminarCandidaroCita(Cita cita, Candidato cand){
		cita.getCandidatos().remove(cand);
		cand.getCitas().remove(cita);
	}
	
	public void eliminarCita(Cita cita){
		citas.remove(cita);
		for(Candidato c : candidatos)
			c.getCitas().remove(cita);
	}
	
	public ArrayList<Empresa> empresasConEmpleos(){
		ArrayList<Empresa> ofertEmpleos = new ArrayList<Empresa>();
		for(Empresa e : empresas)
			if(!(e.getEmpleos().isEmpty()))
				ofertEmpleos.add(e);
		return ofertEmpleos;
	}
	
	
	//Reportes Candidatos
	
	public ArrayList<Candidato> candidatosMasLongevos(){
		ArrayList<Candidato> longevos = new ArrayList<Candidato>(candidatos);
		Collections.sort(longevos,new CompararCandPorEdad());
		return longevos;
	}
	
	public ArrayList<Candidato> candidatosMasCitas(){
		ArrayList<Candidato> Citass = new ArrayList<Candidato>(candidatos);
		Collections.sort(Citass,new CompararPorCitas());
		return Citass;
	}
}
