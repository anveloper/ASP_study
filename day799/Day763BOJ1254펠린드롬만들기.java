package day799;

import java.io.*;

public class Day763BOJ1254펠린드롬만들기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int cnt = str.length();

    for (int i = 0; i < str.length(); i++) {
      if (isPalindrome(str.substring(i))) {
        break;
      }
      cnt++;
    }
    System.out.println(cnt);
  }

  private static boolean isPalindrome(String str) {
    char[] list = str.toCharArray();
    for (int i = 0; i < Math.floor(str.length() / 2); i++) {
      if (list[i] != list[str.length() - i - 1]) {
        return false;
      }
    }
    return true;
  }
}