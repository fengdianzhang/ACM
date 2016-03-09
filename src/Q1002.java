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
        int[][] sums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (i == 0) {
                    sums[i][j] = nums[i][j];
                } else if (j == 0) {
                    sums[i][j] = sums[i - 1][j] + nums[i][j];
                } else if (j == i) {
                    sums[i][j] += sums[i - 1][j - 1] + nums[i][j];
                } else {
                    sums[i][j] += Math.max(sums[i - 1][j - 1], sums[i - 1][j]) + nums[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, sums[n-1][i]);
        }
        System.out.println(max);
    }
}
