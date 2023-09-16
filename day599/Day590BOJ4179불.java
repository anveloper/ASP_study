package day599;

import java.io.*;
import java.util.*;

public class Day590BOJ4179불 {
  static int r;
  static int c;
  static char[][] maze;
  static boolean[][] visited;
  static Point jihun;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    r = Integer.parseInt(input[0]);
    c = Integer.parseInt(input[1]);

    maze = new char[r][c];
    visited = new boolean[r][c];
    Queue<Point> q = new LinkedList<>();

    for (int i = 0; i < r; i++) {
      input = br.readLine().split("");
      for (int j = 0; j < c; j++) {
        maze[i][j] = input[j].charAt(0);

        if (maze[i][j] == 'J') {
          if (isEdge(i, j)) {
            System.out.println(1);
            return;
          }

          maze[i][j] = '.';
          jihun = new Point(i, j, 0, 0);
        } else if (maze[i][j] == 'F') {
          q.add(new Point(i, j, 1, 0));
        }
      }
    }

    bfs(q);
  }

  static void bfs(Queue<Point> q) {
    int x;
    int y;
    int count;

    q.add(jihun);
    visited[jihun.x][jihun.y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      x = p.x;
      y = p.y;
      count = p.count;

      if (isEdge(x, y) && p.type == 0) {
        System.out.println(count + 1);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (!isRange(nx, ny) || maze[nx][ny] == '#' || maze[nx][ny] == 'F') {
          continue;
        }

        if (p.type == 0 && !visited[nx][ny]) {
          // 지훈
          q.add(new Point(nx, ny, p.type, count + 1));
          visited[nx][ny] = true;
        } else if (p.type == 1) {
          // 불
          maze[nx][ny] = 'F';
          q.add(new Point(nx, ny, p.type, count + 1));
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }

  static boolean isRange(int x, int y) {
    if (x >= 0 && y >= 0 && x < r && y < c) {
      return true;
    }
    return false;
  }

  static boolean isEdge(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (!isRange(nx, ny)) {
        return true;
      }
    }

    return false;
  }

  static class Point {
    int x, y, type, count;

    public Point(int x, int y, int type, int count) {
      this.x = x;
      this.y = y;
      this.type = type;
      this.count = count;
    }
  }
}