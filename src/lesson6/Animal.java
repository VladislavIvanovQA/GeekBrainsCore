package lesson6;

public class Animal {
    protected String name;
    protected int limitRun;
    protected int limitSwim;

    public Animal(String name, int limitRun, int limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
    }

    public boolean run(int distance) {
        int tempValue = limitRun - distance;
        if (tempValue > 0) {
            limitRun = limitRun - distance;
            System.out.println(name + " run: " + distance + " m. limit: " + limitRun);
            return true;
        } else {
            System.out.println(name + " can not running!");
            return false;
        }
    }

    public boolean swim(int distance) {
        int tempValue = limitSwim - distance;
        if (tempValue > 0) {
            limitSwim = limitSwim - distance;
            System.out.println(name + " swimming: " + distance + " m. limit: " + limitSwim);
            return true;
        } else {
            System.out.println(name + " can not swimming!");
            return false;
        }
    }
}
