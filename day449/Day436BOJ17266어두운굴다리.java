package day449;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day436BOJ17266어두운굴다리 {
  static int N, M, ans;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    arr = new int[M + 2];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    ans = arr[0];

    for (int i = 1; i < M; i++) {
      int tmp = arr[i] - arr[i - 1];
      if ((tmp & 1) == 0)
        ans = Math.max(ans, tmp / 2);
      else
        ans = Math.max(ans, tmp / 2 + 1);
    }
    ans = Math.max(ans, N - arr[M - 1]);
    System.out.println(ans);
    br.close();
  }
}
