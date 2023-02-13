import java.util.Arrays;

public class Day372P12940최대공약수와최소공배수o {

    public static int[] day372P12940최대공약수와최소공배수o(int n, int m) {
        int gcd = gcd(Math.min(n, m), Math.max(n, m));
        return new int[] { gcd, n * m / gcd };
    }

    private static int gcd(int a, int b) {
        return b % a == 0 ? a : gcd(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(day372P12940최대공약수와최소공배수o(3, 12)));
        System.out.println(Arrays.toString(day372P12940최대공약수와최소공배수o(2, 5)));
    }
}
