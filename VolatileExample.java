import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class VolatileExample {
    // Only guarantees visibility, not atomic operations
    private volatile int count = 0;

    // AtomicReference <String> atomicString = new AtomicReference<>("Initial");

    // public getAtomicString() {
    //     return atomicString.get();
    // }
    // public void setAtomicString(String newValue) {
    //     atomicString.set(newValue);
    // }


    AtomicInteger atomicCount = new AtomicInteger(0);
    public void incrementAtomic() {
        atomicCount.incrementAndGet();
    }
    public int getAtomicCount() {
        return atomicCount.get();
    }

    public void increment()   //synchronized
    {
        // count++ is NOT an atomic operation
        count++; // Race condition here
    }

    public int getCount() {
        return count;
    }

    // Method to run the example
    public void Run(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                increment();
                incrementAtomic();
                }
            });
            threads[i].start();
        }
    

        for (int i = 0; i < 5; i++) {
        threads[i].join();
        }

        System.out.println("Final count (expected 50000): " + getCount());
        System.out.println("Final atomic count (expected 50000): " + getAtomicCount());
    }
}
