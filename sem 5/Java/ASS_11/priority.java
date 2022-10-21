/*Output:->
High priority thread: 90128354
Low priority thread: 89564688
Priority Difference: 563666
 */
/*Question no 4 */
class PushCounter implements Runnable {
    private long push = 0;
    Thread t;
    private volatile boolean running = true;

    public PushCounter(int p) {
        t = new Thread(this);
        t.setPriority(p);
    }

    public void run() {
        while (running) push++;
        
    }

    public void stop() {
        running = false;
    }

    public void start() {
        t.start();
    }

    public long getPushCount(){return push;}
}

public class CustomThread_04 {
    public static void main(String[] args) throws InterruptedException
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        PushCounter hi = new PushCounter(Thread.NORM_PRIORITY + 2);
        PushCounter low = new PushCounter(Thread.NORM_PRIORITY - 2);
        low.start();
        hi.start();

        try { Thread.sleep(100); } 
        catch (InterruptedException e) { System.out.println("Main thread interrupted"); }

        low.stop();
        hi.stop();

        hi.t.join();
        low.t.join();
        
        long hc = hi.getClickCount();
        long lc = low.getClickCount();
        System.out.println("Push count of thread(HighPriority) "+hi.t+" = " + hc);
        System.out.println("Push count of thread(LowPriority) "+low.t+" = " + lc);
        System.out.println("Push counter Difference: " + (hc-lc));
    }
}