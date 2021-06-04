package lesson13;

public class CalculateArray implements Runnable {
    private final float[] arr;
    private final int iStart;

    public CalculateArray(float[] arr, int iStart) {
        this.arr = arr;
        this.iStart = iStart;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + iStart) / 5.0) *
                    Math.cos(0.2f + (i + iStart) / 5.0) * Math.cos(0.4f + (i + iStart) / 2.0));
        }
    }
}
