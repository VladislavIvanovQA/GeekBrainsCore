package leason3;

import java.util.Arrays;
import java.util.Collections;

public class HomeWorkApp {
    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{0, 1, 0, 1, 0, 0, 0, 1, 1, 1};
        System.out.print("Before replace: ");
        Arrays.stream(arrays).forEach(System.out::print);
        System.out.println("");
        System.out.print("After replace:  ");
        Arrays.stream(replaceInArray(arrays)).forEach(System.out::print);
        System.out.println("");

        fillArray(new Integer[100]);

        Integer[] multiply = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.print("Before replace: ");
        Arrays.stream(multiply).forEach(System.out::print);
        System.out.println("");
        System.out.print("After replace:  ");
        Arrays.stream(multiplyInArray(multiply)).forEach(System.out::print);
        System.out.println("");

        fillDoubleArrays(new Integer[5][5]);

        System.out.println();
        Arrays.stream(fillArrayForValue(10, 0)).forEach(System.out::print);
        System.out.println();

        searchMinMaxInArray(new Integer[]{1,2,3,4,5,6,7,8,9});

        System.out.println(diffSumLeftAndRight(new Integer[]{1,2,3,4,5,5,4,3,2,1}));
        System.out.println(diffSumLeftAndRight(new Integer[]{1,3,4,5,5,4,3,2,1}));
    }

    public static Integer[] replaceInArray(Integer[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0) {
                arrays[i] = 1;
            } else {
                arrays[i] = 0;
            }
        }
        return arrays;
    }

    public static void fillArray(Integer[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i + 1;
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public static Integer[] multiplyInArray(Integer[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < 6) {
                arrays[i] = arrays[i] * 2;
            }
        }
        return arrays;
    }

    public static void fillDoubleArrays(Integer[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                arrays[i][j] = 0;
            }
        }
        for (int x = 0; x < arrays.length; x++) {
            for (int y = 0; y < arrays.length; y++) {
                System.out.print("[" + x + "][" + y + "]" + " ");
                if (x == y) {
                    arrays[x][y] = 1;
                }
                if (x + y == arrays.length - 1) {
                    arrays[x][y] = 1;
                }
                System.out.print(arrays[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static int[] fillArrayForValue(int len, int initialValue) {
        int[] arrays = new int[len];
        Arrays.fill(arrays, initialValue);
        return arrays;
    }

    public static void searchMinMaxInArray(Integer[] arrays) {
        Integer min = Collections.min(Arrays.asList(arrays));
        Integer max = Collections.max(Arrays.asList(arrays));
        System.out.println("Arrays have min=" + min + " , max=" + max);
    }

    public static boolean diffSumLeftAndRight(Integer[] arrays) {
        Integer sumLeft = 0;
        Integer sumRight = 0;
        for (int i = 0; i < arrays.length / 2; i++) {
            sumLeft += arrays[i];
        }

        for (int i = arrays.length / 2; i < arrays.length; i++) {
            sumRight += arrays[i];
        }

        System.out.println("diffSumLeftAndRight");
        System.out.println("leftSum=" + sumLeft + " rightSum=" + sumRight);
        return sumLeft.equals(sumRight);
    }
}
