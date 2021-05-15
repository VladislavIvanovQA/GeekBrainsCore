package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate p) {
        System.out.println("Cat start eat! Try it: " + appetite);
        if (p.getFood() - appetite >= 0) {
            p.decreaseFood(appetite);
            isFull = true;
            p.info();
        } else {
            System.out.println("Plate not have count food: " + appetite);
            p.addFood(appetite);
            p.decreaseFood(appetite);
            isFull = true;
            p.info();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return isFull;
    }
}
