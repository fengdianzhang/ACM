import java.util.Scanner;

public class Q1003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        while (n >= 5) {
            n = n / 5;
            sum += n;
        }
        System.out.println(sum);
    }
}
