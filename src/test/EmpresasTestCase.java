package test;

import static org.junit.Assert.*;
import logica.Empleadora;
import logica.candidato.Candidato;
import logica.empresa.Empresa;
import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;
import logica.enums.Sector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpresasTestCase {

	private Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando Pruebas Empresa");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finalizando Pruebas Empresa");
	}

	@Test
	public void testAgregarEmpresaNueva() {
		boolean resultado = Empleadora.getInstancia().agEmpresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
		assertTrue("La empresa debería ser agregada correctamente.", resultado);
	}

	@Test
	public void testAgregarEmpresaExistente() {
		Empleadora.getInstancia().agEmpresa("Habana", "Calle 17", "76641174", Sector.EDUCACION.toString());
		try{
			Empleadora.getInstancia().agEmpresa("Habana", "Calle 17", "76641174", Sector.EDUCACION.toString());
			fail("Cuidao");
		}
		catch(IllegalArgumentException e){
			assertEquals("Ya existe la empresa", e.getMessage());
		}
	}

	@Test
	public void testNombreVacio(){
		try{
			empresa = new Empresa("", "Calle 17", "55065148", "SALUD");
			fail("Nombre Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direccion esta vacio", e.getMessage());
		}
	}

	@Test
	public void testNombreEmpiezaEspacio(){
		try{
			empresa = new Empresa(" Habana", "Calle 17", "55065148", "SALUD");
			fail("Nombre Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direcion no debe comenzar con espacios", e.getMessage());
		}
	}

	@Test
	public void testDirVacia(){
		try{
			empresa = new Empresa("HabanaNoticias", "", "55065148", "SALUD");
			fail("Direccion Vacia");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direccion esta vacio", e.getMessage());
		}
	}

	@Test
	public void testDirEmpiezaEspacio(){
		try{
			empresa = new Empresa("HabanaNoticias", " Calle 17", "55065148", "SALUD");
			fail("Direccion Vacia");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direcion no debe comenzar con espacios", e.getMessage());
		}
	}

	@Test
	public void testDirTerminaEspacio(){
		try{
			empresa = new Empresa("HabanaNoticias", "Calle 17 ", "55065148", "SALUD");
			fail("Direccion Vacia");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direccion no debe terminar en espacio", e.getMessage());
		}
	}

	@Test
	public void testNombreMuchosEspacios(){
		try{
			empresa = new Empresa("   HabanaNoticias    ", "Calle 17", "55065148", "SALUD");
			fail("Espacios Juntos");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direcion no debe comenzar con espacios", e.getMessage());
		}
	}

	@Test
	public void testNombreTerminaEspacio(){
		try{
			empresa = new Empresa("HabanaNoticias ", "Calle 17", "55065148", "SALUD");
			fail("Termina en Espacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre o direccion no debe terminar en espacio", e.getMessage());
		}
	}
	
	@Test
	public void testNombreEspaciosIntermedios(){
		try{
			empresa = new Empresa("Habana  Noticias", "Calle 17", "55065148", "SALUD");
			fail("Espacios Juntos");
		}
		catch(IllegalArgumentException e){
			assertEquals("Espacios Juntos", e.getMessage());
		}
	}
	
	@Test
	public void testDirEspaciosIntermedios(){
		try{
			empresa = new Empresa("HabanaNoticias", "Calle  17", "55065148", "SALUD");
			fail("Espacios Juntos");
		}
		catch(IllegalArgumentException e){
			assertEquals("Espacios Juntos", e.getMessage());
		}
	}



	@Test
	public void testIdEmpleoVacio(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("", Rama.EJECUTIVO.toString(), 5866d, empresa, Rama.CHOFER);
			fail("Id de empleo Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("Hay un campo vacio", e.getMessage());
		}
	}
	
	@Test
	public void testIdEmpleoEspaciosIntermedios(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("Secre  tario", Rama.EJECUTIVO.toString(), 5866d, empresa, Rama.CHOFER);
			fail("Espacios Juntos");
		}
		catch(IllegalArgumentException e){
			assertEquals("Espacios Juntos", e.getMessage());
		}
	}
	
	@Test
	public void testRamaEmpleoEspaciosIntermedios(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("Secretario", "EJE  CUTIVO", 5866d, empresa, Rama.CHOFER);
			fail("Espacios Juntos");
		}
		catch(IllegalArgumentException e){
			assertEquals("Espacios Juntos", e.getMessage());
		}
	}

	@Test
	public void testSectorEmpleoVacio(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("Secretario", "", 5866d, empresa, Rama.CHOFER);
			fail("Sector de empleo Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("Hay un campo vacio", e.getMessage());
		}
	}

	@Test
	public void testEmpOEmpleoVacio(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("Secretario", Rama.CHOFER.toString(), 5866d, null, Rama.CHOFER);
			fail("Empresa Ofertante Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("Empresa ofertante null", e.getMessage());
		}
	}

	@Test
	public void testSalEmpleoNoValido(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("Secretario", Rama.CHOFER.toString(), -5866d, empresa, Rama.CHOFER);
			fail("Salrio no valido");
		}
		catch(IllegalArgumentException e){
			assertEquals("Salario no valido", e.getMessage());
		}
	}

	@Test
	public void testRamaEmpleoNoValido(){
		try{
			empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
			empresa.agEmpleo("Secretario", Rama.CHOFER.toString(), 5866d, empresa, null);
			fail("Rama de empleo no valido");
		}
		catch(IllegalArgumentException e){
			assertEquals("Rama de empleo vacia", e.getMessage());
		}
	}

	@Test
	public void testAgregarEmpleo(){
		empresa = new Empresa("HabanaCuba", "Calle 17", "76641174", Sector.EDUCACION.toString());
		boolean dime = empresa.agEmpleo("Secretario", Rama.CHOFER.toString(), 5866d, empresa, Rama.CHOFER);
		assertTrue(dime);
	}
	
	

}
