package io.github.finalizeralternatives.cleaner;

import java.lang.ref.Cleaner;

public class TatortKlasse implements AutoCloseable {
	  
	  private final Cleaner cleaner = TatortReinigerProvider.getReiniger();
	  private final Cleaner.Cleanable cleanable;

	  // Dieser Tatort muss nach der Tat gereinigt werden
	  private final Tatort tatort;

	  public TatortKlasse() {
	    this.tatort = new Tatort();
	    this.cleanable = cleaner.register(this, reinigeTatort(tatort));
	  }
	  
	  public void eineTat() {
	    // Besuche den Tatort
	    System.out.println("Am ersten Tatort");
	  }
	  
	  public void nochEineTat() {
		// Besuche den Tatort
	    System.out.println("Am zweiten Tatort");
	  }

	  @Override
	  public void close() throws Exception {
	    cleanable.clean();
	  }

	  private static Runnable reinigeTatort(final Tatort tatort) {
	    return () -> {
	      // Führe die Reinigung durch
	      System.out.println("Tatorte gereinigt !!");
	    };
	  }
	}