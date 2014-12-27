package main;

import main.prime_tester.FermatPrimeTest;
import main.prime_tester.PrimeTester;

public class PrimeGeneratorApp {
	
	public static long generatePrimeGreaterThan(long x, Class<? extends PrimeTester> testerClass) {
		long currentAttempt = x + 1;
		while(true) {
			// quick, hacky optimization
			if(currentAttempt % 2 != 0 && currentAttempt % 3 != 0 && currentAttempt % 5 != 0 && currentAttempt % 7 != 0) {
				try {
					PrimeTester tester = PrimeTester.makeInstance(testerClass, currentAttempt);
					if(tester.testIfPrime())
						break;
				} catch (Exception e) {
					throw new IllegalArgumentException(e);
				}
			}
			currentAttempt += 1;
		}
		return currentAttempt;
	}

	public static void main(String[] args) {
		long primeMustBeGT = Long.parseLong(args[0]);
		long prime = generatePrimeGreaterThan(primeMustBeGT, FermatPrimeTest.class);
		System.out.println(prime);
	}
	
}
