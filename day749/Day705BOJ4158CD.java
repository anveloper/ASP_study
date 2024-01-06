package day749;

import java.io.*;
import java.util.*;

public class Day705BOJ4158CD {
  static int N, M, ans;
  static int[] arrN, arrM;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine(), " ");

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      if (N == 0 && M == 0) {
        break;
      }
      arrN = new int[N];
      for (int i = 0; i < N; i++) {
        arrN[i] = Integer.parseInt(br.readLine());
      }

      arrM = new int[M];
      for (int i = 0; i < N; i++) {
        arrM[i] = Integer.parseInt(br.readLine());
      }

      ans = 0;
      int i = 0, j = 0;
      while (i < N && j < M) {
        if (arrN[i] == arrM[j]) {
          ans++;
          i++;
          j++;
        } else if (arrN[i] > arrM[j]) {
          j++;
        } else {
          i++;
        }
      }
      sb.append(ans + "\n");
    }
    System.out.println(sb);
  }
}
