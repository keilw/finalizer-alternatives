package io.github.finalizeralternatives.finalize;

import java.io.*;

public class MeinFileReader {
	private BufferedReader reader;

	public MeinFileReader() throws FileNotFoundException {
		final InputStream input = MeinFileReader.class.getResourceAsStream("/TextFile.txt");
		this.reader = new BufferedReader(new InputStreamReader(input));
	}

	public int readLines() throws IOException {
		int lines = 0;
		@SuppressWarnings("unused")
		String line;
		while ((line = reader.readLine()) != null) {
			// process the line.
			lines++;
		}
		return lines;
	}
	
	@Override
	protected void finalize() throws Throwable {
		try {
			System.out.println("Rufe die finalize() Methode auf...");
	        reader.close();
	       
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) throws Throwable {
		MeinFileReader reader = new MeinFileReader();
		int zeilen = reader.readLines();
		System.out.println(String.format("%s Zeilen gelesen.", zeilen));
		reader = null;
		System.out.println("Rufe System.gc() auf...");
		System.gc();
	}

}