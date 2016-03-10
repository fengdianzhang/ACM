import java.util.Scanner;

public class Q1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println(a);
    }
}
