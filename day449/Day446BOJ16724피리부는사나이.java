package day449;

import java.io.*;
import java.util.*;

public class Day446BOJ16724피리부는사나이 {

  static int N, M, ans;
  static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
  static int[][] map;
  static boolean[][] visit, finish;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        int c = line.charAt(j);
        if (c == 'U')
          map[i][j] = 0;
        else if (c == 'D')
          map[i][j] = 1;
        else if (c == 'L')
          map[i][j] = 2;
        else if (c == 'R')
          map[i][j] = 3;
      }
    }

    visit = new boolean[N][M];
    finish = new boolean[N][M];
    ans = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visit[i][j])
          dfs(i, j);
      }
    }

    System.out.println(ans);

  }

  public static void dfs(int r, int c) {
    visit[r][c] = true;
    int nr = r + dr[map[r][c]];
    int nc = c + dc[map[r][c]];

    if (!visit[nr][nc]) {
      dfs(nr, nc);
    } else {
      if (!finish[nr][nc])
        ans++;
    }
    finish[r][c] = true;
  }
}
