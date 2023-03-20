package day449;

import java.io.*;
import java.util.*;

public class Day408BOJ2822점수계산 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = 8;
    int[] arr = new int[n];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      map.put(arr[i], i + 1);
    }

    Arrays.sort(arr);

    int sum = 0;

    int[] topFive = new int[5];
    for (int i = arr.length - 1; i >= 3; i--) {
      sum += arr[i];
      topFive[i - 3] = map.get(arr[i]);
    }

    sb.append(sum).append("\n");
    Arrays.sort(topFive);
    for (int val : topFive) {
      sb.append(val + " ");
    }

    System.out.println(sb);
  }
}
