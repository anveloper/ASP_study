package day749;

import java.io.*;
import java.util.*;

public class Day700BOJ15552빠른AB {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      sb.append((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
    }
    System.out.println(sb);
    br.close();
  }
}