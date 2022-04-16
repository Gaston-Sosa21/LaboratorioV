package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

class MatrizAdyacenciaTest {

	private int cantElementos = 5;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(cantElementos);

	@Test //3.a.
	public void agregarElementoTest() {

		matriz.agregarElemento(1, 3);
		boolean res = matriz.existeElemento(1, 3);
		assertEquals(true, res);
	}

	@Test //3.b.
	public void agregarElementoSimetriaTest() {
		boolean res;
		matriz.agregarElemento(1, 3);

		if (matriz.existeElemento(3, 1) == matriz.existeElemento(1, 3)) {
			res = true;
		} else {
			res = false;
		}

		assertEquals(true, res);
	}

	@Test //3.c
	public void eliminarElementoTest() {
		boolean res;

		matriz.eliminarElemento(1, 3);

		res = matriz.existeElemento(1, 3);

		assertFalse(res);
	}

	@Test //3.d
	public void eliminarElementoSimetricoTest() {
		boolean res;

		matriz.eliminarElemento(1, 3);

		if (matriz.existeElemento(1, 3) == matriz.existeElemento(3, 1)) {
			res = false;
		} else {
			res = true;
		}

		assertFalse(res);
	}
	
	// TODO 3.e
	// TODO 3.f

	@Test // 3.g.
	public void agregarElementoFilaNegativaTest() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, 0));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, cantElementos - 1));

	}

	@Test // 3.h.
	public void agregarElementoColumnaNegativaTest() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(0, -1));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos - 1, -1));

	}

	@Test // 3.i.
	public void agregarElementoFueraRangoTest() {

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos, cantElementos));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos, 0));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(0, cantElementos));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(cantElementos, -1));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, cantElementos));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(0, -1));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, 0));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matriz.agregarElemento(-1, -1));

	}
}
