package day699;

import java.io.*;
import java.util.*;

public class Day679BOJ9527일의개수세기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long[] count = new long[Long.toString(B, 2).length() + 1];
    count[0] = 1;
    for (int i = 1; i < count.length; i++)
      count[i] = count[i - 1] * 2 + (1L << i);

    long ans = getAnswer(B, count) - getAnswer(A - 1, count);

    System.out.println(ans);
  }

  private static long getAnswer(long x, long[] count) {
    long ans = x & 1;

    for (int i = 54; i > 0; i--) {
      if ((x & (1L << i)) > 0L) {
        ans += count[i - 1] + (x - (1L << i) + 1);
        x -= (1L << i);
      }
    }
    return ans;
  }
}
