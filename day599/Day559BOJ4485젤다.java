package day599;

import java.io.*;
import java.util.*;

public class Day559BOJ4485젤다 {

  static class point implements Comparable<point> {

    int row, col, cost;

    public point(int row, int col, int cost) {
      super();
      this.row = row;
      this.col = col;
      this.cost = cost;
    }

    @Override
    public int compareTo(point o) {
      return this.cost - o.cost;
    }

  }

  static int N;
  static int[][] map;
  static int[][] dijk;
  static int[] dy = { 0, 1, -1, 0 };
  static int[] dx = { 1, 0, 0, -1 };

  // 범위 검사
  static boolean isValid(int x, int y) {
    if (x < 0 || x >= N || y < 0 || y >= N)
      return false;
    return true;
  }

  public static int dijkstra() {
    PriorityQueue<point> pq = new PriorityQueue<point>();
    dijk[0][0] = map[0][0];
    pq.offer(new point(0, 0, map[0][0]));

    while (!pq.isEmpty()) {
      point p = pq.poll();

      for (int k = 0; k < 4; k++) {
        int nextRow = p.row + dy[k];
        int nextCol = p.col + dx[k];

        if (isValid(nextRow, nextCol)) {
          if (dijk[nextRow][nextCol] > dijk[p.row][p.col] + map[nextRow][nextCol]) { // 기존의 가중치보다 작은 경우
            dijk[nextRow][nextCol] = dijk[p.row][p.col] + map[nextRow][nextCol]; // 가중치를 교환
            pq.offer(new point(nextRow, nextCol, dijk[nextRow][nextCol])); // 큐에 추가
          }
        }
      }
    }
    return dijk[N - 1][N - 1];
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;
    int cnt = 0;
    while (true) {

      N = Integer.parseInt(br.readLine());
      if (N == 0)
        break;
      map = new int[N][N];
      dijk = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
          dijk[i][j] = Integer.MAX_VALUE;
        }
      }
      cnt++;
      sb.append("Problem " + cnt + ": " + dijkstra() + "\n"); // 출력문
    }

    System.out.println(sb);
    br.close();
  }
}
