package day699;

import java.io.*;
import java.util.*;

public class Day691BOJ1551수열의변화 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder sb = new StringBuilder();
  private static StringTokenizer tokens;

  private static int N, K;
  private static int[] A;

  public static void main(String[] args) throws IOException {
    tokens = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokens.nextToken());
    K = Integer.parseInt(tokens.nextToken());

    A = new int[N];
    tokens = new StringTokenizer(br.readLine(), ",");
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(tokens.nextToken());

    for (int k = 0; k < K; k++) {
      int[] tmp = new int[N - 1];

      for (int i = 0; i < N - 1; i++)
        tmp[i] = A[i + 1] - A[i];

      N--;
      A = tmp;
    }

    for (int i = 0; i < N; i++) {
      sb.append(A[i]);
      if (i != N - 1)
        sb.append(",");
    }

    System.out.println(sb);
  }
}