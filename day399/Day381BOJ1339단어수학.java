package day399;

import java.io.*;
import java.util.*;

public class Day381BOJ1339단어수학 {
  static int N, sum = 0, idx = 0, num = 9;
  static Integer[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new Integer[26];

    Arrays.fill(arr, 0);
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < s.length(); j++) {
        arr[s.charAt(j) - 'A'] += (int) Math.pow(10, s.length() - 1 - j);
      }
    }
    Arrays.sort(arr, Collections.reverseOrder());

    while (arr[idx] != 0) {
      sum += num-- * arr[idx++];
    }

    System.out.println(sum);
    br.close();
  }
}
