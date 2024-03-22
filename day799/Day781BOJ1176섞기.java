package day799;

import java.io.*;
import java.util.*;

public class Day781BOJ1176섞기 {
  static int N, M, K;
  static int[] height;
  static long[][] memo;
  static Map<Integer, Integer> map;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    M = 1 << N;

    height = new int[M];

    for (int i = 0; i < N; i++) {
      height[1 << i] = Integer.parseInt(br.readLine());
    }

    map = new HashMap<>();
    for (int i = 0; i < N; i++)
      map.put(1 << i, i);

    memo = new long[M][N];

    long ans = 0;

    for (int i = 0; i < N; i++) {
      ans += dfs(1 << i, 1 << i, i);
    }

    System.out.println(ans);
  }

  static long dfs(int used, int last, int i) {

    if (used == M - 1)
      return 1;

    if (memo[used][i] > 0)
      return memo[used][i];

    int able = (M - 1) & ~used;

    long res = 0;

    while (able > 0) {
      int p = able & -able;
      able -= p;

      if (Math.abs(height[last] - height[p]) > K)
        res += dfs(used | p, p, map.get(p));
    }

    return memo[used][i] = res;
  }
}