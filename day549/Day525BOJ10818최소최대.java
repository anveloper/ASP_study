package day549;

import java.io.*;
import java.util.*;

public class Day525BOJ10818최소최대 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int max = -1000001;
    int min = 1000001;

    while (st.hasMoreTokens()) {
      int val = Integer.parseInt(st.nextToken());
      if (val > max) {
        max = val;
      }
      if (val < min) {
        min = val;
      }
    }
    System.out.println(min + " " + max);
  }
}
