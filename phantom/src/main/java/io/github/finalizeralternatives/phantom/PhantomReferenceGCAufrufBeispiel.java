package io.github.finalizeralternatives.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Dies ist ein Beispiel für die Nutzung von {@link PhantomReference} mit explizigem GC Aufruf
 * @author Werner
 *
 */
public class PhantomReferenceGCAufrufBeispiel {

    public static void main(String[] args) {
        try {
            Person person = new Person();
            ReferenceQueue<Person> queue = new ReferenceQueue<Person>();
            @SuppressWarnings("unused")
			PhantomReference<Person> phantomRefPerson = new PhantomReference<>(person, queue);

            // Aufruf des GC als wir noch Starke und Phantom Referenzeen haben
            System.gc();
            
            System.out.println("System.gc() aufgerufen, als noch starke Referenz vorhanden");
            Reference<? extends Person> ref = queue.poll();
            if (ref == null) {
                System.out.println("Objekt ist noch am Leben");
            } else {
                System.out.println("Objekt ist tot");
            }

            System.out.println("         ***************         ");
            // Starke Referenz entfernt
            person = null;
            
            // Ab jetzt ist nur noch die Phantom Referenz vorhanden
            System.gc();
            
            System.out.println("System.gc() aufgerufen, als nur noch PHANTOM Referenz vorhanden");
            ref = queue.poll();
            if(ref == null) {
                System.out.println("Objekt ist noch am Leben");
            }else {
                System.out.println("Objekt ist tot");
                
                // Cleanup wo erforderlich
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}