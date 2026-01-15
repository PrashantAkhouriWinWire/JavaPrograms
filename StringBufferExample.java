public class StringBufferExample {
    static StringBuffer buffer = new StringBuffer();
    public static void Run(String[] args)   throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                buffer.append("A");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join(); // Wait for thread t1 to finish
        t2.join(); // Wait for thread t2 to finish

        System.out.println("Buffer Length: " + buffer.length());
    }
}