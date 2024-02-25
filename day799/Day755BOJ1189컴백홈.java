package day799;

import java.io.*;
import java.util.*;

public class Day755BOJ1189컴백홈 {

  static int R, C, K, ans;
  static char[][] map;
  static int[][] visited;

  static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new char[R][C];
    visited = new int[R][C];

    for (int i = 0; i < R; i++) {
      String s = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    visited[R - 1][0] = 1;
    dfs(R - 1, 0, 1);

    System.out.println(ans);
  }

  static void dfs(int r, int c, int moved) {
    if (r == 0 && c == C - 1) {
      if (moved == K) {
        ans++;
      }
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
        continue;
      }
      if (visited[nr][nc] == 1 || map[nr][nc] == 'T') {
        continue;
      }
      visited[nr][nc] = 1;
      dfs(nr, nc, moved + 1);
      visited[nr][nc] = 0;
    }
  }
}
