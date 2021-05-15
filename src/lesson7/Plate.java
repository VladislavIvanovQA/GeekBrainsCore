package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
        System.out.println("Initialization food in plate: " + food);
    }

    public void info() {
        System.out.println("Food: " + food);
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            int result = food - amount;
            if (result <= 0) {
                return false;
            } else {
                food = result;
                System.out.println("Cat finish eat!");
                return true;
            }
        } else {
            System.out.println("Amount more than less count food!");
            return false;
        }
    }

    public void addFood(int amountFood) {
        if (amountFood > 0) {
            this.food =+ amountFood;
            System.out.println("Plate added food amount: " + amountFood);
        } else {
            System.err.println("Please added amount, min 1");
        }
    }

    public int getFood() {
        return food;
    }
}
