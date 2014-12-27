package main.prime_tester;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Probablistically tests if a number is prime using the good ol'
 * Fermat prime test (it isn't optimal, but it's easy to code up).
 */
public class FermatPrimeTest extends PrimeTester {
	
	private final long number;
	private final int numNumsToTry;
	
	/**
	 * By default, do this many tests to check that the number is prime.
	 */
	private static final int DEFAULT_NUM_NUMS_TO_TRY = 1000;
	
	private FermatPrimeTest(long number, int numNumsToTry) {
		this.number = number;
		this.numNumsToTry = numNumsToTry;
	}
		
	public FermatPrimeTest(long numToTest) {
		this(numToTest, DEFAULT_NUM_NUMS_TO_TRY);
	}
	
	// Map from 0 -> a ^ (2 ^ 0) -> a, 1 -> a ^ (2 ^ 1) -> a^2, 2 -> a ^ (2 ^ 2) == a^4, ...
	public static Map<Integer, Long> getPowersCache(long a, long n, long number) {
		int currentHighestPower = 1;
		int currentLogOfTwo = 0;
		// from power p -> a^p
		Map<Integer, Long> powersCache = new HashMap<Integer, Long>();
		powersCache.put(0, a);
		while(currentHighestPower * 2 < n) {
			long valToSquare = powersCache.get(currentLogOfTwo);
			currentHighestPower *= 2;
			currentLogOfTwo += 1;
			powersCache.put(currentLogOfTwo, (valToSquare * valToSquare) % number);
			
		}
		return powersCache;
	}

	// E.g, Set(0, 3) is for 2^0 + 2^3 = 9
	public static Set<Integer> binaryExpansion(long x) {
		if(x <= 0) throw new IllegalArgumentException(x + " <= 0");
		
		String exp = Long.toBinaryString(x);
		Set<Integer> binaryExpansion = new HashSet<Integer>();
		int idx = 0;
		while(idx < exp.length()) {
			if(exp.charAt(exp.length() - idx - 1) == '1') binaryExpansion.add(idx);
			idx++;
		}
		return binaryExpansion;
	}
	
	// Computes a ^ n % number
	public static long power(long a, long n, long number) {
		Map<Integer, Long> powersCache = getPowersCache(a, n, number);
		Set<Integer> binaryExpansion = binaryExpansion(n);
		
		long currentProduct = 1L;
		for(Integer entry : binaryExpansion) {
			currentProduct = (currentProduct * powersCache.get(entry)) % number; 
		}
		
		return currentProduct;
	}

	@Override
	public boolean testIfPrime() {
		for(int i = 0; i < numNumsToTry; ++i) {
			long randomNumber = (long) (Math.random() * number);
			if(randomNumber == 0)
				continue;
			// a ^ (p - 1) should equal 1
			long result = power(randomNumber, number - 1, number);
			if(result != 1L) return false;
		}
		
		return true;
	}

}
