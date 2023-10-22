package day649;

import java.io.*;
import java.util.*;

public class Day626BOJ3109빵집 {
  static int R, C, val;
  static char[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    for (int i = 0; i < R; i++)
      map[i] = br.readLine().toCharArray();

    for (int i = 0; i < R; i++)
      if (check(i, 0))
        val++;
    System.out.println(val);
  }

  public static boolean check(int x, int y) {
    map[x][y] = '-';

    if (y == C - 1)
      return true;

    if (x > 0 && map[x - 1][y + 1] == '.')
      if (check(x - 1, y + 1))
        return true;
    if (map[x][y + 1] == '.')
      if (check(x, y + 1))
        return true;
    if (x + 1 < R && map[x + 1][y + 1] == '.')
      if (check(x + 1, y + 1))
        return true;
    return false;
  }
}