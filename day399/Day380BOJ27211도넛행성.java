package day399;

import java.io.*;
import java.util.*;

public class Day380BOJ27211도넛행성 {
  static int N, M, ans = 0;
  static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
  static int[][] map;
  static Queue<int[]> q;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (map[i][j] == 0)
          bfs(i, j);

    System.out.println(ans);
    br.close();
  }

  private static void bfs(int idx, int jdx) {
    ans++;
    q = new LinkedList<>();
    map[idx][jdx] = ans;
    q.offer(new int[] { idx, jdx });
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int nr = (cur[0] + dr[dir] + N) % N;
        int nc = (cur[1] + dc[dir] + M) % M;

        if (map[nr][nc] == 0) {
          map[nr][nc] = ans;
          q.offer(new int[] { nr, nc });
        }
      }
    }
  }
}
