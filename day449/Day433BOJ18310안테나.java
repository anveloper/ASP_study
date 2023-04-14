package day449;

import java.io.*;
import java.util.*;

public class Day433BOJ18310안테나 {
  static int N;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    arr = new int[N];
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);
    System.out.println(N % 2 == 0 ? arr[N / 2 - 1] : arr[N / 2]);
    br.close();
  }
}
