import javax.swing.table.TableRowSorter;

class A {
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();
        System.out.println(name + " Entered A.foo");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(name + " Trying to call B.last()");
        b.last();
    }
    synchronized void last (){
        System.out.println("Inside A.last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " Entered B.bar");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }

        System.out.println(name + "Tring to call A.last()");
        a.last();
    }
    synchronized void last() {
        System.out.println("Inside B.last");
    }
}

public class OccuringDeadlock implements Runnable{
    A a = new A();
    B b = new B();

    OccuringDeadlock() {
        Thread.currentThread().setName("MainThread");
        Thread t = new Thread(this, "RacingThread");
        t.start();

        a.foo(b); //get lock on a in this thread
        System.out.println("Back in MainThread");
    }

    @Override
    public void run() {
        b.bar(a); // get lock on b in other thread
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        new OccuringDeadlock();
    }
}
