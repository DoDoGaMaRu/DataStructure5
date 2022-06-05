package assignment_03;

import assignment_02.MedianOfThreeQuickSort;
import assignment_02.RandomArrayCreator;

public class Tester03 {
    public static void main(String[] args) {

        int[] sizeArr = {1000000, 2500000, 5000000};
        String[] sortName = {
                "LSDSort",
                "LSD16BitSort",
                "LSD16BitShiftSort",
                "MedianOfThreeQuickSort"};

        for ( int i = 0; i < sizeArr.length; i++ ) {
            double[] sumTime = new double[4];
            System.out.println("size : " + sizeArr[i]);
            for ( int j = 0; j < 5; j++) {
                Integer[] arr = RandomArrayCreator.intArr(sizeArr[i]);
                sumTime[0] += testLSD(arr.clone());
                sumTime[1] += testLSD16BitSort(arr.clone());
                sumTime[2] += testLSD16BitShitfSort(arr.clone());
                sumTime[3] += testMedianQuickSort(arr.clone());
            }
            for ( int k = 0; k < sortName.length; k++ ) {
                System.out.printf("%s\t%f\n", sortName[k], sumTime[k]/5);
            }
            System.out.println();
        }


    }

    public static double testLSD(Integer[] arr) {
        LSDSort.sort(RandomArrayCreator.intArr(100000));
        long beforeTime = System.nanoTime();
        LSDSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double testLSD16BitSort(Integer[] arr) {
        LSD16BitSort.sort(RandomArrayCreator.intArr(100000));
        long beforeTime = System.nanoTime();
        LSD16BitSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double testLSD16BitShitfSort(Integer[] arr) {
        LSD16BitShiftSort.sort(RandomArrayCreator.intArr(100000));
        long beforeTime = System.nanoTime();
        LSD16BitShiftSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

    public static double testMedianQuickSort(Integer[] arr) {
        MedianOfThreeQuickSort.sort(RandomArrayCreator.intArr(100000));
        long beforeTime = System.nanoTime();
        MedianOfThreeQuickSort.sort(arr);
        long afterTime = System.nanoTime();

        return (double) (afterTime - beforeTime) / 1000000;
    }

}
