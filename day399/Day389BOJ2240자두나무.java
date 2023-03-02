package day399;

import java.io.*;
import java.util.*;

public class Day389BOJ2240자두나무 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    int[] jadu = new int[W + 1];
    for (int i = 1; i <= T; i++) {
      int input = Integer.parseInt(br.readLine());
      if (input == 1) {
        for (int j = W; j >= 0; j--) {
          if (j % 2 == 0) {
            jadu[j]++;
            if (j > 0)
              jadu[j] = Math.max(jadu[j - 1] + 1, jadu[j]);
          } else {
            jadu[j] = Math.max(jadu[j], jadu[j - 1]);
          }
        }
      } else {
        for (int j = W; j >= 0; j--) {
          if (j % 2 == 0) {
            if (j > 0)
              jadu[j] = Math.max(jadu[j], jadu[j - 1]);
          } else {
            jadu[j]++;
            jadu[j] = Math.max(jadu[j - 1] + 1, jadu[j]);
          }
        }
      }
    }
    int max = 0;
    for (int i = 0; i <= W; i++) {
      if (max < jadu[i])
        max = jadu[i];
    }
    System.out.println(max);

  }
}