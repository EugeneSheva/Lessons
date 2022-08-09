package Task2CallableAndDeamon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        names.add("Anton");
        names.add("Boris");
        names.add("Viktor");
        names.add("Gennadiy");
        names.add("Dmitriy");
        names.add("Eugeniy");
        names.add("Zamir");
        names.add("Ivan");
        names.add("Konstantin");
        names.add("Leonid");
        System.out.println("Введите значение от 0 до 9");
        int tmp = scanner.nextInt();

        MyCollable myCollable = new MyCollable(names,tmp);
        MyDeamon myDeamon = new MyDeamon();
        myDeamon.setDaemon(true);

        myDeamon.start();
        try {
            String name = myCollable.call();
            System.out.println(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }

    static class MyCollable implements Callable<String>{

        ArrayList<String> names = new ArrayList<>();
        int tmp;

        public MyCollable(ArrayList<String> names, int tmp) {
            this.names = names;
            this.tmp = tmp;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            String name = names.get(tmp);
            return name;
        }
    }
    static class MyDeamon extends Thread {

        @Override
        public void run() {
            System.out.print("Loading 0% ");
            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(450);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("*");
            }
            System.out.println(" 100%");
        }
    }
}
