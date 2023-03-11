package day399;

import java.io.*;
import java.util.*;

public class Day399BOJ1351무한수열 {
  static long N, P, Q;
  static Map<Long, Long> map = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Long.parseLong(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    System.out.println(solve(N));
    br.close();
  }

  private static long solve(long n) {
    if (n == 0)
      return 1;
    if (map.containsKey(n))
      return map.get(n);
    long p = (long) Math.floor(n / P);
    long q = (long) Math.floor(n / Q);
    map.put(n, solve(p) + solve(q));
    return map.get(n);
  }
}
