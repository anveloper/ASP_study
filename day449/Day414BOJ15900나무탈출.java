package day449;

import java.io.*;
import java.util.*;

public class Day414BOJ15900나무탈출 {
  static int ans = 0;
  static List<Integer>[] list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    list = new LinkedList[N + 1];

    for (int i = 1; i <= N; i++) {
      list[i] = new LinkedList<Integer>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      list[a].add(b);
      list[b].add(a);
    }

    dfs(1, 0, 0);

    System.out.println((ans % 2) == 0 ? "No" : "Yes");
    br.close();
  }

  public static void dfs(int cur, int p, int cnt) {
    for (int next : list[cur]) {
      if (next != p) {
        dfs(next, cur, cnt + 1);
      }
    }

    if (list[cur].size() == 1) {
      ans += cnt;
    }
  }
}
