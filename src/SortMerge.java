import java.util.Scanner;

public class SortMerge {
    private static int[] aux;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        mergeSort(a);
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    private static void mergeSort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (hi + lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, hi, mid);
    }

    private static void merge(int[] a, int lo, int hi, int mid) {
        for (int i = lo; i <= hi; i++) aux[i] = a[i];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
    }
}
