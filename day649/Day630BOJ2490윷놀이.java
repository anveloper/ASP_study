package day649;

import java.io.*;
import java.util.*;

public class Day630BOJ2490윷놀이 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = { "D", "C", "B", "A", "E" };
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int sum = 0;
      while (st.hasMoreTokens()) {
        sum += Integer.parseInt(st.nextToken());
      }
      sb.append(arr[sum] + "\n");
    }
    System.out.print(sb);
  }
}