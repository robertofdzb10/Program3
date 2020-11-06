package pruebas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import clase.FuncionParaTest;

@RunWith(value = Parameterized.class)
public class TestFuncionParaTest {

	private int a, exp;
	
	@Parameters
	public static Iterable<Object[]> getData(){
		return Arrays.asList(new Object [][] {
			{0,1} , {1,1} , {2,2} , {3,6} , {4,24} , {5,120} , {6,720} , {7,5040} , {8,	40320} , {9,362880} , {10,3628800} , {11,39916800} , {12,479001600} 
		});
	}
	
	public TestFuncionParaTest(int a, int exp) {
		this.a =a;
		this.exp = exp;
	}
	
	@Test
	public void testFactorial() {
		FuncionParaTest fac = new FuncionParaTest();
		int result = fac.factorial(a);
		assertEquals(exp, result);
	}
}
