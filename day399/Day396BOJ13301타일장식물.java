package day399;

import java.io.*;

public class Day396BOJ13301타일장식물 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    long[] dp = new long[num + 1];

    dp[0] = 2;
    dp[1] = 4;

    for (int i = 2; i < num + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    System.out.println(dp[num]);
    br.close();
  }
}
