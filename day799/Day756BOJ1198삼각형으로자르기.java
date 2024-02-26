package day799;

import java.io.*;

public class Day756BOJ1198삼각형으로자르기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[][] points = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] coordinate = br.readLine().split(" ");
      points[i][0] = Integer.parseInt(coordinate[0]);
      points[i][1] = Integer.parseInt(coordinate[1]);
    }

    double max = 0;
    for (int a = 0; a < n - 2; a++) {
      for (int b = a + 1; b < n - 1; b++) {
        for (int c = b + 1; c < n; c++) {
          max = Math.max(max, area(points[a], points[b], points[c]));
        }
      }
    }

    bw.write(Double.toString(max));
    br.close();
    bw.close();
  }

  private static double area(int[] a, int[] b, int[] c) {
    return (double) Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]) / 2;
  }
}