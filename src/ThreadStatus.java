
public class ThreadStatus {

    public static Thread t1;
    public static Thread t2;

    public static void main(String[] args) throws InterruptedException {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Thread.State.WAITING
                System.out.println("Checking state of thread 2 when it is waiting for thread 1 to finish");
                System.out.println(t2.getName() + ":" + t2.getState());
            }
        }, "Thread 1");


        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//              Thread.State.TIMED_WAITING
                System.out.println("Checking state of thread 1 when it is sleeping");
                System.out.println(t1.getName() + ":" + t1.getState());
                try {
                    t1.join(); //t2 is waiting for t1 to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "Thread 2");

//        Thread.State.NEW
        System.out.println("State of thread1 and thread 2 when created that is before started");
        System.out.println(t1.getName() + " : " + t1.getState());
        System.out.println(t2.getName() + " : " + t2.getState());

        t1.start();
        t2.start();


//        Thread.State.RUNNABLE
        System.out.println("State of thread1 and thread 2 when started");
        System.out.println(t1.getName() + " : " + t1.getState());
        System.out.println(t2.getName() + " : " + t2.getState());

//        main thread is waiting for thread1 and thread2 to finish
        t1.join();
        t2.join();

//        Thread.State.TERMINATED
        System.out.println("State of thread1 and thread 2 when finished");
        System.out.println(t1.getName() + " : " + t1.getState());
        System.out.println(t2.getName() + " : " + t2.getState());


    }
}
