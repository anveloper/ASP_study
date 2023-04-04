package day449;

import java.io.*;
import java.util.*;

public class Day423BOJ21672차원배열의합 {
  static int N, M, K;
  static int[] sum;
  static int[][] arr, dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N + 1][M + 1];
    dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = arr[i][j] + dp[i][j - 1];
      }
    }

    K = Integer.parseInt(br.readLine());
    sum = new int[K];

    for (int t = 0; t < K; t++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int row = i; row <= x; row++) {
        sum[t] += dp[row][y] - dp[row][j - 1];
      }
      sb.append(sum[t]).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
