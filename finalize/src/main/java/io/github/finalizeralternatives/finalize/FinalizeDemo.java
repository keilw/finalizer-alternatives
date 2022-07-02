package io.github.finalizeralternatives.finalize;

public class FinalizeDemo {

	protected void finalize() throws Throwable {
		try {
			System.out.println(String.format("In finalize() Methode der %s Klasse.", getClass().getSimpleName()));
		} catch (Throwable e) {

			throw e;
		} finally {
			System.out.println("Rufe finalize() Methode der Object Klasse auf...");
			// Calling finalize() of Object class
			super.finalize();
		}
	}

	public static void main(String[] args) throws Throwable {

		// Creating demo's object
		FinalizeDemo d = new FinalizeDemo();

		// Calling finalize of demo
		d.finalize();
	}
}