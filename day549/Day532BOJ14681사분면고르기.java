package day549;

import java.util.Scanner;

public class Day532BOJ14681사분면고르기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = sc.nextInt();

    if (x > 0 && x * y > 0)
      System.out.println(1);
    else if (x < 0 && x * y > 0)
      System.out.println(3);
    else if (x > 0 && x * y < 0)
      System.out.println(4);
    else
      System.out.println(2);
    sc.close();
  }
}
