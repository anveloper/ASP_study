package day749;

import java.io.*;
import java.util.*;

public class Day746BOJ4256트리 {
  static StringBuilder sb = new StringBuilder();
  static int[] pre;
  static int[] in;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {
      int n = Integer.parseInt(br.readLine());
      pre = new int[n];
      in = new int[n];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        pre[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        in[i] = Integer.parseInt(st.nextToken());
      }

      post(0, 0, n - 1);
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static void post(int r, int start, int end) {
    int rootIdx = -1;
    for (int i = start; i <= end; i++) {
      if (pre[r] == in[i]) {
        rootIdx = i;
        break;
      }
    }
    if (rootIdx == -1) {
      return;
    }
    post(r + 1, start, rootIdx - 1);
    post(r + rootIdx - start + 1, rootIdx + 1, end);
    sb.append(pre[r]).append(" ");
  }
}