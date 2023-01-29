import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day356BOJ2011암호코드 {
    static final int MOD = 1_000_000;
    static int N, n, nn, t;
    static char[] c;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = br.readLine().toCharArray();
        N = c.length;
        dp = new int[N + 1];

        dp[0] = 1;
        for (int i = 1; i < N + 1; i++) {
            n = c[i - 1] - '0';
            if (0 < n && n < 10) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
            if (i == 1)
                continue;
            nn = c[i - 2] - '0';
            if (nn == 0)
                continue;
            t = nn * 10 + n;
            if (9 < t && t < 27) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[N]);
    }
}
