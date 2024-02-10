package day749;

import java.io.*;
import java.util.*;

public class Day740BOJ3034앵그리창영 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();

    int[] n = new int[3];
    for (int i = 0; i < 3; i++) {
      n[i] = Integer.parseInt(st.nextToken());
    }
    int std = n[1] * n[1] + n[2] * n[2];
    for (int i = 0; i < n[0]; i++) {
      int num = Integer.parseInt(br.readLine());
      sb.append((num * num <= std) ? ("DA\n") : ("NE\n"));
    }
    System.out.println(sb);
  }
}