package main;

import main.prime_tester.PrimeTester;

public class PrimeGeneratorApp {
	
	public static long generatePrimeGreaterThan(long x, Class<? extends PrimeTester> testerClass) throws Exception {
		long currentAttempt = x + 1;
		while(true) {
			if(PrimeTester.makeInstance(testerClass, currentAttempt).testIfPrime())
				break;
			currentAttempt += 1;
		}
		return currentAttempt;
	}

	public static void main(String[] args) throws Exception {
		long primeMustBeGT = Long.parseLong(args[0]);
		long prime = generatePrimeGreaterThan(primeMustBeGT, Class.forName(args[1]).asSubclass(PrimeTester.class));
		System.out.println(prime);
	}
	
}
