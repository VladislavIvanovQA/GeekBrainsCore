package lesson6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 10);
    }

    @Override
    public boolean run(int distance) {
        return super.run(distance);
    }

    @Override
    public boolean swim(int distance) {
        return super.swim(distance);
    }
}
