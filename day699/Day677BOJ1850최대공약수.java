package day699;

import java.util.*;

public class Day677BOJ1850최대공약수 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();

    long gcd = getGCD(Math.max(A, B), Math.min(A, B));

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= gcd; i++)
      sb.append("1");

    System.out.println(sb.toString());
    sc.close();
  }

  public static long getGCD(long a, long b) {
    while (b > 0) {
      long tmp = a;
      a = b;
      b = tmp % b;
    }
    return a;
  }
}
