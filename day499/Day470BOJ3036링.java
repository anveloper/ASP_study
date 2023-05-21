package day499;

import java.io.*;
import java.util.*;

public class Day470BOJ3036링 {
  static int N, F, O;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    F = Integer.parseInt(st.nextToken());
    for (int i = 1; i < N; i++) {
      O = Integer.parseInt(st.nextToken());
      int gcd = gcd(F, O);
      sb.append(F / gcd).append('/').append(O / gcd).append('\n');
    }
    System.out.println(sb);
    br.close();
  }

  static int gcd(int a, int b) {
    int r;

    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }
    return a;
  }
}
