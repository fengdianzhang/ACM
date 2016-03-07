import java.util.Scanner;

public class Q1004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = n % 10;
        int r = l;
        int circle = 0;
        for (int i = 0; true; i++) {
            r = r * l % 10;
            if (r == l) {
                circle = i + 1;
                break;
            }
        }
        n = n % circle + circle;
        r = 1;
        for (int i = 0; i < n; i++) {
            r = r * l % 10;
        }
        System.out.println(r);
    }
}
