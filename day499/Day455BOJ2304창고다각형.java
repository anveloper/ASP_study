package day499;

import java.io.*;
import java.util.*;

public class Day455BOJ2304창고다각형 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[] roof = new int[1001];
    int N = Integer.parseInt(br.readLine());
    int idx = 0;
    int max = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      if (max < h) {
        max = h;
        idx = l;
      }
      roof[l] = h;
    }

    int ans = max;
    int cur = 0;
    for (int i = 0; i < idx; i++) {
      if (cur < roof[i])
        cur = roof[i];
      ans += cur;
    }

    cur = 0;
    for (int i = 1000; i > idx; i--) {
      if (cur < roof[i])
        cur = roof[i];
      ans += cur;
    }
    System.out.println(ans);
  }
}
