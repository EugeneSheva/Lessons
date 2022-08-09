package Task1ABC;

public class Main {
    public static void main(String[] args) {

    Printer p = new Printer();
    ThreadA tA = new ThreadA(p);
    ThreadB tB = new ThreadB(p);
    ThreadC tC = new ThreadC(p);
    tA.start();
    tB.start();
    tC.start();





    }
}
