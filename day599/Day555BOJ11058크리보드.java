package day599;

import java.io.*;

public class Day555BOJ11058크리보드 {
  static long[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    dp = new long[n + 1];
    System.out.println(solve(n));
  }

  static long solve(int idx) {
    if (idx <= 0)
      return 0;
    if (idx == 1)
      return dp[idx] = idx;
    if (dp[idx] > 0)
      return dp[idx];

    dp[idx] = solve(idx - 1) + 1;
    for (int i = 2; i < 5; i++)
      dp[idx] = Math.max(dp[idx], solve(idx - (i + 1)) * i);

    return dp[idx];
  }
}