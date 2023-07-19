package day549;

import java.io.*;
import java.util.*;

public class Day529BOJ2564경비원 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    for (int i = 0; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine());
      int tmp = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      switch (tmp) {
        case 1:
          arr[i] = d;
          break;
        case 4:
          arr[i] = X + d;
          break;
        case 2:
          arr[i] = 2 * X + Y - d;
          break;
        case 3:
          arr[i] = 2 * X + 2 * Y - d;
          break;
      }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      answer += Math.min(Math.abs(arr[N] - arr[i]), (2 * X + 2 * Y) - (Math.abs(arr[N] - arr[i])));
    }
    System.out.print(answer);
  }
}
