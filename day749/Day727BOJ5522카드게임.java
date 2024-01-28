package day749;

import java.io.*;

public class Day727BOJ5522카드게임 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ans = 0;
    for (int i = 1; i <= 5; i++) {
      ans += Integer.parseInt(br.readLine());
    }
    System.out.print(ans);
  }
}