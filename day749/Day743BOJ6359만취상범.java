package day749;

import java.util.*;

public class Day743BOJ6359만취상범 {

  static int N;
  static int[] d;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int t = sc.nextInt();
    for (int tc = 1; tc <= t; tc++) {
      N = sc.nextInt();
      d = new int[N + 1];
      for (int i = 1; i <= N; i++) {
        for (int j = 1; i * j <= N; j++) {
          if (d[i * j] != 0)
            d[i * j] = 0;
          else
            d[i * j] = 1;
        }
      }
      int ans = 0;
      for (int i = 1; i <= N; i++) {
        ans += d[i];
      }
      sb.append(ans + "\n");
    }
    System.out.println(sb);
    sc.close();
  }
}