import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Q1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Set<Integer> numbers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            numbers.add(in.nextInt());
        }
        boolean flag = false;
        for (int a:numbers) {
            if (a < n/2 && numbers.contains(n - a)) {
                flag = true;
                System.out.println(a + " " + (n - a));
            }
        }
        if (!flag) {
            System.out.println("No Solution");
        }
    }
}
