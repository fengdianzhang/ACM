import java.util.Scanner;
import java.util.Stack;

public class Q1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());
        System.out.println(a.add(b));
    }

    public static class BigInteger {
        final boolean flag;
        final Stack<Byte> numbers;

        public BigInteger(String str) {
            if (str.startsWith("-")) {
                flag = false;
                str = str.substring(1, str.length());
            } else if (str.startsWith("+")) {
                flag = true;
                str = str.substring(1, str.length());
            } else {
                flag = true;
            }
            numbers = new Stack<>();
            for (char c : str.toCharArray()) {
                numbers.push(Byte.parseByte(String.valueOf(c)));
            }
        }

        public BigInteger(Boolean flag, Stack<Byte> numbers) {
            this.flag = flag;
            this.numbers = numbers;
        }

        public BigInteger invert(BigInteger bi) {
            return new BigInteger(!bi.flag, bi.numbers);
        }
        public BigInteger add(BigInteger bi) {
            if (this.flag && bi.flag) {
                return _add(bi);
            } else if (!this.flag && !bi.flag) {
                return invert(_add(bi));
            } else if (this.flag && !bi.flag) {
                int result = absBigger(bi);
                if (result == 1) {
                    return _minus(bi);
                } else if (result == -1) {
                    return invert(bi._minus(this));
                }
            } else {
                int result = absBigger(bi);
                if (result == 1) {
                    return invert(this._minus(bi));
                } else if (result == -1) {
                    return bi._minus(this);
                }
            }
            return new BigInteger("");
        }

        private BigInteger _add(BigInteger bi) {
            Stack<Byte> a = this.numbers;
            Stack<Byte> b = bi.numbers;
            Stack<Byte> sum = new Stack<>();
            Stack<Byte> result = new Stack<>();
            byte flag = 0;
            while (!a.empty() || !b.empty()) {
                byte ab = a.empty() ? 0 : a.pop();
                byte bb = b.empty() ? 0 : b.pop();
                byte sb = (byte) (ab + bb + flag);
                if (sb > 9) {
                    sb -= 10;
                    flag = 1;
                }else {
                    flag = 0;
                }
                sum.push(sb);
            }
            if (flag == 1) {
                sum.push(flag);
            }
            while (!sum.empty()) {
                result.push(sum.pop());
            }
            return new BigInteger(true, result);
        }

        private BigInteger _minus(BigInteger bi) {
            Stack<Byte> a = this.numbers;
            Stack<Byte> b = bi.numbers;
            Stack<Byte> sum = new Stack<>();
            Stack<Byte> result = new Stack<>();
            byte flag = 0;
            while (!a.empty() || !b.empty()) {
                byte ab = a.empty() ? 0 : a.pop();
                byte bb = b.empty() ? 0 : b.pop();
                byte sb = (byte) (ab - bb + flag);
                if (sb < 0) {
                    sb += 10;
                    flag = -1;
                } else {
                    flag = 0;
                }
                sum.push(sb);
            }
            boolean start = true;
            while (!sum.empty()) {
                byte temp = sum.pop();
                if (temp == 0 && start) {
                    continue;
                }
                result.push(temp);
                start = false;
            }
            return new BigInteger(true, result);
        }

        private int absBigger(BigInteger bi) {
            if (this.numbers.size() > bi.numbers.size()) {
                return 1;
            } else if (this.numbers.size() < bi.numbers.size()) {
                return -1;
            } else {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) > bi.numbers.get(i)) {
                        return 1;
                    } else if (numbers.get(i) < bi.numbers.get(i)) {
                        return -1;
                    }
                }
                return 0;
            }
        }
        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            if (!flag) {
                sb.append("-");
            }
            for (byte b : numbers) {
                sb.append(b);
            }
            if (sb.length() == 0) {
                sb.append(0);
            }
            return sb.toString();
        }
    }
}
