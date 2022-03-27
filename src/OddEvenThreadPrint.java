import java.io.File;

public class OddEvenThreadPrint {

    // Thread 1 print odd number
    //Thread 2 print even number

    private volatile int counter = 1;

    private int limit = 50;

    public void printOddNumbers() throws InterruptedException {
        System.out.println("");
        synchronized (this){
            while(counter <= limit){
                while(counter % 2 == 0){
                    wait();
                }
                File file = new File("abc.txt");
                System.out.println(counter);
                counter++;
                notifyAll();
            }
        }
        File file = new File("txt");
    }


    /*
    // counter  = 2 -> 3
    //t1 ->  1
    //t2 even
    // t3  even  still waiting

    t1 enter odd
    t3 even notify t1

    t2 enters wait state
    t3 enters wait state
    t1 enters print counter notify
    t3 enters  prints
    t2 comes out
    t2 will again go to wait state
    t3 again go to wait state
    t1 print counter notify
    */


    public void printEvenNumbers() throws InterruptedException {
        synchronized (this){
            while(counter <= limit){
                while(counter % 2 != 0){
                    wait();
                }

                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {

        OddEvenThreadPrint test = new OddEvenThreadPrint();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.printOddNumbers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.printEvenNumbers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.printEvenNumbers();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );

        t1.start();
        t2.start();
        t3.start();

    }
}
