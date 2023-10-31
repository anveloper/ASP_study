package day649;

import java.io.*;
import java.util.*;

public class Day635BOJ3184양 {
  static int R, C, W, S, wolf, sheep;
  static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 };
  static char[][] arr;
  static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    S = 0;
    W = 0;

    arr = new char[R][C];
    visited = new boolean[R][C];

    for (int i = 0; i < R; i++) {
      String input = br.readLine();
      for (int j = 0; j < C; j++) {
        arr[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        wolf = 0;
        sheep = 0;
        if (!visited[i][j]) {
          if (arr[i][j] == 'v' || arr[i][j] == '.' || arr[i][j] == 'o') {
            solve(i, j);
          }
        }
        if (sheep > wolf) {
          wolf = 0;
        } else {
          sheep = 0;
        }
        W += wolf;
        S += sheep;
      }
    }
    sb.append(S).append(" ").append(W);
    bw.write(sb.toString());
    bw.flush();

    bw.close();
    br.close();
  }

  private static void solve(int r, int c) {
    visited[r][c] = true;

    if (arr[r][c] == 'o') {
      sheep += 1;
    } else if (arr[r][c] == 'v') {
      wolf += 1;
    }

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
        if (!visited[nr][nc]) {
          if (arr[nr][nc] == '.' || arr[nr][nc] == 'v' || arr[nr][nc] == 'o') {
            solve(nr, nc);
          }
        }
      }
    }
  }
}