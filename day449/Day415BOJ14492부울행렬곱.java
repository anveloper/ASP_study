package day449;

import java.io.*;
import java.util.*;

public class Day415BOJ14492부울행렬곱 {
  static int N, cnt = 0;
  static boolean[][] arr1, arr2;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    arr1 = new boolean[N][N];
    arr2 = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int j = 0;
      while (st.hasMoreTokens()) {
        if (st.nextToken().equals("0")) {
          arr1[i][j] = false;
        } else {
          arr1[i][j] = true;
        }
        j++;
      }
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int j = 0;
      while (st.hasMoreTokens()) {
        if (st.nextToken().equals("0")) {
          arr2[i][j] = false;
        } else {
          arr2[i][j] = true;
        }
        j++;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (arr1[i][k] == true && arr2[k][j] == true) {
            cnt++;
            k = N;
          }
        }
      }
    }
    System.out.println(cnt);
    br.close();
  }
}
