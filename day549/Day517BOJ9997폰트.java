package day549;

import java.io.*;

public class Day517BOJ9997폰트 {
  static final int ALPHA = (1 << 26) - 1;
  static int N, ans;
  static int[] words;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    words = new int[N];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split("");

      for (int j = 0; j < input.length; j++) {
        words[i] |= 1 << input[j].charAt(0) - 'a';
      }
    }

    dfs(-1, 0);
    System.out.println(ans);
  }

  static void dfs(int count, int mask) {
    if (count == N - 1) {
      if (mask == ALPHA) {
        ans++;
      }
    } else {
      dfs(count + 1, mask | words[count + 1]);
      dfs(count + 1, mask);
    }
  }
}
