
public class ThreadInfo implements Runnable {


    public static void main(String[] args) {
        //getting info of main thread
        getThreadInfo();

        //creating new thread
        Thread thread = new Thread(new ThreadInfo(), "Thread 1");
        thread.setPriority(Thread.MAX_PRIORITY);
        //starting thread
        thread.start();

    }

    @Override
    public void run() {
        System.out.println("New thread started");
        getThreadInfo();
    }

    public static void getThreadInfo() {
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread name:" + currentThread.getName());
        System.out.println("Current thread state:" + currentThread.getState());
        System.out.println("Current thread priority:" + currentThread.getPriority());
    }
}
