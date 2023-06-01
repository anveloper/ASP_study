package day499;

import java.io.*;
import java.util.*;

public class Day481BOJ2669직사각형합집합면적 {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    boolean[][] map = new boolean[101][101];

    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      int c1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());
      int c2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      for (int r = r1; r < r2; r++) {
        for (int c = c1; c < c2; c++) {
          map[r][c] = true;
        }
      }
    }

    int cnt = 0;
    for (int r = 0; r < 101; r++) {
      for (int c = 0; c < 101; c++) {
        if (map[r][c] == true) {
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
