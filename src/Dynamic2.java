import java.util.Scanner;
/**
 * 最大子串和问题
 * */
public class Dynamic2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        long sum = numbers[0], max = numbers[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum , 0) + numbers[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
