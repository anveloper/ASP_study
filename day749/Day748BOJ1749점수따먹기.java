package day749;

import java.io.*;
import java.util.*;

public class Day748BOJ1749점수따먹기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int rows = Integer.parseInt(st.nextToken());
    int cols = Integer.parseInt(st.nextToken());
    long[][] m = new long[rows + 1][cols + 1];
    for (int i = 1; i <= rows; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j <= cols; j++) {
        m[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        m[i][j] = m[i - 1][j] + m[i][j - 1] - m[i - 1][j - 1] + m[i][j];
      }
    }

    long ans = Long.MIN_VALUE;
    for (int c1 = 1; c1 <= cols; c1++) {
      for (int c2 = c1; c2 <= cols; c2++) {
        long last = 0;
        for (int r = 1; r <= rows; r++) {
          long sum = m[r][c2] - m[r][c1 - 1] - m[r - 1][c2] + m[r - 1][c1 - 1];
          last = max(last + sum, sum);
          ans = max(ans, last);
        }
      }
    }

    System.out.println(ans);
  }

  static long max(long a, long b) {
    return a > b ? a : b;
  }
}