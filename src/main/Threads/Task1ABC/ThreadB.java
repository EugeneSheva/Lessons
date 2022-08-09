package Task1ABC;

public class ThreadB extends Thread{
    public ThreadB(Printer p) {
        this.p = p;
    }
    Printer p;

    public void run() {
        for (int i = 0; i < 5; i++) {
        p.print('B');
        }
    }
}