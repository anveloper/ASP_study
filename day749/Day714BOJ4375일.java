package day749;

import java.util.*;

public class Day714BOJ4375일 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {
      int num = sc.nextInt();
      int mod = 0;

      for (int i = 1;; i++) {
        mod = (mod * 10 + 1) % num;
        if (mod == 0) {
          System.out.println(i);
          break;
        }
      }
    }
    sc.close();
  }
}