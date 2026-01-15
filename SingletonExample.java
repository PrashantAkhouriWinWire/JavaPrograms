public class SingletonExample {
    private static SingletonExample instance;
    private static Object lock = new Obbject();

    private SingletonExample() {
        // Private constructor to prevent instantiation
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            synchronized (lock){
                if (instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class TestSingleton {
    public static void main(String[] args) {
        SingletonExample singleton = SingletonExample.getInstance();
        singleton.showMessage();
    }
}

