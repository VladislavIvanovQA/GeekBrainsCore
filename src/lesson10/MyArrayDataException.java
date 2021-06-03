package lesson10;

public class MyArrayDataException extends NumberFormatException {
    private int firstCoordinate, secondCoordinate;

    public String getCoordinates() {
        return "[" + firstCoordinate + "][" + secondCoordinate + "]";
    }

    public MyArrayDataException(int firstCoordinate, int secondCoordinate) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    public MyArrayDataException(String s, int firstCoordinate, int secondCoordinate) {
        super(s);
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }
}
