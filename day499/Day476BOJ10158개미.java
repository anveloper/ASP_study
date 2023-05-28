package day499;

import java.io.*;
import java.util.*;

public class Day476BOJ10158개미 {
  static int W, H, P, Q, T;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    P = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(br.readLine());
    int x = (int) (P + T) / W % 2 == 0 ? (P + T) % W : W - (P + T) % W;
    int y = (int) (Q + T) / H % 2 == 0 ? (Q + T) % H : H - (Q + T) % H;

    System.out.println(x + " " + y);
  }
}
