package day449;

import java.io.*;
import java.util.*;

public class Day431BOJ1459걷기 {
  static long X, Y, W, S;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    X = Long.parseLong(st.nextToken());
    Y = Long.parseLong(st.nextToken());
    W = Long.parseLong(st.nextToken());
    S = Long.parseLong(st.nextToken());

    System.out.println(
        Math.min(
            Math.min(
                (X + Y) * W,
                (X + Y) % 2 == 0
                    ? Math.max(X, Y) * S
                    : (Math.max(X, Y) - 1) * S + W),
            Math.min(X, Y) * S + Math.abs(X - Y) * W));
  }
}
