package day549;

import java.io.*;
import java.util.*;

public class Day509BOJ2003수들의합2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int i = 0;
    int j = 0;
    int sum = 0;
    int ans = 0;
    while (j < N) {
      if (sum < M) {
        sum += arr[j++];
      } else if (sum == M) {
        ans++;
        sum -= arr[i++];
        sum += arr[j++];
      } else {
        sum -= arr[i++];
      }
    }
    while (i < N && M < sum)
      sum -= arr[i++];
    if (sum == M)
      ans++;
    System.out.println(ans);
  }
}