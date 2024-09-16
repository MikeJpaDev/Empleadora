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
        boolean resultado =Empleadora.getInstancia().agEmpresa("Habana", "Calle 17", "76641174", Sector.EDUCACION.toString());
        assertFalse("La empresa no debería ser agregada porque ya existe.", resultado);
    }
    
    @Test
    public void testNombreVacio(){
    	try{
			empresa = new Empresa("", "Calle 17", "55065148", "SALUD");
			fail("Nombre Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("esta vacio el nombre", e.getMessage());
		}
    }
    
    @Test
    public void testDirVacia(){
    	try{
			empresa = new Empresa("HabanaNoticias", "", "55065148", "SALUD");
			fail("Direccion Vacia");
		}
		catch(IllegalArgumentException e){
			assertEquals("esta vacio la direccion", e.getMessage());
		}
    }
    
    @Test
    public void testTelVacio(){
    	try{
			empresa = new Empresa("HabnaNoticiario", "Calle 17", "", "SALUD");
			fail("Telefono Vacio");
		}
		catch(IllegalArgumentException e){
			assertEquals("esta vacio el telefono", e.getMessage());
		}
    }
    
    
    
    
    
}
