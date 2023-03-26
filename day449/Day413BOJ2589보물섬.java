package day449;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day413BOJ2589보물섬 {
  static int N, M, ans = 0;
  static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
  static char[][] map;
  static boolean[][] visited;
  static Queue<int[]> q;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new char[N][M];

    for (int i = 0; i < N; i++)
      map[i] = br.readLine().toCharArray();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'L')
          ans = Math.max(ans, bfs(i, j));
      }
    }
    System.out.println(ans);
    br.close();
  }

  private static int bfs(int i, int j) {
    int cnt = 0;
    q = new LinkedList<>();
    visited = new boolean[N][M];

    q.add(new int[] { i, j, 0 });
    visited[i][j] = true;
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nr = cur[0] + dr[dir];
        int nc = cur[1] + dc[dir];
        int c = cur[2] + 1;
        if (index(nr, nc))
          continue;
        if (visited[nr][nc])
          continue;
        if (map[nr][nc] != 'L')
          continue;
        q.add(new int[] { nr, nc, c });
        visited[nr][nc] = true;
        cnt = Math.max(cnt, c);
      }
    }
    return cnt;
  }

  private static boolean index(int nr, int nc) {
    return nr < 0 || nr >= N || nc < 0 || nc >= M;
  }
}
