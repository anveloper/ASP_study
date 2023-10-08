package day649;

import java.io.*;

public class Day611BOJ9020골드바흐의추측 {
  public static boolean[] prime = new boolean[10001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    getPrime();

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int a = n / 2;
      int b = n / 2;

      while (true) {
        if (!prime[a] && !prime[b]) {
          sb.append(a).append(' ').append(b).append('\n');
          break;
        }
        a--;
        b++;
      }
    }
    System.out.print(sb);
  }

  public static void getPrime() {
    prime[0] = prime[1] = true;

    for (int i = 2; i <= Math.sqrt(prime.length); i++) {
      if (prime[i])
        continue;
      for (int j = i * i; j < prime.length; j += i) {
        prime[j] = true;
      }
    }
  }
}