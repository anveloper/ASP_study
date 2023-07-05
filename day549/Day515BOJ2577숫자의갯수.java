package day549;

import java.io.*;

public class Day515BOJ2577숫자의갯수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
    int[] arr = new int[10];

    while (val != 0) {
      arr[val % 10]++;
      val /= 10;
    }

    for (int result : arr) {
      System.out.println(result);
    }
  }
}