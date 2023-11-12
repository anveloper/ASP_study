package day649;

import java.io.*;

public class Day646BOJ2566최댓값 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] arr = new int[9][9];

    for (int i = 0; i < 9; i++) {
      String[] strArr = br.readLine().split(" ");
      for (int j = 0; j < strArr.length; j++) {
        arr[i][j] = Integer.parseInt(strArr[j]);
      }
    }

    int num = 0;
    int x = 0;
    int y = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (num < arr[i][j]) {
          num = arr[i][j];
          x = i;
          y = j;
        }
      }
    }

    System.out.println(num);
    System.out.println((x + 1) + " " + (y + 1));
  }
}