package day449;

import java.io.*;

public class Day438BOJ15989더하기DP {
  static int N;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    dp = new int[10001][4];
    dp[1][1] = 1;
    dp[2][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;

    for (int i = 4; i <= 10000; i++) {
      dp[i][1] = dp[i - 1][1];
      dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
      dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
    }

    for (int i = 0; i < N; i++) {
      int t = Integer.parseInt(br.readLine());
      sb.append(dp[t][1] + dp[t][2] + dp[t][3] + "\n");
    }
    System.out.println(sb);
  }
}
