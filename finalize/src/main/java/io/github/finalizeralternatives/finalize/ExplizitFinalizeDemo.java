package io.github.finalizeralternatives.finalize;

public class ExplizitFinalizeDemo
{
    public static void main(String[] args) 
    {
        @SuppressWarnings("unused")
		ExplizitFinalizeDemo demo1 = new ExplizitFinalizeDemo();
        ExplizitFinalizeDemo demo2 = new ExplizitFinalizeDemo();
        demo1 = null;
        demo2.finalize(); // Explicit call to finalize method
        System.out.println("Garbage collector aufgerufen");
        System.gc(); //Implicit call to finalize() method
        
        
    }
    
    @Override
    protected void finalize()
    {
        System.out.println("finalize() Methode wird aufgerufen");
    }
}