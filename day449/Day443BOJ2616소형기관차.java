package day449;

import java.io.*;
import java.util.*;

public class Day443BOJ2616소형기관차 {
  static int N, max;
  static int[] arr, sum;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    sum = new int[N + 1];
    dp = new int[4][N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i - 1] + arr[i];
    }

    max = Integer.parseInt(br.readLine());

    for (int i = 1; i < 4; i++) {
      for (int j = i * max; j <= N; j++) {
        dp[i][j] = Math.max(
            dp[i][j - 1],
            dp[i - 1][j - max] + (sum[j] - sum[j - max]));
      }
    }

    System.out.println(dp[3][N]);
  }
}