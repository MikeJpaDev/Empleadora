package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import logica.candidato.Candidato;
import logica.cita.Cita;
import logica.empleo.Empleo;
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

import sun.swing.SwingUtilities2.Section;

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
	
	@Test
	public void testCiVacio() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "                    ", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("Esta vacio el campo del carnet de identidad", e.getMessage());
		}
	}
	
	@Test
	public void testCiCaractEsp() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "040102*6325", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El carnet de identidad contiene caracteres no númericos", e.getMessage());
		}
	}
	
	@Test
	public void testCiLongInc() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "040102", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("La longitud del Carnet de Identidad no es correcta", e.getMessage());
		}
	}
	
	@Test
	public void testCiSeptimoNum() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El septimo dígito del Carnet de Identidad es incorrecto", e.getMessage());
		}
	}
	
	@Test
	public void testCiMesInc() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04220268763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("El mes del Carnet de Identidad es incorrecto", e.getMessage());
		}
	}
	
	@Test
	public void testCiDiasInc() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04023068763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("Los dias no coinciden con la duración del mes del Carnet de Identidad", e.getMessage());
		}
	}
	
	@Test
	public void testCiFechaMasActual() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "40010268763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("Fecha mayor que la actual en el Carnet de Identidad", e.getMessage());
		}
	}
	
	@Test
	public void testMenor18() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "24010268763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("Menor de 18 aÑos", e.getMessage());
		}
	}
	
	@Test
	public void testAniosNegativos() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266687", -5, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("Los años de Experiencia no pueden ser negativos", e.getMessage());
		}
	}
	
	@Test
	public void testAniosMayor() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 30, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("Los años de experiencia no pueden ser mayor que los años desde que se cumplio la mayoria de edad", e.getMessage());
		}
	}
	
	@Test
	public void testEspVacia() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "          ");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("La especialidad esta vacia", e.getMessage());
		}
	}
	
	@Test
	public void testEspEspaciosBlancos() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "     Conductor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("En la especialidad no deje espacios vacios al inicio o el fin", e.getMessage());
		}
	}
	
	@Test
	public void testEspEspaciosJuntos() {
		try{
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Condu      ctor");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("dos espacios en blanco juntos en especialidad", e.getMessage());
		}
	}
	
	@Test
	public void testGetEdad() {
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			assertEquals(20, (long)candidato.getEdad());
	}
	
	@Test
	public void testEmpleoValidoT() {
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			Empresa empresa = new Empresa("AguasHabana", "Santo Tomas", "76469895", Sector.TURISMO.toString());
			Empleo emp = new Empleo("Agua", "Turismo", 7500, empresa, Rama.CHOFER);
			
			assertEquals(true,  candidato.esValido(emp));
	}
	
	@Test
	public void testEmpleoValidoF() {
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			Empresa empresa = new Empresa("AguasHabana", "Santo Tomas", "76469895", Sector.SALUD.toString());
			Empleo emp = new Empleo("Agua", "Turismo", 7500, empresa, Rama.DIRECTIVO);
			
			assertEquals(false,  candidato.esValido(emp));
	}
	
	@Test
	public void testAnadirCita() {
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			Empresa empresa = new Empresa("AguasHabana", "Santo Tomas", "76469895", Sector.SALUD.toString());
			Empleo emp = new Empleo("Agua", "Turismo", 7500, empresa, Rama.CHOFER);
			Cita cita = new Cita(emp, LocalDate.of(2024, 10, 1));
			
			assertEquals(true, candidato.aggCitas(cita, candidato));
			
	}
	
	@Test
	public void testAnadirCitaF() {
			candidato = new Candidato("Miguel", "Primera Cerro", "76406698", "04010266358", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "Conductor");
			Empresa empresa = new Empresa("AguasHabana", "Santo Tomas", "76469895", Sector.SALUD.toString());
			Empleo emp = new Empleo("Agua", "Turismo", 7500, empresa, Rama.CHOFER);
			Cita cita = new Cita(emp, LocalDate.of(2024, 10, 1));
			Cita cita2 = new Cita(emp, LocalDate.of(2024, 10, 1));
			candidato.aggCitas(cita, candidato);
			
			assertEquals(false, candidato.aggCitas(cita2, candidato));
			
	}
}
