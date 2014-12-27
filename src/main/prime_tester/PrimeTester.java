package main.prime_tester;

public abstract class PrimeTester {

	abstract public boolean testIfPrime();
	
	public static PrimeTester makeInstance(Class<? extends PrimeTester> clazz, long numToTest) throws Exception {
		return clazz.getConstructor(Long.TYPE).newInstance(numToTest);
	}

}
