package io.github.finalizeralternatives.cleaner;

public class CleanerBeispiel {
	  public static void main(final String[] args) throws Exception {
	    
	    //1 Automatische Reinigung
		System.out.println("Automatische Reinigung");
	    try (final TatortKlasse tatortInstanz 
	           = new TatortKlasse()) {
	      // Tat begehen
	      tatortInstanz.eineTat();
	      tatortInstanz.nochEineTat();
	    }
	    
	    System.out.println();
	    
	    //2 Explizite Reinigung
	    System.out.println("Explizite Reinigung");
	    final TatortKlasse tatortInstanz = new TatortKlasse();
	    tatortInstanz.eineTat();
	    tatortInstanz.nochEineTat();
	    tatortInstanz.close();
	  }
	}