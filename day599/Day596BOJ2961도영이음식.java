package day599;

import java.io.*;
import java.util.*;

public class Day596BOJ2961도영이음식 {
  static int ans;
  static boolean[] sel;
  static int[][] arr;
  static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    sel = new boolean[N];
    ans = Integer.MAX_VALUE;
    arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    subSet(0, 1, 0);

    System.out.println(ans);
  }

  public static void subSet(int cnt, int mul, int sum) {
    if (cnt == N) {
      int c = 0;
      for (int i = 0; i < N; i++) {
        if (sel[i])
          continue;
        c++;
      }
      if (c == N)
        return;
      ans = Math.min(ans, Math.abs(mul - sum));
      return;
    }

    sel[cnt] = true;
    subSet(cnt + 1, mul * arr[cnt][0], sum + arr[cnt][1]);
    sel[cnt] = false;
    subSet(cnt + 1, mul, sum);
  }
}