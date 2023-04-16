package day449;

import java.io.*;
import java.util.*;

public class Day434BOJ2012등수매기기 {
  static int N;
  static int[] arr;
  static long ans = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    arr[0] = 0;
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);

    for (int i = 1; i <= N; i++)
      ans += Math.abs(i - arr[i]);

    System.out.println(ans);
  }
}
