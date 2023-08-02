package day549;

import java.util.*;
import java.io.*;

public class Day543BOJ1926그림 {
  static int N, M;
  static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
  static int[][] arr;
  static boolean[][] visit;
  static Queue<Pair> qu;

  public static void main(String args[]) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    visit = new boolean[N][M];
    qu = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count = 0;
    int area = 0;
    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 0 || visit[i][j]) {
          continue;
        }
        count++;
        qu.offer(new Pair(i, j));
        visit[i][j] = true;
        area = 0;
        while (!qu.isEmpty()) {
          Pair p = qu.poll();
          area++;
          for (int k = 0; k < 4; k++) {
            int nr = p.x + dr[k];
            int nc = p.y + dc[k];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
              continue;
            }
            if (arr[nr][nc] == 1 && !visit[nr][nc]) {
              qu.offer(new Pair(nr, nc));
              visit[nr][nc] = true;
            }
          }
        }
        if (area > max) {
          max = area;
        }
      }

    }
    System.out.println(count);
    System.out.println(max);
  }

  public static class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}