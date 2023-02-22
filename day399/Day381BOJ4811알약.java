package day399;

import java.io.*;

public class Day381BOJ4811알약 {
  public static long cnt = 0;
  public static long dp[];
  public static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    dp = new long[31];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    while (true) {
      n = Integer.parseInt(br.readLine());
      if (n == 0)
        break;
      for (int i = 3; i <= 30; i++) {
        cnt = 0;// 초기화
        for (int j = 0; j < i; j++) {
          cnt += dp[j] * dp[i - 1 - j];
        }
        dp[i] = cnt;
      }
      sb.append(dp[n] + "\n");
    }
    System.out.println(sb);
    br.close();
  }
}
