import java.util.Scanner;

public class Q1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        int index = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                index = 0;
            } else if (nums[i][index] < nums[i][index + 1]) {
                index ++;
            }
            sum += nums[i][index];
        }
        System.out.println(sum);
    }
}
