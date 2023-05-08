package day499;

import java.util.Scanner;

public class Day457BOJ1676팩토리얼0의개수 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int ans = 0;

    while (num >= 5) {
      ans += num / 5;
      num /= 5;
    }
    System.out.println(ans);
    sc.close();
  }
}
