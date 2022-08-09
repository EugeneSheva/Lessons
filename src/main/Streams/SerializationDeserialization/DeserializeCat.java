package SerializationDeserialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeserializeCat {
    public List<Cat> Deserialization(File file) {
        List<Cat> catList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                catList = (List<Cat>) ois.readObject();
                System.out.println("Обект " + catList + " считан.");
            }
            return catList;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}