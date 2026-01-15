public class StringBuilderExample {
    static StringBuilder builder = new StringBuilder();
    public synchronized static void Run(String[] args)   throws InterruptedException {
  // what is runnable ?
  //
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                builder.append("A");
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join(); // Wait here for thread t1 to finish
        t2.join(); // Wait here for thread t2 to finish

        System.out.println("Builder Length: " + builder.length());
    }
}