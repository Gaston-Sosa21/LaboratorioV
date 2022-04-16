package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	private int cantElementos = 5;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(cantElementos);

	@Test // 3.a.
	public void agregarElementoTest() {

		matriz.agregarElemento(1, 3);
		boolean res = matriz.existeElemento(1, 3);
		assertEquals(true, res,"agregarElementoTest: Elemento agregado.");
	}

	@Test // 3.b.
	public void agregarElementoSimetriaTest() {
		boolean res;
		matriz.agregarElemento(1, 3);
		res = matriz.existeElemento(3, 1) == matriz.existeElemento(1, 3) ? true : false;
		assertEquals(true, res,"agregarElementoSimetriaTest: agregado en su posicion simetrica.");
	}

	@Test // 3.c
	public void eliminarElementoTest() {
		boolean res;
		matriz.eliminarElemento(1, 3);
		res = matriz.existeElemento(1, 3);
		assertFalse(res,"eliminarElementoTest: elemento eliminado.");
	}

	@Test // 3.d
	public void eliminarElementoSimetricoTest() {
		boolean res;
		matriz.eliminarElemento(1, 3);
		res= (matriz.existeElemento(1, 3) == matriz.existeElemento(3, 1)) ? false : true;
		assertFalse(res,"eliminarElementoSimetricoTest: elemento simetrico eliminado.");
	}

	@Test // 3.e
	public void contarRelacionesTest() {

		boolean res = matriz.getCantidadRelaciones() < 0 ? false : true;
		assertTrue(res,"contarRelacionesTest: cantidad de relaciones correctas.");
	}

	@Test // 3.f.
	public void existenTodosLosElementoTest() {

		int cantRel = matriz.getCantidadRelaciones();
		int cantElem = matriz.CantSimetricos();
	    boolean res = cantRel * 2 != cantElem ? false : true;		
		assertTrue(res,"existenTodosLosElementoTest: elementos y relaciones agregados correctamente.");
	}

	@Test // 3.g.
	public void agregarElementoFilaNegativaTest() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, 0),"agregarElementoFilaNegativaTest: excepcion de agregado en fila negativa correcto.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, cantElementos - 1),"agregarElementoFilaNegativaTest: excepcion de agregado en fila negativa correcto.");

	}

	@Test // 3.h.
	public void agregarElementoColumnaNegativaTest() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(0, -1),"agregarElementoFilaNegativaTest: excepcion de agregado en columna negativa correcto.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos - 1, -1),"agregarElementoFilaNegativaTest: excepcion de agregado en columna negativa correcto.");

	}

	@Test // 3.i.
	public void agregarElementoFueraRangoTest() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos, cantElementos),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos, 0),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(0, cantElementos),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos, -1),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, cantElementos),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(0, -1),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, 0),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, -1),"agregarElementoFueraRangoTest: elemento fuera de rango no agregado.");

	}	

}
