package day649;

import java.util.*;

public class Day645BOJ1357뒤집힌덧셈 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println(Rev(Rev(sc.nextInt()) + Rev(sc.nextInt())));
    sc.close();
  }

  private static int Rev(int n) {
    String s = "";
    while (n > 0) {
      s += n % 10;
      n /= 10;
    }
    return Integer.parseInt(s);
  }
}
