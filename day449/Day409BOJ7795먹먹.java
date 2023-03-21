package day449;

import java.io.*;
import java.util.*;

class Day409BOJ7795먹먹 {
  static int T, N, M, ans = 0;
  static int[] A, B;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      A = new int[N];
      B = new int[M];

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[j] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        B[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(B);
      ans = 0;

      for (int j = 0; j < N; j++) {
        int l = 0;
        int r = M - 1;
        int index = 0;

        while (l <= r) {
          int mid = (l + r) / 2;
          if (B[mid] < A[j]) {
            l = mid + 1;
            index = mid + 1;
          } else {
            r = mid - 1;
          }
        }
        ans += index;
      }

      sb.append(Integer.toString(ans) + "\n");
    }
    System.out.println(sb);
    br.close();
  }
}
