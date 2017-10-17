package lock;


/**
 * Test
 *
 * @author LIJIKAI
 * @date 17/3/13
 */
public class Tests extends Thread {

    private int threadNo;

    public Tests(int threadNo) {
        this.threadNo = threadNo;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i < 10; i++) {
            new Tests(i).start();
            Thread.sleep(1);
        }

    }


    @Override
    public synchronized void run() {
        for (int i = 1; i < 10000; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }

}
