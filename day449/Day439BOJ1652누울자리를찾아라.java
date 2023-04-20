package day449;

import java.io.*;

public class Day439BOJ1652누울자리를찾아라 {
  static int N;
  static int[] ans = new int[2];
  static char[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];

    for (int i = 0; i < N; i++)
      arr[i] = br.readLine().toCharArray();

    ans[0] = 0;
    ans[1] = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i + 1 < N) {
          if (arr[i][j] == '.' && arr[i + 1][j] == '.' && (i + 2 >= N || arr[i + 2][j] == 'X')) {
            ans[1] += 1;
          }
        }
        if (j + 1 < N) {
          if (arr[i][j] == '.' && arr[i][j + 1] == '.' && (j + 2 >= N || arr[i][j + 2] == 'X')) {
            ans[0] += 1;
          }
        }
      }
    }
    System.out.println(ans[0] + " " + ans[1]);
  }
}
