package day399;

import java.io.*;
import java.util.*;

public class Day392BOJ16395파스칼삼각형 {
  static int N, K;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dp = new int[N + 1][N + 1];
    dp[1][1] = 1;
    for (int i = 2; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }
    System.out.print(dp[N][K]);
  }
}
