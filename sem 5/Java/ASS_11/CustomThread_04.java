/*Output:->
Push count of thread(Priority=7) = 12662989
Push count of thread(Priority=3) = 12603024
Push counter Difference: 59965
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

    public void start() { t.start(); }

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

        try { Thread.sleep(17); } 
        catch (InterruptedException e) { System.out.println("Main thread interrupted"); }

        low.stop();
        hi.stop();

        hi.t.join();
        low.t.join();
        
        long hc = hi.getPushCount();
        long lc = low.getPushCount();
        System.out.println("Push count of thread(Priority="+hi.t.getPriority()+") = " + hc);
        System.out.println("Push count of thread(Priority="+low.t.getPriority()+") = " + lc);
        System.out.println("Push counter Difference: " + (hc-lc));
    }
}