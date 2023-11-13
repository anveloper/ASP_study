package day649;

import java.io.*;
import java.util.*;

public class Day647BOJ2535정보올림 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][3];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][2] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[2] == o2[2]) {
          if (o1[1] == o1[1])
            return o2[0] - o1[0];
          else
            return o2[1] - o1[1];
        } else
          return o2[2] - o1[2];
      }
    });

    int cnt = 0;
    int c = 0;
    for (int i = 0; i < 8; i++) {
      if (i != 0) {
        if (arr[i - 1][0] == arr[i][0])
          cnt++;
        else
          cnt = 0;
      }
      if (cnt < 2) {
        for (int j = 0; j < 2; j++) {
          sb.append(arr[i][j]).append(" ");
        }
        sb.append("\n");
        c++;
      }
      if (c == 3) {
        break;
      }
    }
    System.out.println(sb);
  }
}
