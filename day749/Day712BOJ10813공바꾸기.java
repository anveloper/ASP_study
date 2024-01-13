package day749;

import java.util.*;
import java.io.*;

public class Day712BOJ10813공바꾸기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N, M;

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] bucket = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      bucket[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int temp = bucket[a];
      bucket[a] = bucket[b];
      bucket[b] = temp;
    }

    for (int i = 1; i < N + 1; i++) {
      sb.append(bucket[i] + " ");
    }
    System.out.println(sb);
  }
}
