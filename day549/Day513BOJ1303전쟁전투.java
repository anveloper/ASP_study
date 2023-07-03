package day549;

import java.util.*;
import java.io.*;

public class Day513BOJ1303전쟁전투 {
  static int N, M, cnt, white = 0, black = 0;
  static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
  static char[][] map;
  static boolean[][] visited;
  static Queue<Node> q = new LinkedList<>();

  static class Node {
    int r, c;

    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[M][N];

    map = new char[M][N];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      String temp = st.nextToken();

      for (int j = 0; j < N; j++) {
        char ch = temp.charAt(j);
        map[i][j] = ch;
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {

        if (visited[i][j] == false) {

          if (map[i][j] == 'W') {
            white += bfs(i, j, 'W');
          } else {
            black += bfs(i, j, 'B');
          }

        }
      }
    }

    System.out.println(white + " " + black);
  }

  static int bfs(int y, int x, char ch) {
    q.offer(new Node(y, x));
    cnt = 1;
    visited[y][x] = true;

    while (!q.isEmpty()) {
      check(ch);
    }

    return cnt * cnt;
  }

  static void check(char ch) {
    Node cur = q.poll();

    for (int i = 0; i < 4; i++) {

      int nr = cur.r + dr[i];
      int nc = cur.c + dc[i];

      if (nr >= 0 && nr < M && nc >= 0 && nc < N) {

        if (visited[nr][nc] == false && ch == map[nr][nc]) {

          q.offer(new Node(nr, nc));
          visited[nr][nc] = true;
          cnt++;
        }
      }
    }
  }
}