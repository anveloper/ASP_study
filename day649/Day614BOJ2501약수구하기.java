package day649;

import java.io.*;
import java.util.*;

public class Day614BOJ2501약수구하기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int cnt = 0;
    int res = 0;

    for (int i = 1; i <= N; i++) {
      if (N % i == 0) {
        cnt++;
      }

      if (cnt == K) {
        res = i;
        break;
      }
    }
    System.out.println(res);
  }
}
