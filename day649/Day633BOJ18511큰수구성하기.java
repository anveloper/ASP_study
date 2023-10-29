package day649;

import java.io.*;
import java.util.*;

public class Day633BOJ18511큰수구성하기 {
  private static int N, K, ans;
  private static int[] num;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    num = new int[K];
    for (int i = 0; i < K; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(num);
    dfs(0);
    System.out.println(ans);
  }

  private static void dfs(int now) {
    if (now > N)
      return;

    if (ans < now)
      ans = now;

    for (int i = K - 1; i > -1; i--) {
      dfs(now * 10 + num[i]);
    }
  }
}