import java.util.Scanner;

public class SortQuick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        quickSort(num, 0, num.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] <= a[lo]) if (i == hi) break;
            while (a[--j] >= a[lo]) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    private static void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
