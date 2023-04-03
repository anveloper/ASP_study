package day449;

import java.io.*;

public class Day422BOJ2748피보나치수 {
  static Long[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    arr = new Long[N + 1];

    arr[0] = 0L;
    arr[1] = 1L;
    System.out.println(recur(N));
  }

  public static long recur(int n) {
    if (arr[n] == null) {
      arr[n] = recur(n - 1) + recur(n - 2);
    }
    return arr[n];
  }
}
