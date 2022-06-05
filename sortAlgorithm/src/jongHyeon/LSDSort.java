package jongHyeon;

public class LSDSort {
    public static void sort(Integer[] array) {
        int minValue = 0;
        int maxValue = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        int exponent = 1;
        while ((maxValue - minValue) / exponent >= 1) {
            LSDSort.countingSortByDigit(array, exponent, minValue);
            exponent *= 10;
        }
    }

    private static void countingSortByDigit(Integer[] array, int digit, int minValue) {
        int bucketIndex;
        int[] buckets = new int[array.length];
        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            bucketIndex = (array[i] - minValue) / digit;
            buckets[bucketIndex]++;
        }

        for (int i = 1; i < array.length; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            bucketIndex = (array[i] - minValue) / digit;
            output[--buckets[bucketIndex]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
}
