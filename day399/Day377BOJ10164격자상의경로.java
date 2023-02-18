package day399;

import java.io.*;
import java.util.*;

public class Day377BOJ10164격자상의경로 {
  static int N, M, K;
  static int[][] p;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    p = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (i == 0 || j == 0)
          p[i][j] = 1;
        else
          p[i][j] = p[i - 1][j] + p[i][j - 1];
      }
    }

    if (K != 0) {
      int x = (K - 1) / M;
      int y = (K - 1) % M;
      System.out.println(p[x][y] * p[N - x - 1][M - y - 1]);
    } else {
      System.out.println(p[N - 1][M - 1]);
    }
  }
}
