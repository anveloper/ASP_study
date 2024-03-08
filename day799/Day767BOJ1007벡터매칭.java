package day799;

import java.io.*;
import java.util.*;

public class Day767BOJ1007벡터매칭 {
  static int totalX, totalY, target, vx, vy;
  static int coor[][];
  static double min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      target = n / 2;
      coor = new int[n][2];
      totalX = 0;
      totalY = 0;
      min = Double.POSITIVE_INFINITY;

      for (int j = 0; j < n; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
        coor[j] = new int[] { x + x, y + y };
        totalX += x;
        totalY += y;
      }

      for (int j = 0; coor.length - j >= target; j++) {

        vx = totalX;
        vy = totalY;
        getMinVec(j, 1);
      }
      System.out.println(Math.sqrt(min));
    }
  }

  private static void getMinVec(int idx, int depth) {
    vx -= coor[idx][0];
    vy -= coor[idx][1];

    if (depth >= target) {
      min = Math.min((long) vx * vx + (long) vy * vy, min);
    } else {
      ++depth;

      for (int i = idx + 1; coor.length - i >= target - depth + 1; i++) {
        getMinVec(i, depth);
      }
    }

    vx += coor[idx][0];
    vy += coor[idx][1];
  }
}