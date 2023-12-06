package day699;

import java.io.*;

public class Day670BOJ10987모음갯수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cnt = 0;
    String s = br.readLine();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        cnt++;
    }
    System.out.print(cnt);
  }
}