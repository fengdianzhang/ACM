import java.util.Arrays;
import java.util.Scanner;

public class Q1019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] orginal = new int[n], sorted = new int[n];
        for (int i = 0; i < n; i++) {
            orginal[i] = in.nextInt();
        }
        int count = 0;
        sorted[0] = orginal[0];
        for (int i = 1; i < n; i++) {
            System.out.println(Arrays.toString(sorted));
            int index = search(orginal[i], sorted);
            count += index;
            for (int j = i; j > index; j++) {
                sorted[j] = sorted[j - 1];
            }
            sorted[index] = orginal[i];
        }
        System.out.println(count);
    }

    private static int search(int a, int[] array) {
        int start = 0, end = array.length - 1, middle;
        while (start < end-1) {
            middle = (start + end) / 2;
            if (array[middle] < a) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return end;
    }
}
