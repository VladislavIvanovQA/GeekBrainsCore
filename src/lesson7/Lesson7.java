package lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson7 {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat("Barsik" + i, new Random().nextInt(50));
            cats.add(cat);
        }

        Plate plate = new Plate(200);
        cats.forEach(cat -> cat.eat(plate));
        cats.forEach(cat -> System.out.println(cat.getName() + " isFull:" + cat.isFull()));
    }
}
