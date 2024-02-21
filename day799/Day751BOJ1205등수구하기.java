package day799;

import java.io.*;
import java.util.*;

public class Day751BOJ1205등수구하기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    if (N == 0) {
      System.out.println(1);
      return;
    }

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 1;
    int tmp = 0;
    for (int i = 0; i < arr.length; i++) {
      int k = arr[i];
      if (k > S) {
        ans++;
      }
      if (k == S) {
        tmp++;
      }
    }
    if (ans + tmp > P) {
      System.out.println(-1);
      return;
    }
    System.out.println(ans);
  }
}
