package writeInFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fw = null;
        String name;

        System.out.println("Введите имена через пробел: ");
        name = scanner.nextLine();

        try {
            fw = new FileWriter("e://writeInFile.txt",false);
            fw.write(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
