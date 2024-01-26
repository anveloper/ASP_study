package day749;

import java.io.*;

public class Day725BOJ5565영수증 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ans = Integer.parseInt(br.readLine());

    for (int i = 1; i <= 9; i++) {
      ans -= Integer.parseInt(br.readLine());
    }
    System.out.print(ans);
  }
}