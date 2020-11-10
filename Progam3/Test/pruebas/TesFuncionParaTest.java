package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.FuncionParaTest;

public class TesFuncionParaTest {
	
	@Before
	public void setUp() throws Exception{}
	
	@After
	public void tearDown() throws Exception{}
	
	@Test //Sino tine eso no se lanza la prueba
	public void testFactorialNegativo() {
		try {
			FuncionParaTest.factorial(-1);
			FuncionParaTest.factorial(Integer.MIN_VALUE);//El valor negativo más pequeño que entra en un int
			fail("Excepción no lanzada");
		} catch(ArithmeticException e){
			//Sino es error no hay que indicarlo
			System.out.println("Hola");
			}
	}
	
	@Test (expected = ArithmeticException.class) //Esperamos esa excepción
	public void testFactorialNegativo2() {
		FuncionParaTest.factorial(-1);
	}
	
	@Test (expected = ArithmeticException.class)
	public void testFactorialNoCabeInt(){
		System.out.println(FuncionParaTest.factorial(13));
	}
		
	@Test//Los test son independientes, puede ejecutarse el 2 antes que el uno.
	public void test() {
		int[]y = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
		for (int x=0; x<=12; x++) {
			System.out.println(x);//Así podemos ver en que "x" falla.
			assertEquals("Error de factorial",y[x],FuncionParaTest.factorial(x));
		}
	}
	


}
