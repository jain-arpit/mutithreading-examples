import java.util.Scanner;


/**
 * A program consists of n thread printing 1 to 10. Below is the sample output of executing 4 concurrent threads.
 * Thread 1: 1
 * Thread 1: 5
 * Thread 1: 9
 * Thread 3: 3
 * Thread 3: 7
 * Thread 2: 2
 * Thread 4: 4
 * Thread 2: 6
 * Thread 4: 8
 * Thread 2: 10
 */


public class PatternThread implements Runnable {

    int threadNo;
    int totalThreads;

    PatternThread(int i, int totalThreads) {
        this.threadNo = i;
        this.totalThreads = totalThreads;

    }

    public static void main(String[] args) {
        System.out.println("Enter number of threads to be created <= 10");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.close();

        if (count > 0 && count <= 10) {
            for (int i = 1; i <= count; i++) {
                new Thread(new PatternThread(i, count), "Thread " + i).start();
            }
        } else {
            System.out.println("Wrong input. entered value must >0 and <=10");
        }

    }

    @Override
    public void run() {
        int count = threadNo;
        while (count <= 10) {
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count += totalThreads;
        }

    }
}
