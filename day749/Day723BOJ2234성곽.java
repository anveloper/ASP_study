package day749;

import java.io.*;
import java.util.*;

public class Day723BOJ2234성곽 {
  static int N, M;
  static int max = 0;
  static int[] area, dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
  static int[][] room, arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);

    arr = new int[M][N];
    room = new int[M][N];
    area = new int[2501];

    for (int i = 0; i < M; i++) {
      str = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }

    int c = 1;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (room[i][j] == 0) {
          bfs(new Pos(i, j), c);
          max = Math.max(max, area[c]);
          c++;
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 4; k++) {
          int nr = i + dr[k];
          int nc = j + dc[k];

          if ((0 <= nr && nr < M) && (0 <= nc && nc < N) && room[i][j] != room[nr][nc]) {
            sum = Math.max(sum, area[room[i][j]] + area[room[nr][nc]]);
          }
        }
      }
    }

    bw.write((c - 1) + "\n" + max + "\n" + sum + "\n");
    bw.flush();
  }

  public static void bfs(Pos st, int c) {
    Queue<Pos> q = new LinkedList<>();

    q.offer(st);
    room[st.r][st.c] = c;

    while (!q.isEmpty()) {
      Pos pos = q.poll();
      area[c]++;

      int num = arr[pos.r][pos.c];
      for (int i = 0; i < 4; i++) {
        Pos p;
        if (num % 2 == 0) {
          switch (i) {
            case 0:
              p = new Pos(pos.r, pos.c - 1);
              break;
            case 1:
              p = new Pos(pos.r - 1, pos.c);
              break;
            case 2:
              p = new Pos(pos.r, pos.c + 1);
              break;
            default:
              p = new Pos(pos.r + 1, pos.c);
              break;
          }
          if ((0 <= p.r && p.r < M) && (0 <= p.c && p.c < N) && room[p.r][p.c] == 0) {
            q.offer(p);
            room[p.r][p.c] = c;
          }
        }
        num = num / 2;
      }

    }

  }

  static class Pos {
    int r, c;

    Pos(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}