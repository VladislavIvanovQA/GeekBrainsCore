package leasson5;

import java.util.Arrays;
import java.util.List;

public class Lesson6 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("ivanov", "ivan", "ivanonvich",
                        "QA", "test@mail.ru", "927845213123", 5213.123, 40),
                new Person("smirnov", "sergey", "vadimovich",
                        "Java Developer", "test@mail.ru", "927845213123", 3213.123, 41),
                new Person("kirillov", "oleg", "kirillov",
                        "PM", "test@mail.ru", "927845213123", 10213.123, 37),
                new Person("medvedeva", "elina", "mikhailovna",
                        "DevOps", "test@mail.ru", "927845213123", 70213.123, 55),
                new Person("abramovich", "mike", "vladislavovich",
                        "Admin", "test@mail.ru", "927845213123", 4213.123, 42)
        );

        people.stream()
                .filter(p -> p.getAge() > 40)
                .forEach(System.out::println);
    }
}
