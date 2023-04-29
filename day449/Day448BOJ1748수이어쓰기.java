package day449;

import java.io.*;

public class Day448BOJ1748수이어쓰기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int ans = 0;
    int d = (int) (Math.log10(N) + 1);
    for (int i = d - 1; i > 0; i--) {
      ans += i * (int) ((Math.pow(10, i) - Math.pow(10, i - 1)));
    }
    ans += d * (N - (int) Math.pow(10, d - 1) + 1);
    System.out.println(ans);
    br.close();
  }
}