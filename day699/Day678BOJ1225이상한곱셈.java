package day699;

import java.io.*;
import java.util.*;

public class Day678BOJ1225이상한곱셈 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long ans = 0L;

    String input = br.readLine();
    StringTokenizer tokenizer = new StringTokenizer(input, " ");
    int[][] arr = new int[2][10];

    for (char c : tokenizer.nextToken().toCharArray()) {
      int tmp = c - '0';
      arr[0][tmp] += tmp;
    }

    for (char c : tokenizer.nextToken().toCharArray()) {
      int tmp = c - '0';
      arr[1][tmp] += tmp;
    }

    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        ans += (long) arr[0][i] * arr[1][j];
      }
    }
    System.out.println(ans);
  }
}