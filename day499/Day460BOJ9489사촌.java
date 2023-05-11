package day499;

import java.io.*;
import java.util.*;

public class Day460BOJ9489사촌 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      if (n == 0 && k == 0)
        break;

      int levels[] = new int[n + 1];
      levels[0] = -1;

      int idx = 0;
      int level = -1;
      int prev = -1;

      st = new StringTokenizer(br.readLine());

      for (int i = 1; i <= n; i++) {
        int num = Integer.parseInt(st.nextToken());

        if (num == k)
          idx = i;

        if (num != prev + 1)
          ++level;

        levels[i] = level;
        prev = num;
      }

      int ans = 0;

      for (int i = 1; i <= n; i++) {
        if (levels[i] != levels[idx] && levels[levels[i]] == levels[levels[idx]])
          ++ans;
      }
      sb.append(ans).append('\n');
    }

    System.out.println(sb);
    br.close();
  }
}
