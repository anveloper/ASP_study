package day699;

import java.util.*;

public class Day659BOJ1735분수합 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c1, c2, p1, p2;

    c1 = sc.nextInt();
    p1 = sc.nextInt();
    c2 = sc.nextInt();
    p2 = sc.nextInt();

    c1 = c1 * p2 + c2 * p1;
    p1 = p1 * p2;
    int gcd = getGcd(c1, p1);

    System.out.println(c1 / gcd + " " + p1 / gcd);
    sc.close();
  }

  public static int getGcd(int a, int b) {
    if (a % b == 0)
      return b;
    return getGcd(b, a % b);
  }
}