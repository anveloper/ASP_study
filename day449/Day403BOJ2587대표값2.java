package day449;

import java.io.*;
import java.util.*;

public class Day403BOJ2587대표값2 {
  static int sum = 0, mid = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[5];
    for (int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
    }
    Arrays.sort(arr);
    int avg = sum / 5;
    mid = arr[2];
    System.out.print(avg + "\n" + mid);
    br.close();
  }
}
