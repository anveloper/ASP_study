package day549;

import java.util.*;

public class Day534BOJ2440별찍기3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    for (int i = 0; i < num; i++) {

      for (int j = i + 1; j <= num; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    sc.close();
  }
}