import java.util.Scanner;

public class Dynamic1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        int[][] sums = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] += Math.max(sums[i][j - 1], sums[i - 1][j]) + nums[i][j];
            }
        }
        System.out.println(sums[n][n]);
    }
}
