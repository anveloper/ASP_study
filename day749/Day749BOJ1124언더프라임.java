package day749;

import java.io.*;
import java.util.*;

public class Day749BOJ1124언더프라임 {
  static int A, B;
  static boolean[] prime = new boolean[100001];
  static int[] cnt = new int[100001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    prime[0] = true;
    prime[1] = true;

    for (int i = 2; i < 100001; i++) {
      if (prime[i])
        continue;
      for (int j = i * 2; j < 100001; j += i) {
        prime[j] = true;
        int tmp = j;
        while (tmp % i == 0) {
          tmp = tmp / i;
          cnt[j]++;
        }
      }
    }

    int ans = 0;
    for (int i = A; i <= B; i++) {
      if (!prime[cnt[i]]) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
