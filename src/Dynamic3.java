import java.util.Scanner;
/**
 * 最长公共子序列问题
 * */
public class Dynamic3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] a = (' ' + in.next()).toCharArray();
        char[] b = (' ' + in.next()).toCharArray();
        int[][] max = new int[a.length][b.length];
        int result = 0, endA = 0, endB = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    max[i][j] = max[i - 1][j - 1] + 1;
                    if (max[i][j] > result) {
                        result = max[i][j];
                        endA = i;
                        endB = j;
                    }
                } else {
                    max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]);
                }
            }
        }
        char[] sub = new char[result];
        int count = result;
        while(count > 0) {
            if (max[endA - 1][endB] == count - 1 && max[endA][endB - 1] == count - 1) {
                sub[count - 1] = a[endA];
                endA--;
                endB--;
                count--;
            } else if (max[endA - 1][endB] == count - 1) {
                endB--;
            } else {
                endA--;
            }
        }
        System.out.println(new String(sub));
    }
}
