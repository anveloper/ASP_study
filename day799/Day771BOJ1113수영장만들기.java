package day799;

import java.io.*;
import java.util.*;

public class Day771BOJ1113수영장만들기 {
  static int N, M, ans;
  static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[][] board = new int[N][M];
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = s.charAt(j) - '0';
      }
    }
    boolean[][] v = new boolean[N][M];
    for (int k = 1; k <= 9; k++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (board[i][j] == k && !v[i][j]) {
            v[i][j] = true;
            BFS(new int[] { i, j }, board, v, k);
          }
        }
      }
    }
    System.out.println(ans);
  }

  public static void BFS(int[] start, int[][] board, boolean[][] v, int num) {
    Queue<int[]> q = new LinkedList<int[]>();
    q.add(start);
    List<int[]> candi = new ArrayList<int[]>();
    candi.add(start);
    int minHeight = Integer.MAX_VALUE;
    boolean flood = false;
    while (!q.isEmpty()) {
      int[] now = q.poll();
      if (now[0] == 0 || now[0] == N - 1 || now[1] == 0 || now[1] == M - 1) {
        flood = true;
      }
      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dx[d];
        int ny = now[1] + dy[d];
        if (0 <= nx && nx < N && 0 <= ny && ny < M) {
          if (!v[nx][ny] && board[nx][ny] == num) {
            v[nx][ny] = true;
            q.add(new int[] { nx, ny });
            candi.add(new int[] { nx, ny });
          }
          if (board[nx][ny] < num) {
            flood = true;
          }
          if (board[nx][ny] > num) {
            minHeight = Math.min(minHeight, board[nx][ny]);
          }
        }
      }
    }

    if (!flood) {

      ans += candi.size() * (minHeight - num);
      for (int i = 0; i < candi.size(); i++) {
        int[] now = candi.get(i);
        board[now[0]][now[1]] = minHeight;
        v[now[0]][now[1]] = false;
      }
    }
  }
}