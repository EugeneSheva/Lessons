package ReadFromFile;

import java.io.*;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Arrays;
import static java.nio.file.Files.readString;


public class Main {
    public static void main(String[] args) {
        String s = null;
        char[]ch = new char[4096];
        int tmp;

        try {
            Reader r = new FileReader("e://writeInFile.txt");
            BufferedReader br = new BufferedReader(r);
            s = br.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//          2
//        try {
//            Reader r = new FileReader("e://writeInFile.txt");
//            while  ((tmp=r.read(ch)) != -1);
//            s = Arrays.toString(ch);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//

//          3
//        try {
//            s = readString(Path.of("e://writeInFile.txt"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(s);
        String[] line = s.split(" ");
        System.out.println(Arrays.toString(line));
    }
}
