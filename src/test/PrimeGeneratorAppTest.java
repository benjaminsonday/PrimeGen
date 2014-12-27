package test;

import main.PrimeGeneratorApp;
import main.prime_tester.FermatPrimeTest;

import org.junit.Assert;
import org.junit.Test;

public class PrimeGeneratorAppTest {
	@Test
	public void testingNewPrimeNumberGreaterThan() throws Exception {
		Assert.assertTrue(PrimeGeneratorApp.generatePrimeGreaterThan(7793, FermatPrimeTest.class) == 7817L);
		Assert.assertTrue(PrimeGeneratorApp.generatePrimeGreaterThan(35267, FermatPrimeTest.class) == 35279L);
		Assert.assertTrue(PrimeGeneratorApp.generatePrimeGreaterThan(5863513, FermatPrimeTest.class) == 5863519L);
		Assert.assertTrue(PrimeGeneratorApp.generatePrimeGreaterThan(15485711, FermatPrimeTest.class) == 15485737L);
	}
}
