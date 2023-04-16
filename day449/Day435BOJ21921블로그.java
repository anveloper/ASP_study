package day449;

import java.io.*;
import java.util.*;

public class Day435BOJ21921블로그 {
  static int N, X, sum, ans, cnt;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    sum = 0;
    for (int i = 0; i < X; i++)
      sum += arr[i];

    ans = sum;
    cnt = 1;
    for (int i = X; i < N; i++) {
      sum += arr[i] - arr[i - X];
      if (ans == sum)
        cnt++;
      else if (ans < sum) {
        ans = sum;
        cnt = 1;
      }
    }
    if (ans == 0) {
      System.out.println("SAD");
      return;
    }
    System.out.println(ans + "\n" + cnt);
  }
}