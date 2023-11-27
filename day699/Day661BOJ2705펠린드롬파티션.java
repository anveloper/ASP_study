package day699;

import java.io.*;

public class Day661BOJ2705펠린드롬파티션 {
  final static int MAX = 1_001;

  static int T, N;
  static int[] dp = new int[MAX];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    dp[0] = 1;
    for (int i = 1; i < MAX; i++) {
      if (i % 2 == 0) {
        for (int j = 0; j <= i; j += 2)
          dp[i] += dp[(i - j) / 2];
      } else {
        for (int j = 1; j <= i; j += 2)
          dp[i] += dp[(i - j) / 2];
      }
    }

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++)
      sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");

    System.out.print(sb);
  }
}
