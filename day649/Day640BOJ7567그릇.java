package day649;

import java.io.*;

public class Day640BOJ7567그릇 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int ans = 10;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        ans += 5;
      } else {
        ans += 10;
      }
    }

    System.out.println(ans);
    br.close();
  }
}