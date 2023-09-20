package day599;

import java.util.Scanner;

public class Day594BOJ17608막대기 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < arr.length; i++)
      arr[i] = sc.nextInt();

    int cnt = 1;
    int max = arr[arr.length - 1];

    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] > max) {
        cnt++;
        max = arr[i];
      }
    }

    System.out.println(cnt);
    sc.close();
  }
}