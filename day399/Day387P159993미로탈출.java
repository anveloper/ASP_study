package day399;

import java.util.*;

class Solution { // 런타임 에러..?
  static int N, M, cnt = 0;
  static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
  static char[][] map;
  static Queue<int[]> q;
  static boolean[][] visited;

  public static int solution(String[] maps) {
    map = new char[N = maps.length][M = maps[0].length()];

    int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
    for (int i = 0; i < M; i++) {
      String tmp = maps[i];
      for (int j = 0; j < M; j++) {
        map[i][j] = tmp.charAt(j);
        if (map[i][j] == 'S') {
          r1 = i;
          c1 = j;
        } else if (map[i][j] == 'L') {
          r2 = i;
          c2 = j;
        }
      }
    }
    bfs(r1, c1, 'L');
    bfs(r2, c2, 'E');
    return cnt;
  }

  private static int bfs(int idx, int jdx, char g) {
    if (cnt == -1)
      return cnt;

    q = new LinkedList<>();
    visited = new boolean[N][M];

    q.offer(new int[] { idx, jdx, cnt });
    visited[idx][jdx] = true;

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int r = cur[0], c = cur[1], t = cur[2];

      if (map[r][c] == g)
        return cnt = t;

      for (int dir = 0; dir < 4; dir++) {
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        if (index(nr, nc))
          continue;
        if (visited[nr][nc])
          continue;
        if (map[nr][nc] == 'X')
          continue;
        q.offer(new int[] { nr, nc, t + 1 });
        visited[nr][nc] = true;
      }
    }

    return cnt = -1; // while문 내부에서 return 되지 않으면
  }

  private static boolean index(int nr, int nc) {
    return nr < 0 || nr >= N || nc < 0 || nc >= M;
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[] { "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE" }));
    System.out.println(solution(new String[] { "LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO" }));
  }
}
