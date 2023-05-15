package day499;

import java.io.*;
import java.util.*;

public class Day464BOJ1485정사각형 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {

      List<Point> points = new ArrayList<>();
      for (int k = 0; k < 4; k++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        points.add(new Point(x, y));
      }

      if (isSquare(points))
        sb.append(1);
      else
        sb.append(0);

      sb.append('\n');
    }

    System.out.println(sb);
  }

  private static boolean isSquare(List<Point> points) {
    List<Long> deltas = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      for (int j = i + 1; j < 4; j++) {
        deltas.add(points.get(i).getDelta(points.get(j)));
      }
    }

    Collections.sort(deltas);

    return deltas.get(0).equals(deltas.get(1)) && deltas.get(1).equals(deltas.get(2))
        && deltas.get(2).equals(deltas.get(3)) && deltas.get(4).equals(deltas.get(5));
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public long getDelta(Point o) {
      return (long) (Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2));
    }
  }
}
