package frgp.utn.edu.ar.test;

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

}
