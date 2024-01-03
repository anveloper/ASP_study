package day749;

import java.io.*;
import java.util.*;

public class Day702BOJ10950AB3 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
      sb.append('\n');
    }

    System.out.println(sb);
  }
}