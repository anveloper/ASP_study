package day399;

import java.io.*;
import java.util.*;

public class Day390BOJ1535안녕 {
  static int N, max = 99;
  static int[] L, J;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    L = new int[N + 1];
    J = new int[N + 1];
    dp = new int[N + 1][max + 1];

    for (int i = 1; i <= N; i++) {
      L[i] = Integer.parseInt(st.nextToken());
      J[i] = Integer.parseInt(st2.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= max; j++) {
        if (L[i] <= j) {
          dp[i][j] = Math.max(dp[i - 1][j - L[i]] + J[i], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    System.out.print(dp[N][max]);
  }
}
