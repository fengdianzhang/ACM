import java.util.Scanner;
import java.util.Stack;

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
        long max = 0, sum;
        Stack<Position> path = new Stack<>();
        path.push(new Position(0, 0));
        Position last;
        sum = nums[0][0];
        while (true) {
            last = path.peek();
            if (last.row == n - 1) {
                max = Math.max(max, sum);
                path.pop();
                sum -= nums[last.row][last.col];
            } else {
                if (last.state == 0) {
                    path.push(new Position(last.row + 1, last.col));
                    sum += nums[last.row + 1][last.col];
                    last.state++;
                } else if (last.state == 1) {
                    path.push(new Position(last.row + 1, last.col + 1));
                    sum += nums[last.row + 1][last.col + 1];
                    last.state++;
                } else if (last.state == 2) {
                    path.pop();
                    sum -= nums[last.row][last.col];
                    if (path.empty()) {
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static class Position {
        int row;
        int col;
        int state = 0;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
