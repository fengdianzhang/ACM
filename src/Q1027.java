import java.util.Scanner;

public class Q1027 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strA = in.next();
        String strB = in.next();
        byte[] a = new byte[strA.length()];
        byte[] b = new byte[strB.length()];
        int[] r = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Byte.parseByte(String.valueOf(strA.charAt(strA.length() - i - 1)));
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = Byte.parseByte(String.valueOf(strB.charAt(strB.length() - i - 1)));
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                r[i+j] += a[i] * b[j];
            }
        }
        for (int i = 0; i < r.length - 1; i++) {
            r[i + 1] += r[i] / 10;
            r[i] = r[i] % 10;
        }
        boolean zerostart = true;
        for (int i = r.length - 1; i >= 0; i--) {
            if (zerostart && r[i] == 0) {
                continue;
            }
            zerostart = false;
            System.out.print(r[i]);
        }
        System.out.println();
    }
}
