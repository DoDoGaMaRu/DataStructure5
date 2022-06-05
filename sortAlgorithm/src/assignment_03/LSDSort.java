package assignment_03;

public class LSDSort {
    public static void sort(Integer[] array) {
        int R = 10;
        int N = array.length;
        int[] t = new int[N];

        int maxValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        maxValue *= R;

        for (int k = R; k <= maxValue; k *= R) {
            int[] startIndex = new int[R+1];
            for (int i = 0; i < N; i++) {
                startIndex[(array[i] % k) / (k / R) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                startIndex[r+1] += startIndex[r];
            }
            for (int i = 0; i < N; i++) {
                t[startIndex[(array[i] % k) / (k / R)]++] = array[i];
            }
            for (int i = 0; i < N; i++) {
                array[i] = t[i];
            }
        }
    }
}
