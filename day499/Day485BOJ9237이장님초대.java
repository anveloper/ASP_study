package day499;

import java.io.*;
import java.util.*;

public class Day485BOJ9237이장님초대 {
  static int N, ans = 0;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(arr);
    for (int i = 0; i < N; i++)
      ans = Math.max(ans, arr[i] + N - i);
    System.out.println(ans + 1);
    br.close();
  }
}
