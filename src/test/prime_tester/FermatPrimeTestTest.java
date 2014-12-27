package test.prime_tester;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import main.prime_tester.FermatPrimeTest;

import org.junit.Assert;
import org.junit.Test;

public class FermatPrimeTestTest {
	
	@Test
	public void binaryExpansionOfOne() {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(0);
		Assert.assertTrue(FermatPrimeTest.binaryExpansion(1L).equals(set));
	}
	
	@Test
	public void binaryExpansionOf65() {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(6);
		set.add(0);
		Assert.assertTrue(FermatPrimeTest.binaryExpansion(65L).equals(set));
	}
	
	@Test
	public void powersCacheFor65() {
		Map<Integer, Long> cache = FermatPrimeTest.getPowersCache(4, 9, 31); // 4 ^ 9 mod 31
		// should compute power 1, 2, 4, and 8
		Map<Integer, Long> expectedCache = new HashMap<Integer, Long>();
		expectedCache.put(0, 4L);
		expectedCache.put(1, 16L);
		expectedCache.put(2, (long) 256 % 31);
		expectedCache.put(3, (long) (256 * 256) % 31);
		Assert.assertTrue(expectedCache.equals(cache));
	}
	
	@Test
	public void power() {
		Assert.assertTrue(FermatPrimeTest.power(4, 9, 31) == (long) (256 * 256 * 4) % 31);
	}
	
	@Test
	public void testing31Prime() {
		FermatPrimeTest fpt = new FermatPrimeTest(31);
		Assert.assertTrue(fpt.testIfPrime());
	}
	
	@Test
	public void testing17Times31NotPrime() {
		FermatPrimeTest fpt = new FermatPrimeTest(17 * 31);
		Assert.assertTrue(!fpt.testIfPrime());
	}

}
