package test;

import static org.junit.Assert.*;
import logica.candidato.Candidato;
import logica.enums.Genero;
import logica.enums.NivelEscolar;
import logica.enums.Rama;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CandidatoTestCase {
	
	private Candidato candidato;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando Pruebas Candidato");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finalizando Preubas Candidato");
	}

	@Test
	public void testNombreVacio() {
		try{
			candidato = new Candidato("", "Vedado", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("esta vacio el nombre", e.getMessage());
		}
	}
	
	@Test
	public void testNombreEnBlanco(){
		try{
			candidato = new Candidato("        Miguel      ", "Vedado", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("No deje espacios en blanco al principio o al final", e.getMessage());
		}
	}

	@Test
	public void testNombreEspaciosBlancoJuntos() {
		try{
			candidato = new Candidato("Miguel    Angel", "Vedado", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("dos espacios en blanco juntos", e.getMessage());
		}
	}
	
	@Test
	public void testNombreCaracteresEspeciales() {
		try{
			candidato = new Candidato("Miguel *****", "Vedado", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El nombre contiene caracteres no validos", e.getMessage());
		}
	}
	
	@Test
	public void testDirecVacia() {
		try{
			candidato = new Candidato("Miguel", "    ", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("esta vacia la direccion", e.getMessage());
		}
	}
	
	@Test
	public void testDirEspaciosBlancos() {
		try{
			candidato = new Candidato("Miguel", "       Vedado        ", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("No deje espacios en blanco al principio o al final", e.getMessage());
		}
	}
	
	@Test
	public void testDirecEspaciosJuntos() {
		try{
			candidato = new Candidato("Miguel", "Primera       Cerro", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("dos espacios en blanco juntos", e.getMessage());
		}
	}
	
	@Test
	public void testTelVacio() {
		try{
			candidato = new Candidato("Miguel", "Vedado", "       ", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El telefono esta vacio", e.getMessage());
		}
	}
	
	@Test
	public void testTelNoNum() {
		try{
			candidato = new Candidato("Miguel", "Vedado", "7640****", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El telefono contiene caracteres no numericos", e.getMessage());
		}
	}
	
	@Test
	public void testTelMayor12() {
		try{
			candidato = new Candidato("Miguel", "Vedado", "764000600000000003", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("La cantidad de digitos del telefono tiene que ser menor que 12", e.getMessage());
		}
	}
	
	@Test
	public void testTelMenos8() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "764", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("La cantidad de digitos del telefono tiene que ser mayor que 8", e.getMessage());
		}
	}
	
	@Test
	public void testTelCerosIzq() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "00000764", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El numero de teléfono no puede tener muchos 0 a la izquierda", e.getMessage());
		}
	}
}
