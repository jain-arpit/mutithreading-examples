public class MyThread1 extends Thread {

    @Override
    public void run(){
        System.out.println("hello: inside run");
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Creating thread by extending Thread class");
        MyThread1 thread1=new MyThread1();
        thread1.start();

        thread1.join(); //waiting for thread1 to finish
    }

}
