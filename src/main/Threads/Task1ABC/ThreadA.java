package Task1ABC;

public class ThreadA extends Thread{
    public ThreadA(Printer p) {
        this.p = p;
    }

    Printer p;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            p.print('A');
        }
    }
}