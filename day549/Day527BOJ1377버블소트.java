package day549;

import java.io.*;
import java.util.*;

public class Day527BOJ1377버블소트 {
  static class Point implements Comparable<Point> {
    int num;
    int idx;

    Point(int num, int idx) {
      this.num = num;
      this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
      return num - o.num;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    Point[] points = new Point[N + 1];
    for (int i = 1; i <= N; i++) {
      int temp = Integer.parseInt(br.readLine());
      points[i] = new Point(temp, i);
    }
    Arrays.sort(points, 1, N + 1);

    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, points[i].idx - i);
    }

    bw.write((max + 1) + "\n");
    bw.close();
    br.close();
  }
}
