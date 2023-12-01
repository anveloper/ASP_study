package day699;

import java.io.*;
import java.util.*;

public class Day665BOJ2233사과나무 {
  static int N, X, Y;
  static String bin;
  static int[] vs;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());

    bin = br.readLine();

    StringTokenizer st = new StringTokenizer(br.readLine());

    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    if (X > Y) {
      int temp = X;
      X = Y;
      Y = temp;
    }

    vs = new int[2 * N + 1];

    recur();

    for (int i = X; i > 0; i--) {
      if (vs[i] == 0)
        continue;
      if (vs[i] < Y)
        continue;

      sb.append(i + " " + vs[i] + "\n");
      break;
    }
    System.out.println(sb);
  }

  static int cur = 0;

  private static void recur() {
    int s = cur++ + 1;
    while (bin.charAt(cur) - '0' == 0)
      recur();
    vs[s] = cur++ + 1;
  }
}