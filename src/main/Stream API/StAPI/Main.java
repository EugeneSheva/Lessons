package StAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {




    public static void main(String[] args) {
         List<User> list = new ArrayList<>();
        list.add(new User("Boris",20));
        list.add (new User("Viktor",18));
        list.add (new User("Gennadiy",35));
        list.add (new User("Anton",25));
        list.add (new User("Dmitriy",40));
        list.add (new User("Eugeniy",45));
        list.add (new User("Zamir",50));
        list.add (new User("Ivan",55));
        list.add (new User("Konstantin",60));
        list.add (new User("Leonid",65));


        list.stream()
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getAge() < 40)
                .limit(3)
                .map(User::getName)
                .forEach(System.out::println);
    }
}
