package lesson6;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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

        AtomicInteger countCat = new AtomicInteger();
        AtomicInteger countDog = new AtomicInteger();
        AtomicInteger countAnimal = new AtomicInteger();
        animals.forEach(animal -> {
            if (animal instanceof Cat) {
                countCat.getAndIncrement();
            }
            if (animal instanceof Dog) {
                countDog.getAndIncrement();
            }
            if (animal instanceof Animal) {
                countAnimal.getAndIncrement();
            }
        });
        System.out.println("==========COUNT==========");
        System.out.println("Cats: " + countCat.get());
        System.out.println("Dogs: " + countDog.get());
        System.out.println("Animals: " + countAnimal.get());
    }
}
