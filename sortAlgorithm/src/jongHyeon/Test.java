package jongHyeon;

import main.RandomArrayCreator;
import sort.IterativeMergeSort;

import java.util.Arrays;

public class Test {
    public static void main(String...args) {
        Integer[] arr = RandomArrayCreator.intArr(35);

        System.out.println(Arrays.toString(arr));
        IterativeMergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isSorted(arr));
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
