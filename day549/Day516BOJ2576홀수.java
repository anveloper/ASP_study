package day549;

import java.io.*;

public class Day516BOJ2576홀수 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0;
    int min = 100;

    for (int i = 0; i < 7; i++) {
      int N = Integer.parseInt(br.readLine());

      if (N % 2 == 1) {
        sum += N;
        min = Math.min(min, N);
      }
    }

    if (sum == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sum);
      System.out.println(min);
    }
  }
}