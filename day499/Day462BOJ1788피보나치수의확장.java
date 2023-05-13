package day499;

import java.io.*;

public class Day462BOJ1788피보나치수의확장 {
  static final int MOD = 1_000_000_000;
  static final int SET = 1_000_000;
  static int N, ans = 1;
  static long[] dp = new long[2000001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()) + SET;

    dp[SET + 1] = 1;
    if (N < SET) {
      for (int i = SET - 1; i >= N; i--) {
        dp[i] = (dp[i + 2] - dp[i + 1]) % MOD;
      }
    } else {
      for (int i = SET + 2; i <= N; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
      }
    }
    if (dp[N] == 0)
      ans = 0;
    else if (dp[N] < 0)
      ans = -1;
    System.out.println(ans);
    System.out.print(Math.abs(dp[N]));
  }
}
