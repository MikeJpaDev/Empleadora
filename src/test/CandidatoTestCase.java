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
		System.out.println("Iniciando Pruebas");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Finalizando Preubas");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNombreVacio() {
		try{
			candidato = new Candidato("", "asdads", "76400063", "04010298763", 0, Genero.MASCULINO, NivelEscolar.BACHILLER, Rama.CHOFER, "asdasd");
			fail("El Codigo no debe llegar aqui");
		}
		catch(IllegalArgumentException e){
			assertEquals("esta vacio el nombre", e.getMessage());
		}
	}

}
