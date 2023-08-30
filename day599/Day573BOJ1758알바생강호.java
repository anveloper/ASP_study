package day599;

import java.io.*;
import java.util.*;

public class Day573BOJ1758알바생강호 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr, Comparator.reverseOrder());
    long ans = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i] - i <= 0) {
        break;
      }
      ans += arr[i] - i;
    }
    bw.write(ans + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}