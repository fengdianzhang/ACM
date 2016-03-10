import java.math.BigInteger;
import java.util.Scanner;

public class Q1057 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= a; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(result);
    }
}
