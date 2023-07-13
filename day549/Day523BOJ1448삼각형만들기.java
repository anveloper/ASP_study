package day549;

import java.io.*;
import java.util.*;

public class Day523BOJ1448삼각형만들기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    while (n-- > 0)
      arr[n] = Integer.parseInt(br.readLine());
    Arrays.sort(arr);
    for (int i = arr.length - 3; i >= 0; i--) {
      if (arr[i] + arr[i + 1] > arr[i + 2]) {
        System.out.println(arr[i] + arr[i + 1] + arr[i + 2]);
        return;
      }
    }
    System.out.println(-1);
  }
}
