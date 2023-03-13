package day449;

import java.io.*;

public class Day401BOJ2482색상환 {
  static final int MOD = 1000000003;
  static int N, K;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());

    dp = new int[N + 1][K + 1];

    if (N / K < 2) {
      System.out.println(0);
      return;
    }

    System.out.println(recur(N, K));
    br.close();
  }

  public static int recur(int N, int K) {
    if (K == 1) {
      return N;
    }

    if (K == (N / 2 + N % 2)) {
      return 2;
    }

    if (dp[N][K] == 0)
      dp[N][K] = (recur(N - 2, K - 1) + recur(N - 1, K)) % MOD;

    return dp[N][K];
  }
}
