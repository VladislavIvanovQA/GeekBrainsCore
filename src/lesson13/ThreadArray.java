package lesson13;

import java.util.Arrays;
import java.util.Date;

public class ThreadArray {
    private static final int SIZE = 10000000;
    private final int multiple;
    private final float[] arr = new float[SIZE];

    public ThreadArray(int multiple) {
        this.multiple = multiple;
        Arrays.fill(arr, 1);
    }

    public void calculate() {
        Date start = new Date();

        int rate = SIZE / multiple;
        int overrate = SIZE % multiple;

        float[][] calcArrays = new float[multiple][];
        Thread[] calcThreads = new Thread[multiple];
        for (int i = 0; i < multiple - 1; i++) {
            calcArrays[i] = new float[rate];
            System.arraycopy(arr, i * rate, calcArrays[i], 0, rate);
            calcThreads[i] = new Thread(new CalculateArray(calcArrays[i], i * rate));
            calcThreads[i].start();
        }
        calcArrays[multiple - 1] = new float[rate + overrate];
        System.arraycopy(arr, (multiple - 1) * rate, calcArrays[multiple - 1], 0, rate + overrate);
        calcThreads[multiple - 1] = new Thread(new CalculateArray(calcArrays[multiple - 1], (multiple - 1) * rate));
        calcThreads[multiple - 1].start();

        for (Thread calcThread : calcThreads) {
            try {
                calcThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < multiple; i++) {
            System.arraycopy(calcArrays[i], 0, arr, i * rate, calcArrays[i].length);
        }

        Date finish = new Date();
        long timeDelta = finish.getTime() - start.getTime();

        System.out.println("Result of 5000000 item: " + arr[5000000] + ", time: " + timeDelta + ", threads count: " + multiple);
    }

    public static void main(String[] args) {
        new ThreadArray(1).calculate();
        new ThreadArray(2).calculate();
        new ThreadArray(5).calculate();
        new ThreadArray(8).calculate();
        new ThreadArray(16).calculate();
        new ThreadArray(32).calculate();
        new ThreadArray(64).calculate();
        new ThreadArray(128).calculate();
        new ThreadArray(256).calculate();
    }
}
