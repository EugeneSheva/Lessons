package SerializationDeserialization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("e://cats.data");
    List<Cat> catList = new ArrayList<>();
    catList.add(new Cat("Блохастый", "Дворовой",10));
    catList.add(new Cat("Мурка", "Британец",8));
    catList.add(new Cat("Барсик", "Сфинкс",12));

    SerializeCat serializeCat = new SerializeCat();
    serializeCat.Serialization(catList,file);

    DeserializeCat deserializeCat = new DeserializeCat();
    List<Cat>NewCatList = deserializeCat.Deserialization(file);
        System.out.println(NewCatList);
    }
}
