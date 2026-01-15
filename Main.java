import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Call StringBufferExample
        // StringBufferExample st = new StringBufferExample();
        // st.Run(args);
        // Call StringBufferExample
        // StringBuilderExample stB = new StringBuilderExample();
        // stB.Run(args);
        // GrassH gh = new GrassH();
        // gh.Run(null);

        // KProblemPriorityQueue kp = new KProblemPriorityQueue();
        // kp.Run(null);

        // Call VolatileExample
        VolatileExample ve = new VolatileExample();
        ve.Run(null);

        NonStaticVarStaticClassExample ns = new NonStaticVarStaticClassExample();
        ns.Method1();
        // ListRangeExample lre = new ListRangeExample();
        // lre.Run(null);
    }
}



