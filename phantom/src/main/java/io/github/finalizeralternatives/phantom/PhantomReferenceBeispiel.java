package io.github.finalizeralternatives.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceBeispiel {
	public static void main(String[] args) throws InterruptedException {
	    String value = new String("Mein String");
	    ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
	    PhantomReference<String> phantomReference = new PhantomReference<String>(value, referenceQueue);

	    System.out.println("Der Wert: "+ value);	    
	    System.out.println("Referenz Queue Poll: " + referenceQueue.poll());
	    value = null;
	    System.out.println("Den Wert auf null setzen");
	    // Eine Loop um die Garbage Collection zu provozieren 
	    for (int i = 1; i <= 10000; i++) {
			String[] dummyString = new String[1000];
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	    System.out.println("Der Wert ist : "+ value);
	    //Nun ist der Wert im referenceObject gelandet
	    @SuppressWarnings("rawtypes")
		Reference reference = referenceQueue.poll();
	    System.out.println("Abgerufene Referenz: "+ reference);
	    if (reference != null && phantomReference == reference) {          
	        System.out.println("Unser Objekt wurde Garbage Collected ....");
	      }
	}
}