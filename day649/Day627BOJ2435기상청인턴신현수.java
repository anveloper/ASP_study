package day649;

import java.util.*;

public class Day627BOJ2435기상청인턴신현수 {
  static int N, K, max = Integer.MIN_VALUE;
  static int[] tmp = new int[103];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    K = sc.nextInt();

    for (int i = 0; i < N; i++)
      tmp[i] = sc.nextInt();

    for (int i = 0; i <= N - K; i++) {
      int sum = 0;
      for (int j = 0; j < K; j++)
        sum += tmp[i + j];
      if (sum > max)
        max = sum;
    }
    System.out.println(max);
    sc.close();
  }
}