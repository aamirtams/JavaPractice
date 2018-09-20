//Demonstrate thread preorities

class clicker implements Runnable {
    int click = 0;
    Thread t;
    private volatile boolean running = true;

    clicker(int p) {
        t = new Thread(this);
        t.setPriority(p);
    }

    @Override
    public void run() {
        while (running){
            click++;
        }
    }

    public void stop() {
        running = false;
    }

    public void start() {
        t.start();
    }
}


public class HighLowPriority {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        clicker hi = new clicker(Thread.NORM_PRIORITY + 2);
        clicker lo = new clicker(Thread.NORM_PRIORITY - 2);

        lo.start();
        hi.start();

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted");
        }

        lo.stop();
        hi.stop();

        // Wait for child thread to terminate

        try {
            hi.t.join();
            lo.t.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted exception caught");
        }

        System.out.println("Low-Priority Thread " + lo.click);
        System.out.println("High-Priority Thread " + hi.click);
    }
}
