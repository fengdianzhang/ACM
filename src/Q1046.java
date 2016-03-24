import java.util.Scanner;

public class Q1046 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        a = a % c;
        int r = 1;
        for (int i = 0; i < b; i++) {
            r = (a * r) % c;
            if (r == 0) {
                break;
            }
        }
        System.out.println(r);
    }
}
