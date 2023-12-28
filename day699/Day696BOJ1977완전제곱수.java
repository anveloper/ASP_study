package day699;

import java.io.*;

public class Day696BOJ1977완전제곱수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int min = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 1; i * i <= n; i++) {
      if (i * i >= m && i * i <= n) {
        min = Math.min(i * i, min);
        sum += i * i;
      }
    }
    System.out.print(sum == 0 ? -1 : sum + "\n" + min);
  }
}