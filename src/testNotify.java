public class testNotify {

    //    this object is used to take lock inside synchronized block
    public static final String monitor = "lockMe";

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println(Thread.currentThread().getName() + "...starts");
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...notified");
                }

            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println(Thread.currentThread().getName() + "...starts");
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...notified");

                }
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    System.out.println(Thread.currentThread().getName() + "...starts");
                    monitor.notify(); //check o/p with notifyAll also.
                    System.out.println(Thread.currentThread().getName() + "...notification sent");
                }
            }
        }, "t3");


        t1.start();
        t2.start();
        Thread.sleep(200);
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
