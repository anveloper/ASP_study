package day399;

import java.io.*;
import java.util.*;

public class Day385BOJ24061병합 {
  static int N, K;
  static long[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new long[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++)
      arr[i] = Long.parseLong(st.nextToken());

    mergeSort(0, N - 1);

    if (K == 0) {
      for (int i = 0; i < N; i++)
        sb.append(arr[i] + " ");
      System.out.println(sb);
    } else
      System.out.println(-1);
    br.close();
  }

  private static void mergeSort(int p, int r) {
    if (p < r && K > 0) {
      int q = (p + r) / 2;
      mergeSort(p, q);
      mergeSort(q + 1, r);
      merge(p, q, r);
    }
  }

  private static void merge(int p, int q, int r) { // 주어진 의사코드
    long[] tmp = new long[r - p + 2];
    int i = p, j = q + 1, t = 0;
    while (i <= q && j <= r) {
      if (arr[i] <= arr[j])
        tmp[t++] = arr[i++];
      else
        tmp[t++] = arr[j++];
    }
    while (i <= q)
      tmp[t++] = arr[i++];
    while (j <= r)
      tmp[t++] = arr[j++];
    i = p;
    t = 0;
    while (i <= r && K > 0) {
      arr[i++] = tmp[t++];
      K--;
    }
  }
}
