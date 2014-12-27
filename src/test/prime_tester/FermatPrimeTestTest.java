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
		HashSet<Long> set = new HashSet<Long>();
		set.add(0L);
		Assert.assertTrue(FermatPrimeTest.binaryExpansion(1L).equals(set));
	}
	
	@Test
	public void binaryExpansionOf65() {
		HashSet<Long> set = new HashSet<Long>();
		set.add(6L);
		set.add(0L);
		Assert.assertTrue(FermatPrimeTest.binaryExpansion(65L).equals(set));
	}
	
	@Test
	public void powersCacheFor65() {
		Map<Long, Long> cache = FermatPrimeTest.getPowersCache(4, 9, 31); // 4 ^ 9 mod 31
		// should compute power 1, 2, 4, and 8
		Map<Long, Long> expectedCache = new HashMap<Long, Long>();
		expectedCache.put(0L, 4L);
		expectedCache.put(1L, 16L);
		expectedCache.put(2L, (long) 256 % 31);
		expectedCache.put(3L, (long) (256 * 256) % 31);
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
