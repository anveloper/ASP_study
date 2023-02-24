package day399;

import java.io.*;
import java.util.*;

public class Day382BOJ17951흩날리 {
  static int N, K, l = 0, r = 0;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      r += arr[i] = Integer.parseInt(st.nextToken());

    while (l <= r) {
      int mid = (l + r) / 2;
      int cnt = 0, sum = 0;
      for (int i = 0; i < N; i++) {
        sum += arr[i];
        if (sum >= mid) {
          cnt++;
          sum = 0;
        }
      }
      if (cnt >= K)
        l = mid + 1;
      else
        r = mid - 1;
    }
    System.out.println(r);
    br.close();
  }
}
