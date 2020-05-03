package java_foundation.thread;

public class RunnableFoundation implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableFoundation());
        thread.start();
    }
}
