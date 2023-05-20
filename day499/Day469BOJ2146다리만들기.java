package day499;

import java.util.*;
import java.io.*;

public class Day469BOJ2146다리만들기 {
  static boolean[][] visited;
  static int[][] arr, len;
  static int N, M, cnt;
  static StringBuilder sb = new StringBuilder();
  static Queue<int[]> q = new LinkedList<>();
  static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    visited = new boolean[N][N];
    arr = new int[N][N];
    len = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int no = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] == 0 || visited[i][j])
          continue;
        no++;
        dfs(i, j, no);
      }
    }
    bfs();
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int d = 0; d < 4; d++) {
          int nr = i + dr[d];
          int nc = j + dc[d];
          if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[i][j] == arr[nr][nc])
            continue;
          ans = Math.min(ans, len[i][j] + len[nr][nc]);
        }
      }
    }
    System.out.println(ans);
  }

  private static void dfs(int y, int x, int no) {
    visited[y][x] = true;
    arr[y][x] = no;
    q.offer(new int[] { y, x });
    for (int i = 0; i < 4; i++) {
      int ny = y + dr[i];
      int nx = x + dc[i];
      if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || arr[ny][nx] == 0)
        continue;
      dfs(ny, nx, no);
    }
  }

  private static void bfs() {
    while (!q.isEmpty()) {
      int size = q.size();
      cnt++;
      for (int j = 0; j < size; j++) {
        int[] cur = q.poll();
        for (int i = 0; i < 4; i++) {
          int nr = cur[0] + dr[i];
          int nc = cur[1] + dc[i];
          if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 0)
            continue;
          q.offer(new int[] { nr, nc });
          len[nr][nc] = cnt;
          arr[nr][nc] = arr[cur[0]][cur[1]];
        }
      }
    }
  }
}
