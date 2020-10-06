package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsStringTest {

	@Test
	public void testquitarTabsYSaltosLinea() {
		String prueba = "Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.";
		assertEquals("Hol...", UtilsString.wrapString(prueba, 3));
		assertEquals("Hola...", UtilsString.wrapString(prueba, 4));
		assertEquals("Hola\nE...", UtilsString.wrapString(prueba, 6));
		assertEquals("Hola\nEsto es un string con tres líneas\ny\tvarios\ttabuladores.", UtilsString.wrapString(prueba, 63));
	}

}
