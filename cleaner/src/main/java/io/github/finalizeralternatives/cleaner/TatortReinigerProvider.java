package io.github.finalizeralternatives.cleaner;

import java.lang.ref.Cleaner;

public class TatortReinigerProvider {
	  private static final Cleaner SCHOTTY = Cleaner.create();    
	  
	  public static Cleaner getReiniger() {
	    return SCHOTTY;
	  }
}
