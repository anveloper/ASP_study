package day749;

import java.io.*;
import java.util.*;

public class Day710BOJ2548대표자연수 {
  private static final int LIMIT = 10000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] sum = new int[LIMIT + 1];
    int[] cnt = new int[LIMIT + 1];
    for (int i = 1; i <= n; i++) {
      int cur = Integer.parseInt(st.nextToken());
      sum[cur] += cur;
      cnt[cur]++;
    }
    for (int i = 1; i <= LIMIT; i++) {
      sum[i] += sum[i - 1];
      cnt[i] += cnt[i - 1];
    }
    int min = Integer.MAX_VALUE;
    int ans = 0;
    for (int i = 1; i <= LIMIT; i++) {
      if (cnt[i] - cnt[i - 1] == 0)
        continue;
      int calc = (i * cnt[i - 1] - sum[i - 1]) + (sum[LIMIT] - sum[i] - i * (cnt[LIMIT] - cnt[i]));
      if (min > calc) {
        min = calc;
        ans = i;
      }
    }
    System.out.println(ans);
  }
}