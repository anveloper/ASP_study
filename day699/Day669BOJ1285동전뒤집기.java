package day699;

import java.io.*;

public class Day669BOJ1285동전뒤집기 {
  static int n;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        char c = s.charAt(j);
        if (c == 'T') {
          map[i][j] = 1;
        }
      }
    }

    int ans = 400;
    for (int bit = 0; bit < (1 << n) - 1; bit++) {
      int sum = 0;

      for (int x = 0; x < n; x++) {
        int tail = 0;

        for (int y = 0; y < n; y++) {
          int cur = map[y][x];
          if ((bit & (1 << y)) != 0) {
            cur = flip(y, x);
          }
          if (cur == 1)
            tail++;
        }
        sum += Math.min(tail, n - tail);
      }
      if (ans > sum)
        ans = sum;
    }
    System.out.println(ans);
    br.close();
  }

  private static int flip(int y, int x) {
    return map[y][x] ^ 1;
  }
}