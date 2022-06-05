package assignment_02;

public class RecursiveQuickSort {

    public static void sort(Comparable[] a) {
        l_pivot_sort(a, 0, a.length - 1);
    }

    private static void l_pivot_sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(a, low, high);

        l_pivot_sort(a, low, pivot - 1);
        l_pivot_sort(a, pivot + 1, high);
    }

    private static int partition(Comparable[] a, int left, int right) {
        int low = left;
        int high = right;
        Comparable pivot = a[left];

        while (low < high) {
            while (a[high].compareTo(pivot) > 0 && low < high) {
                high--;
            }
            while (a[low].compareTo(pivot) <= 0 && low < high) {
                low++;
            }
            swap(a, low, high);
        }
        swap(a, left, low);

        return low;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}