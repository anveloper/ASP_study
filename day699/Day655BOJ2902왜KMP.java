package day699;

import java.util.*;

public class Day655BOJ2902왜KMP {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String ans = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
        ans += str.charAt(i);
    }
    System.out.println(ans);
    sc.close();
  }
}