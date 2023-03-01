package day399;

import java.io.*;
import java.util.*;

public class Day387BOJ3273두수의합 {
  static int N;
  static int[] arr;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.valueOf(st.nextToken());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++)
      arr[i] = Integer.valueOf(st.nextToken());

    Arrays.parallelSort(arr);

    int x = Integer.valueOf(br.readLine());
    int l = 0, r = N - 1, cnt = 0, sum = 0;

    while (l < r) {
      sum = arr[l] + arr[r];
      if (sum == x)
        cnt++;

      if (sum <= x)
        l++;
      else
        r--;
    }
    System.out.println(cnt);
    br.close();
  }
}
