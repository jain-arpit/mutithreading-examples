public class MyThread2 implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Creating thread by implementing Runnable interface");
        Thread thread = new Thread(new MyThread2()); // passing runnable object to Thread class
        thread.start();

        thread.join(); //waiting for thread to finish
    }

    @Override
    public void run() {
        System.out.println("hello: inside run");
    }
}
