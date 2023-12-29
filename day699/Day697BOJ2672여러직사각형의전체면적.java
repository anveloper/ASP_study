package day699;

import java.io.*;
import java.util.*;

public class Day697BOJ2672여러직사각형의전체면적 {
  private static ArrayList<Double> xList = new ArrayList<>();
  private static ArrayList<Double> yList = new ArrayList<>();

  private static class Rectangle {
    double x, y, w, h;

    public Rectangle(double x, double y, double w, double h) {
      this.x = x;
      this.y = y;
      this.w = w;
      this.h = h;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Rectangle[] rec = new Rectangle[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());
      double w = Double.parseDouble(st.nextToken());
      double h = Double.parseDouble(st.nextToken());

      rec[i] = new Rectangle(x, y, w, h);
      xList.add(x);
      xList.add(x + w);
      yList.add(y);
      yList.add(y + h);
    }

    double size = bruteForce(N, rec);
    System.out.println(size == (int) size ? (int) size : String.format("%.2f", size));
  }

  private static double bruteForce(int n, Rectangle[] rec) {
    Collections.sort(xList);
    Collections.sort(yList);

    double square = 0;
    int[] size = { xList.size(), yList.size() };

    for (int i = 1; i < size[0]; i++) {
      for (int j = 1; j < size[1]; j++) {
        double[] xs = { xList.get(i - 1), xList.get(i) };
        double[] ys = { yList.get(j - 1), yList.get(j) };

        for (int k = 0; k < n; k++) {
          if (check(xs[0], xs[1], ys[0], ys[1], rec[k]))
            continue;
          square += (xs[1] - xs[0]) * (ys[1] - ys[0]);
          break;
        }
      }
    }

    return square;
  }

  private static boolean check(double x1, double x2, double y1, double y2, Rectangle r) {
    return r.x > x1 || (r.x + r.w) < x2 || r.y > y1 || (r.y + r.h) < y2;
  }
}
