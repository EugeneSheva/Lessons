package Task1ABC;

public class Printer {
    boolean isA = false;
    boolean isB = false;


    synchronized void print(char c) {
        if (c =='A') {
            if (isA == true)   {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//                System.out.println("A " + Thread.currentThread().getName());
            System.out.print('A');
            isA = true;
            notifyAll();




        } else if (c =='B')     {
            while ((isA == false) || (isB == true)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

//                System.out.println("B " + Thread.currentThread().getName());
            System.out.print('B');
            isB = true;
            notifyAll();





        } else if (c =='C') {
                while ((isA == false) || (isB == false)) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
 //                   System.out.println("C " + Thread.currentThread().getName());
                    System.out.print('C');
                    isA = false;
                    isB = false;
                    notifyAll();
                }







    }
}
