package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	private MatrizAdyacencia matriz = new MatrizAdyacencia(5);
	
	@Test
	public void agregarElementoTest() {
		
		matriz.agregarElemento(1, 3);
		boolean res = matriz.existeElemento(1, 3);
		assertEquals(true, res);
	}
	
	
	@Test
	public void agregarElementoSimetriaTest() {
		boolean res ;
		matriz.agregarElemento(1, 3);
		
		if (matriz.existeElemento(3, 1) == matriz.existeElemento(1, 3)) {
			res = true;
		}
		else {
			res = false;
		}
		
		assertEquals(true, res);
	}

	@Test
	public void eliminarElementoTest()
	{
		boolean res;
		
		matriz.eliminarElemento(1, 3);
		
		res = matriz.existeElemento(1, 3);
		
		assertFalse(res);
	}
	
	@Test
	public void eliminarElementoSimetricoTest()
	{
		boolean res;
		
		matriz.eliminarElemento(1, 3);
		
		if (matriz.existeElemento(1, 3)==matriz.existeElemento(3, 1)) 
		{
			res=false;
		}
		else 
		{
			res=true;
		}
		
		assertFalse(res);
	}
	
	@Test
	public void contarRelacionesTest() {
		
		boolean res=true;
		
		int cantRel = matriz.getCantidadRelaciones();
		
		if(cantRel < 0) {
			res=false;
		}
		
		assertTrue(res);
	}
	
	@Test
	public void existenTodosLosElementoTest() {
		
		boolean res=true;
		
		int cantRel = matriz.getCantidadRelaciones();
		int cantElem= matriz.CantSimetricos();
		
		if(cantRel*2 != cantElem) {
			res=false;
		}
		assertTrue(res);
	}
	
	@Test
	public void agregarElementoFilaNegativaTest() {
		
		boolean res=true;
	    int valorA= -1;
	    int valorB= -5;
		
	    if(valorA < 0 || valorB<0) {
	    	res=false;
	    }else {
			matriz.agregarElemento(valorA, valorB);
	    }
	
	    assertFalse(res);
	}
	
}



