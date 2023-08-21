package day599;

import java.io.*;

public class Day562BOJ2417정수제곱근 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());
    System.out.println(bSearch(n));
  }

  static long bSearch(long n) {
    long start = 0;
    long end = n;
    long result = 0;

    while (start <= end) {
      long mid = (start + end) / 2;
      if (n <= (long) Math.pow(mid, 2)) {
        result = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return result;
  }
}