package lock;


/**
 * sisuo
 *
 * @author LIJIKAI
 * @date 17/3/14
 */
public class sisuo {
    private static String A = "A";
    private static String B = "B";


    public static void main(String[] args) {
        new sisuo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {

                try {
                    Thread.currentThread().sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }

        });
        t1.start();
        t2.start();
    }

}
