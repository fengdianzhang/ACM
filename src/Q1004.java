import java.util.Scanner;

public class Q1004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * (n % 10) % 10;
        }
        System.out.println(result);
    }
}
