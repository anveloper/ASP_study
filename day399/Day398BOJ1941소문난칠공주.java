package day399;

import java.io.*;
import java.util.*;

public class Day398BOJ1941소문난칠공주 {
  static int N = 5, cnt = 0, ans = 0;
  static int[] sel = new int[7];
  static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
  static char[][] map = new char[N][];
  static boolean[] visited = new boolean[N * N];
  static Queue<Integer> q;
  static ArrayList<Integer> tmp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < N; i++)
      map[i] = br.readLine().toCharArray();

    dfs(0, 0);
    System.out.println(ans);
    br.close();
  }

  private static void dfs(int d, int st) {
    if (d == 7) {
      if (bfs())
        ans++;
      return;
    }
    for (int i = st; i < N * N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        sel[d] = i;
        dfs(d + 1, i + 1);
        visited[i] = false;
      }
    }
  }

  private static boolean bfs() {
    cnt = 0;
    tmp = new ArrayList<>();
    q = new LinkedList<>();
    for (int i : sel) {
      tmp.add(i);
      if (map[i / 5][i % 5] == 'Y')
        cnt++;
    }
    if (cnt > 3)
      return false;

    q.offer(sel[0]);
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nr = cur / 5 + dr[dir];
        int nc = cur % 5 + dc[dir];
        if (index(nr, nc))
          continue;
        int nxt = nr * 5 + nc;
        if (tmp.contains(nxt)) {
          tmp.remove(tmp.indexOf(nxt));
          q.offer(nxt);
        }
      }
    }

    return tmp.isEmpty();
  }

  private static boolean index(int nr, int nc) {
    return nr < 0 || nr >= N || nc < 0 || nc >= N;
  }
}
