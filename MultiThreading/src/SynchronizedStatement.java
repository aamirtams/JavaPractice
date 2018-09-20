class Callme2 {
    void call(String msg){
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller2 implements Runnable {
    String msg;
    Callme2 target;
    Thread t;

    public Caller2(Callme2 targ, String s){
        target = targ;
        msg = s;
        t= new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target){
            target.call(msg);
        }
    }
}
public class SynchronizedStatement {
    public static void main(String[] args) {
        Callme2 target = new Callme2();
        Caller2 c1 = new Caller2(target, "Hello");
        Caller2 c2 = new Caller2(target, "Synchronized");
        Caller2 c3 = new Caller2(target, "World");

        // Wait for threads to end

        try {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}
