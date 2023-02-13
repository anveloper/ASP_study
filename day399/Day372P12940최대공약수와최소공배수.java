import java.util.Arrays;

public class Day372P12940최대공약수와최소공배수 {
    static int GCD, LCM;

    public static int[] day372P12940최대공약수와최소공배수(int n, int m) {
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        for (int i = n; i > 0; i--) {
            if (n % i == 0 && m % i == 0) {
                GCD = i;
                break;
            }
        }

        return new int[] { GCD, LCM = n * m / GCD };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(day372P12940최대공약수와최소공배수(3, 12)));
        System.out.println(Arrays.toString(day372P12940최대공약수와최소공배수(2, 5)));
    }
}
