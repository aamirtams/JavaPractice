// Use of synchronized method

import jdk.nashorn.internal.codegen.CompilerConstants;

class Callme {
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Thread t;
    Callme target;

    public Caller (Callme targ, String s){
        msg = s;
        target = targ;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call(msg);
    }
}

public class SynchronizedMethod {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller c1 = new Caller(target, "Hello");
        Caller c2 = new Caller(target, "Synchronized");
        Caller c3 = new Caller(target, "World");

        //Wait for threads to end

        try {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        }catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
