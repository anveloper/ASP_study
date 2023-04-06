package day449;

import java.io.*;
import java.util.*;

public class Day425BOJ2628종이자르기 {
  static int N, M, ans = 0;
  static ArrayList<Integer> x, y;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    x = new ArrayList<>();
    y = new ArrayList<>();

    x.add(0);
    x.add(N);
    y.add(M);
    y.add(0);
    int n = Integer.parseInt(br.readLine());
    while (n > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (a != 0) {
        x.add(b);
      } else {
        y.add(b);
      }
      n--;
    }
    x.sort(null);
    y.sort(null);

    for (int i = 1; i < x.size(); i++) {
      for (int j = 1; j < y.size(); j++) {
        int xx = x.get(i) - x.get(i - 1);
        int yy = y.get(j) - y.get(j - 1);
        ans = Math.max(ans, xx * yy);
      }
    }
    System.out.println(ans);
  }
}
