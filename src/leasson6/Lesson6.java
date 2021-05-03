package leasson6;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Lesson6 {
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
                new Dog("Bobik"),
                new Dog("Sharik"),
                new Cat("Barsik"),
                new Cat("Mars")
        );

        animals.forEach(animal -> {
            while (animal.run(new Random().nextInt(100 - 20)));
            while (animal.swim(new Random().nextInt(10 - 1)));
        });
    }
}
