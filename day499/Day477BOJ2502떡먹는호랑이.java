package day499;

import java.io.*;
import java.util.*;

public class Day477BOJ2502떡먹는호랑이 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int D = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    if (D == 3) {
      bw.write("1\n" + (K - 1) + "\n");
      bw.flush();
      br.close();
      bw.close();
      return;
    }

    int[] A1 = new int[D + 1];
    int[] A2 = new int[D + 1];

    A1[3] = A2[3] = 1;
    A1[4] = 1;
    A2[4] = 2;

    for (int i = 5; i <= D; i++) {
      A1[i] = A1[i - 1] + A1[i - 2];
      A2[i] = A2[i - 1] + A2[i - 2];
    }

    int first = 0;
    int second = 0;

    for (int i = 1;; i++) {
      int res = K - A1[D] * i;

      if (res % A2[D] == 0) {
        first = i;
        second = res / A2[D];
        break;
      }

    }

    bw.write(first + "\n" + second + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}
