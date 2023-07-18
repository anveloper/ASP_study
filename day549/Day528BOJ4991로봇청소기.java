package day549;

import java.io.*;
import java.util.*;

public class Day528BOJ4991로봇청소기 {
  static int[] dr = { 0, 1, 0, -1 }, dc = { -1, 0, 1, 0 };
  static int ans = Integer.MAX_VALUE;
  static boolean[] check;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      ans = Integer.MAX_VALUE;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int C = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());
      if (R + C == 0)
        break;

      char[][] map = new char[R][C];
      Dot[] dusts = new Dot[11];
      int idx = 1;

      for (int i = 0; i < R; i++) {
        String str = br.readLine();
        for (int j = 0; j < C; j++) {
          map[i][j] = str.charAt(j);
          if (map[i][j] == 'o') {
            dusts[0] = new Dot(j, i);
          } else if (map[i][j] == '*') {
            dusts[idx++] = new Dot(j, i);
          }
        }
      }
      ArrayList<Node>[] list = new ArrayList[idx];
      for (int i = 0; i < idx; i++) {
        list[i] = new ArrayList<Node>();
      }

      for (int start = 0; start < idx - 1; start++) {
        for (int end = start + 1; end < idx; end++) {
          int weight = BFS(dusts[start], dusts[end], R, C, map);
          if (weight == -1)
            continue;
          list[start].add(new Node(end, weight));
          list[end].add(new Node(start, weight));
        }
      }
      check = new boolean[idx];
      check[0] = true;
      Permutation(0, 0, list, 0, idx);
      System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
  }

  static void Permutation(int start, int depth, ArrayList<Node>[] adj_list, int sum, int dusts) {
    if (depth == dusts - 1) {
      ans = Math.min(ans, sum);
      return;
    }

    for (Node next : adj_list[start]) {
      if (check[next.end])
        continue;
      check[next.end] = true;
      Permutation(next.end, depth + 1, adj_list, sum + next.weight, dusts);
      check[next.end] = false;
    }
  }

  static int BFS(Dot start, Dot end, int R, int C, char[][] map) {
    Queue<Dot> q = new LinkedList<>();
    boolean[][] visit = new boolean[R][C];
    q.offer(new Dot(start.r, start.c, 0));
    visit[start.c][start.r] = true;

    while (!q.isEmpty()) {
      Dot d = q.poll();

      if (d.c == end.c && d.r == end.r) {
        return d.cnt;
      }
      for (int i = 0; i < 4; i++) {
        int nr = d.r + dr[i];
        int nc = d.c + dc[i];
        if (nr < 0 || nr >= C || nc < 0 || nc >= R || visit[nc][nr] || map[nc][nr] == 'x')
          continue;
        q.offer(new Dot(nr, nc, d.cnt + 1));
        visit[nc][nr] = true;
      }
    }
    return -1;
  }

  static class Dot {
    int r;
    int c;
    int cnt;

    Dot(int r, int c) {
      this.r = r;
      this.c = c;
    }

    Dot(int r, int c, int cnt) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
    }
  }

  static class Node {
    int end;
    int weight;

    Node(int end, int weight) {
      this.end = end;
      this.weight = weight;
    }
  }
}