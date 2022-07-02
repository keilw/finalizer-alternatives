package io.github.finalizeralternatives.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PersonRefBeispiel {

    public static void main(String[] args) {
        try {
            Person person = new Person();
            ReferenceQueue<Person> queue = new ReferenceQueue<Person>();
            @SuppressWarnings("unused")
			PhantomReference<Person> phantomRefPerson = new PhantomReference<>(person, queue);

            // at this point object have one strong and one phantom reference, invoke Garbage collector
            System.gc();
            
            System.out.println("GC aufgerufen, als noch starke Referenz vorhanden");
            Reference<? extends Person> ref = queue.poll();
            if (ref == null) {
                System.out.println("Objekt ist noch am Leben");
            } else {
                System.out.println("Objekt ist tot");
            }

            System.out.println("         ***************         ");
            // remove strong reference
            person = null;
            
            // at this point, Object is only phantom referenced
            System.gc();
            
            System.out.println("GC aufgerufen, als nur noch PHANTOM Referenz vorhanden");
            ref = queue.poll();
            if(ref == null) {
                System.out.println("Objekt ist noch am Leben");
            }else {
                System.out.println("Objekt ist tot");
                
                // Do the cleanup as required
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}