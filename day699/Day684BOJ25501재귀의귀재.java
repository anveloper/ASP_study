package day699;

import java.io.*;

public class Day684BOJ25501재귀의귀재 {

  static int cnt = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      String S = br.readLine();
      cnt = 0;
      sb.append(isPalindrome(S)).append(" ").append(cnt).append("\n");
    }
    br.close();
    System.out.print(sb);
  }

  static int isPalindrome(String s) {
    return recur(s, 0, (s.length() - 1));
  }

  static int recur(String s, int st, int ed) {
    cnt++;

    if (st >= ed)
      return 1;
    else if (s.charAt(st) != s.charAt(ed))
      return 0;
    else
      return recur(s, (st + 1), (ed - 1));
  }
}