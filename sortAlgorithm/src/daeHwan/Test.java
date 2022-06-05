package daeHwan;

import jongHyeon.LSD16BitShiftSort;
import jongHyeon.LSD16BitSort;
import main.RandomArrayCreator;

import java.util.Arrays;
import java.util.Comparator;


public class Test {
    public static void main(String[] args) {
        System.out.println("arr len         R             up            down");

        int[] sizeArr = {1000000, 2500000, 5000000};

        double[] avgTime1 = new double[sizeArr.length];
        double[] avgTime2 = new double[sizeArr.length];
        double[] avgTime3 = new double[sizeArr.length];


        for ( int j = 0; j < 5; j++) {
            for ( int i = 0; i < sizeArr.length; i++ ) {
                Integer[] arr = RandomArrayCreator.intArr(sizeArr[i]);
                double time1 = test(arr);
                double time2 = test(arr);
                Arrays.sort(arr, Comparator.reverseOrder());
                double time3 = test(arr);
                System.out.printf("%-8d time : %f\t%f\t%f %b\n", i, time1, time2, time3, isSorted(arr));
                avgTime1[i] += time1;
                avgTime2[i] += time2;
                avgTime3[i] += time3;
            }
            System.out.println();
        }

        for ( int i = 0; i < sizeArr.length; i++ ) {
            System.out.printf("%8d time : %f\t%f\t%f\n", sizeArr[i], avgTime1[i]/5, avgTime2[i]/5, avgTime3[i]/5);
        }
    }

    public static double test(Integer[] arr) {
        long beforeTime = System.nanoTime();
        LSD16BitShiftSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if ( array[i].compareTo(array[i+1]) > 0 ) {
                return false;
            }
        }
        return true;
    }
}