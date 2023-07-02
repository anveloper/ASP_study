package day549;

import java.io.*;
import java.util.*;

public class Day511BOJ1600말원숭이 {
  static int k, w, h;
  static int min = Integer.MAX_VALUE;
  static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
  static int[] hdr = { -2, -2, -1, -1, 1, 1, 2, 2 }, hdc = { -1, 1, -2, 2, -2, 2, -1, 1 };
  static int[][] board;
  static boolean[][][] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[h][w][k + 1];
    min = bfs(0, 0);

    if (min == Integer.MAX_VALUE)
      System.out.println("-1");
    else
      System.out.println(min);
  }

  public static int bfs(int x, int y) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y, 0, k));
    visited[x][y][k] = true;

    while (!q.isEmpty()) {
      Node curr = q.poll();
      if (curr.r == h - 1 && curr.c == w - 1)
        return curr.cnt;

      for (int i = 0; i < 4; i++) {
        int nr = curr.r + dr[i];
        int nc = curr.c + dc[i];
        if (nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc][curr.k] && board[nr][nc] == 0) {
          visited[nr][nc][curr.k] = true;
          q.offer(new Node(nr, nc, curr.cnt + 1, curr.k));
        }
      }

      if (curr.k > 0) {
        for (int i = 0; i < 8; i++) {
          int nx = curr.r + hdr[i];
          int ny = curr.c + hdc[i];
          if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][curr.k - 1] && board[nx][ny] == 0) {
            visited[nx][ny][curr.k - 1] = true;
            q.offer(new Node(nx, ny, curr.cnt + 1, curr.k - 1));
          }
        }
      }
    }
    return min;
  }

  public static class Node {
    int r, c, cnt, k;

    public Node(int r, int c, int cnt, int k) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
      this.k = k;
    }
  }
}
