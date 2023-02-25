package day399;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day383BOJ3474교수현우 {
  static int T, N, cnt;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    T = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < T; tc++) {
      N = Integer.parseInt(br.readLine());
      cnt = 0;
      while (N >= 5) {
        cnt += N / 5;
        N /= 5;
      }
      sb.append(cnt + "\n");
    }

    System.out.println(sb);
    br.close();
  }
}
