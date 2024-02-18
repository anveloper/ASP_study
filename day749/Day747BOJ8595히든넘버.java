package day749;

import java.io.*;

public class Day747BOJ8595히든넘버 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String N = br.readLine();
    final String S = br.readLine();

    Long ans = 0L;
    StringBuilder sb = new StringBuilder();

    for (char c : S.toCharArray()) {
      if (Character.isDigit(c)) {
        sb.append(c);
      } else if (sb.length() > 0) {
        ans += Long.parseLong(sb.toString());
        sb.setLength(0);
      }
    }

    if (sb.length() > 0) {
      ans += Long.parseLong(sb.toString());
    }
    System.out.println(ans);
  }
}
