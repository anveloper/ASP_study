package day699;

import java.io.*;
import java.util.*;

public class Day660BOJ1388바닥장식 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    char[][] arr = new char[n][m];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < m; j++) {
        arr[i][j] = row.charAt(j);
      }
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      int tmp = 0;
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == '|') {
          tmp = 0;
        } else if (++tmp == 1) {
          cnt++;
        }
      }
    }
    for (int j = 0; j < m; j++) {
      int tmp = 0;
      for (int i = 0; i < n; i++) {
        if (arr[i][j] == '-') {
          tmp = 0;
        } else if (++tmp == 1) {
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}