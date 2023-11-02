package day649;

import java.io.*;
import java.util.*;

public class Day637BOJ1477휴게소세우기 {
  static int N, M, L;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    N = Integer.parseInt(s[0]);
    M = Integer.parseInt(s[1]);
    L = Integer.parseInt(s[2]);
    arr = new int[N + 2];
    arr[0] = 0;
    arr[N + 1] = L;

    String[] s1 = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i + 1] = Integer.parseInt(s1[i]);
    }

    System.out.println(solve());
  }

  private static int solve() {
    Arrays.sort(arr);
    int l = 1;
    int r = L - 1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (check(m)) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return l;
  }

  private static boolean check(int dis) {
    int cnt = 0;
    for (int i = 1; i <= N + 1; i++) {
      cnt += (arr[i] - arr[i - 1] - 1) / dis;
    }
    return cnt > M;
  }
}