package day749;

import java.io.*;
import java.util.*;

public class Day717BOJ4307개미 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int testCnt = Integer.parseInt(st.nextToken());

    for (int i = 0; i < testCnt; i++) {
      st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int min = Integer.MIN_VALUE;
      int max = Integer.MIN_VALUE;

      for (int j = 0; j < c; j++) {
        st = new StringTokenizer(br.readLine());
        int ant = Integer.parseInt(st.nextToken());

        min = Math.max(min, Math.min(ant, l - ant));
        max = Math.max(max, Math.max(ant, l - ant));
      }
      sb.append(min + " " + max + "\n");
    }
    System.out.println(sb);
  }
}
