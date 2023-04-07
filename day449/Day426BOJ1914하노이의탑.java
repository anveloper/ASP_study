package day449;

import java.io.*;
import java.math.*;

public class Day426BOJ1914하노이의탑 {
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    BigInteger bi = new BigInteger("2");

    sb.append(bi.pow(N).subtract(new BigInteger("1")) + "\n");

    if (N < 21)
      recur(N, 1, 3, 2);

    System.out.println(sb);
    br.close();
  }

  public static void recur(int d, int st, int ed, int pr) {
    if (d == 1) {
      sb.append(st + " " + ed + "\n");
      return;
    }
    recur(d - 1, st, pr, ed);
    sb.append(st + " " + ed + "\n");
    recur(d - 1, pr, ed, st);
  }
}
