package day449;

import java.io.*;
import java.util.*;

public class Day444BOJ6064카잉달력 {
  static int T;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    T = Integer.parseInt(br.readLine());

    for (int s = 0; s < T; s++) {
      st = new StringTokenizer(br.readLine());
      boolean check = false;
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;

      for (int i = x; i < (n * m); i += m) {
        if (i % n == y) {
          System.out.println(i + 1);
          check = true;
          break;
        }
      }

      if (!check) {
        System.out.println(-1);
      }
    }
  }
}