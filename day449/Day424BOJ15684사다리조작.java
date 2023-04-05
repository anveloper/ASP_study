package day449;

import java.io.*;
import java.util.*;

public class Day424BOJ15684사다리조작 {
  static int N, M, H, ans = 0;
  static int[][] arr;
  static boolean flag = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    arr = new int[H + 1][N + 1];

    if (M != 0) {
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr[a][b] = 1;
        arr[a][b + 1] = 2;
      }
    }
    for (int i = 0; i <= 3; i++) {
      ans = i;
      dfs(1, 0);
      if (flag) {
        break;
      }
    }

    if (flag) {
      System.out.println(ans);
      return;
    }
    if (ans > 3) {
      System.out.println(-1);
    } else {
      System.out.println(-1);
    }
  }

  private static void dfs(int x, int depth) {
    if (ans == depth) {
      if (check()) {
        flag = true;
      }
      return;
    }

    for (int i = x; i <= H; i++) {
      for (int j = 1; j < N; j++) {
        if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
          arr[i][j] = 1;
          arr[i][j + 1] = 2;

          dfs(i, depth + 1);

          arr[i][j] = 0;
          arr[i][j + 1] = 0;
        }
      }
    }
  }

  private static boolean check() {
    for (int i = 1; i <= N; i++) {
      int nx = i;
      int ny = 1;
      while (ny <= H) {
        if (arr[ny][nx] == 1) {
          nx++;
        } else if (arr[ny][nx] == 2) {
          nx--;
        }
        ny++;
      }
      if (nx != i) {
        return false;
      }
    }
    return true;
  }
}
