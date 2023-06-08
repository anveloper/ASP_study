package day499;

import java.io.*;
import java.util.*;

public class Day488BOJ1194달이차오른다 {
  static int N, M;
  static char[][] board;
  static Node start;
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new char[N][M];
    for (int i = 0; i < N; i++) {
      str = br.readLine();
      for (int j = 0; j < M; j++) {
        char c = str.charAt(j);
        board[i][j] = c;
        if (c == '0')
          start = new Node(i, j, 0, 0);
      }
    }
    System.out.println(bfs());
  }

  public static int bfs() {
    Queue<Node> q = new LinkedList<>();
    boolean[][][] visited = new boolean[N][M][64];
    q.offer(start);
    visited[start.r][start.c][0] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();
      if (board[cur.r][cur.c] == '1')
        return cur.cost;

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (nr < 0 || nc < 0 || nr >= N || nc >= M)
          continue;
        if (visited[nr][nc][cur.key] || board[nr][nc] == '#')
          continue;

        if (board[nr][nc] >= 'a' && board[nr][nc] <= 'f') { // 열쇠
          int next_key = 1 << (board[nr][nc] - 'a');
          next_key = cur.key | next_key;
          visited[nr][nc][next_key] = true;
          q.offer(new Node(nr, nc, cur.cost + 1, next_key));
        } else if (board[nr][nc] >= 'A' && board[nr][nc] <= 'F') { // 문
          if ((cur.key & 1 << (board[nr][nc] - 'A')) == (int) Math.pow(2, board[nr][nc] - 'A')) { // 해당 비트가 켜져있는지 확인
            visited[nr][nc][cur.key] = true;
            q.offer(new Node(nr, nc, cur.cost + 1, cur.key));
          }
        } else {
          visited[nr][nc][cur.key] = true;
          q.offer(new Node(nr, nc, cur.cost + 1, cur.key));
        }
      }
    }
    return -1;
  }

  public static class Node {
    int r, c, cost, key;

    public Node(int r, int c, int cost, int key) {
      this.r = r;
      this.c = c;
      this.cost = cost;
      this.key = key;
    }
  }
}
