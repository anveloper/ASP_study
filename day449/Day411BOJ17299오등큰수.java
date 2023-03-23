package day449;

import java.io.*;
import java.util.*;

public class Day411BOJ17299오등큰수 {
  static int N;
  static int[] arr, cnt, stack;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    cnt = new int[1000001];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      cnt[arr[i]]++;
    }

    stack = new int[N];
    int top = 0;
    for (int i = 0; i < N; i++) {
      while (top > 0 && cnt[arr[stack[top - 1]]] < cnt[arr[i]]) {
        arr[stack[--top]] = arr[i];
      }
      stack[top++] = i;
    }
    while (top > 0) {
      arr[stack[--top]] = -1;
    }

    for (int i = 0; i < N; i++) {
      sb.append(arr[i]).append(' ');
    }
    System.out.println(sb);
  }
}
