package day399;

class Day386P12902n3타일링 {
  static final int MOD = 1_000_000_007;
  static long[] dp;

  public static int day386P12902n3타일링(int n) {
    if (n % 2 == 1)
      return 0;
    n /= 2;
    dp = new long[n + 1];
    dp[0] = 1;
    dp[1] = 3;
    for (int i = 2; i < n + 1; i++) {
      dp[i] = 4 * dp[i - 1] - dp[i - 2];
      dp[i] = dp[i] < 0 ? dp[i] + MOD : dp[i] % MOD;
    }

    return (int) dp[n];
  }

  public static void main(String[] args) {
    System.out.print(day386P12902n3타일링(8));
  }
}
// 홀수는 불가능
// n==2: