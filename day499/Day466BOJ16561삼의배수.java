package day499;

import java.util.Scanner;

public class Day466BOJ16561삼의배수 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), sum = 1, cnt = 2;
    for (int i = 9; i < N; i += 3) {
      sum += cnt;
      cnt++;
    }
    System.out.println(sum);
    sc.close();
  }
}
