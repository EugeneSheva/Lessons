package SerializationDeserialization;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class SerializeCat {
    public void Serialization (List<Cat> catList, File file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(catList);
                System.out.println("Обект " + catList + " записан.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

