package day599;

import java.util.*;

public class Day571BOJ2475검증수 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int sum = 0;
    for (int i = 0; i < 5; i++) {
      int tmp = sc.nextInt();
      sum += tmp * tmp;
    }
    int ans = sum % 10;
    System.out.println(ans);
    sc.close();
  }
}