package Task1ABC;

public class ThreadC extends Thread{
    public ThreadC(Printer p) {
        this.p = p;
    }
    Printer p;

    public void run() {
        for (int i = 0; i < 5; i++) {
            p.print('C');
        }
    }
}