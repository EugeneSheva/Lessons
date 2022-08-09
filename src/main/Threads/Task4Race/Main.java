package Task4Race;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Main {
    static ArrayList<String>ListName =new ArrayList<>();
    static ArrayList<Long>ListTime =new ArrayList<>();
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        Semaphore sem = new Semaphore(3);
        CyclicBarrier cycBar = new CyclicBarrier(10);
        MyThread t0 = new MyThread(cdl,sem,cycBar);
        MyThread t1 = new MyThread(cdl,sem,cycBar);
        MyThread t2 = new MyThread(cdl,sem,cycBar);
        MyThread t3 = new MyThread(cdl,sem,cycBar);
        MyThread t4 = new MyThread(cdl,sem,cycBar);
        MyThread t5 = new MyThread(cdl,sem,cycBar);
        MyThread t6 = new MyThread(cdl,sem,cycBar);
        MyThread t7 = new MyThread(cdl,sem,cycBar);
        MyThread t8 = new MyThread(cdl,sem,cycBar);
        MyThread t9 = new MyThread(cdl,sem,cycBar);

        t0.start();t1.start();t2.start();t3.start();t4.start();t5.start();t6.start();t7.start();t8.start();t9.start();

        if ((!t0.isInterrupted()) || (!t1.isInterrupted())  || (!t2.isInterrupted())  || (!t3.isInterrupted())  || (!t4.isInterrupted())  || (!t5.isInterrupted())  || (!t6.isInterrupted())  || (!t7.isInterrupted())  || (!t8.isInterrupted())  || (!t9.isInterrupted())) {
            try {
                sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Результат гонки: ");
        for (int i = 0; i < ListName.size(); i++) {
            System.out.println((i+1)+ " место: " + ListName.get(i) + " " + (ListTime.get(i) / 1000) + ","+ (ListTime.get(i) % 1000) + "сек.");
        }
        System.out.println("Разрыв между первым и последним гонщиком " + (ListTime.get(9) - ListTime.get(0)) + " мс.");

    }

    static class MyThread extends Thread {
        public MyThread(CountDownLatch cdl, Semaphore sem, CyclicBarrier cycBar) {


            this.cdl = cdl;
            this.sem = sem;
            CycBar = cycBar;
        }

        CountDownLatch cdl;
        Semaphore sem;
        CyclicBarrier CycBar;
        @Override
        public void run() {
            System.out.println(getName() + " готовится к гонке");
            int a = (int)Math.abs(Math.random()*9000-1000);
            try {
                sleep(a);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " готов");
            cdl.countDown();
            try {
                cdl.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Date start = new Date();
            System.out.println(getName() + " Стратовал");
            int b = (int)Math.abs(Math.random()*9000-1000);
            try {
                sleep(b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " проехал участок обычной дороги");
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " заехал в тунель");
            int с = (int)Math.abs(Math.random()*9000-1000);
            try {
                sleep(с);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sem.release();
            System.out.println(getName()+ " выехал с тунеля");
            int d = (int)Math.abs(Math.random()*9000-1000);
            try {
                sleep(d);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + " финишировал");
            Date fin = new Date();
            Long total = fin.getTime() - start.getTime();
            ListName.add(getName());
            ListTime.add(total);
            interrupt();



        }
    }
}
