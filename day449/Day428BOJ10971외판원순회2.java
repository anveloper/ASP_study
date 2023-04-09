package day449;

import java.io.*;
import java.util.*;

public class Day428BOJ10971외판원순회2 {
  static long ans = Integer.MAX_VALUE;
  static int N;
  static int[][] map;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      visited[i] = true;
      dfs(i, i, 0);
    }
    System.out.println(ans);
    br.close();
  }

  public static void dfs(int start, int now, long cost) {
    if (check()) {
      if (map[now][start] != 0)
        ans = Math.min(ans, cost + map[now][0]);
      return;
    }

    for (int i = 1; i < N; i++) {
      if (!visited[i] && map[now][i] != 0) {
        visited[i] = true;
        dfs(start, i, cost + map[now][i]);
        visited[i] = false;
      }
    }
  }

  public static boolean check() {
    for (int i = 0; i < N; i++)
      if (!visited[i])
        return false;
    return true;
  }
}
