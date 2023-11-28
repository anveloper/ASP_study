package day699;

import java.io.*;
import java.util.*;

public class Day662BOJ7570줄세우기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];
    int max = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int idx = Integer.parseInt(st.nextToken());
      dp[idx] = dp[idx - 1] + 1;
      max = Math.max(max, dp[idx]);
    }

    System.out.println(n - max);
    br.close();
  }
}