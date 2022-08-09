package Task3threadsInArr;

import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> List = new ArrayList<>();
    static synchronized void addToArr(int x){
        List.add(x);
    }
    public static void main(String[] args) {
        Thread0 thread0 = new Thread0();
        Thread0 thread1 = new Thread0();
        thread0.start();
        thread1.start();
        System.out.println(List.size());
        if ((!thread0.isInterrupted()) && (!thread1.isInterrupted())) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(List.size());


    }
    static class Thread0 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                int a = (int) (Math.random() * 10);
                addToArr(a);
            }
            Thread.currentThread().interrupt();


        }
    }
}
