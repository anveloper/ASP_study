package day399;

import java.io.*;

public class Day384BOJ2670연속부분최대곱 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    double arr[] = new double[n];
    for (int i = 0; i < n; i++)
      arr[i] = Double.parseDouble(br.readLine());
    double max = 0;
    for (int i = 1; i < n; i++) {
      arr[i] = Math.max(arr[i], arr[i - 1] * arr[i]);
      max = Math.max(max, arr[i]);
    }
    System.out.printf("%.3f", max);
  }
}
