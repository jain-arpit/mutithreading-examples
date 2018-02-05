
public class RaceCondition implements Runnable {

    private static boolean done;

    @Override
    public void run() {
        int i = 0;
        while (!done) {
            i++;
        }
        System.out.println("Done!");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RaceCondition());
        t1.start();
        Thread.sleep(2000);
        done = true;
        System.out.println("flag done set to true");

    }


}
