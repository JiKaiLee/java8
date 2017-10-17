package lock;


/**
 * MyTest
 *
 * @author LIJIKAI
 * @date 17/3/13
 */
public class SyncThread implements Runnable {
    private static int count;


    public SyncThread() {
        count = 0;
    }

//    public synchronized void run() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                System.out.println(Thread.currentThread().getName() + ":" + (count++));
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public int getCount() {
        return count;
    }

    public void printCount() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void countAdd() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }

    public static void main(String[] args) {

//        SyncThread syncThread = new SyncThread();
//        Thread thread1 = new Thread(syncThread, "SyncThread1");
//        Thread thread2 = new Thread(syncThread, "SyncThread2");
//        thread1.start();
//        thread2.start();
//        SyncThread syncThread = new SyncThread();
//        Thread thread1 = new Thread(syncThread, "A");
//        Thread thread2 = new Thread(syncThread, "B");
//        thread1.start();
//        thread2.start();
        numberTest();
    }


    public static  void numberTest() {
        int sum=0;
        for(int i=1;i<=99;i++){
            //判断是奇数再加
            if(i%2!=0){
                sum+=i;
            }
        }
        System.out.println("result="+sum);
    }



    int studeusNum=10;
    int kemu=2;



}

