package day449;

import java.io.*;
import java.util.*;

public class Day410BOJ3079입국심사 {
  static int N, M;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    long l = 1;
    long r = 1_000_000_000_000_000_000L;

    while (l <= r) {
      long mid = (l + r) / 2;
      long temp = 0;
      for (int num : arr) {
        temp += (mid / num);
        if (temp >= M)
          break;
      }
      if (temp >= M) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    System.out.println(l);
    br.close();
  }
}
