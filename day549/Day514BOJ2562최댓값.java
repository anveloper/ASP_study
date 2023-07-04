package day549;

import java.io.*;

public class Day514BOJ2562최댓값 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0;
    int index = 0;
    for (int i = 0; i < 9; i++) {

      int val = Integer.parseInt(br.readLine());

      if (val > max) {
        max = val;
        index = i + 1;
      }
    }

    System.out.println(max);
    System.out.println(index);
  }
}