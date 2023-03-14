package day449;

import java.util.*;
import java.io.*;

public class Day402BOJ9466텀프로젝트 {
  static int T, N, cnt;
  static int[] arr;
  static boolean[] visit, check;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    T = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < T; tc++) {
      N = Integer.parseInt(br.readLine());
      arr = new int[N + 1];
      visit = new boolean[N + 1];
      check = new boolean[N + 1];
      cnt = 0;

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i < N + 1; i++)
        arr[i] = Integer.parseInt(st.nextToken());

      for (int i = 1; i < N + 1; i++)
        dfs(i);
      sb.append(N - cnt).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  static void dfs(int cur) {
    if (visit[cur])
      return;
    visit[cur] = true;
    int next = arr[cur];
    if (!visit[next])
      dfs(next);
    else {
      if (!check[next]) {
        cnt++;
        for (int i = next; i != cur; i = arr[i])
          cnt++;
      }
    }
    check[cur] = true;
  }
}
