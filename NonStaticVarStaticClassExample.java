public class NonStaticVarStaticClassExample {
  
    int a =10;

    public static void Method1()
    {  // a = 15; // Cannot make a static reference to the non-static field a
        NonStaticVarStaticClassExample obj = new NonStaticVarStaticClassExample();
        obj.a = 20;
        System.out.println("Value of a is: " + obj.a);
    }
    
}