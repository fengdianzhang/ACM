import java.util.Scanner;

public class Q1008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long ans = 1;
        for (long i = 1; i <= a; i++) {
            ans = ans * i % b;
        }
        System.out.println(ans);
    }
}
