package day599;

import java.io.*;
import java.util.*;

public class Day593BOJ2738행렬덧셈 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        sb.append(arr[i][j] + Integer.parseInt(st.nextToken()) + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}