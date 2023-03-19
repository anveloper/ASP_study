package day449;

import java.io.*;

public class Day406BOJ1193분수찾기 {
  static int X, cnt = 1, sum = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    X = Integer.parseInt(br.readLine());

    while (true) {
      if (X <= sum + cnt) {

        if (cnt % 2 == 1) {
          System.out.print((cnt - (X - sum - 1)) + "/" + (X - sum));
          break;
        }

        else {
          System.out.print((X - sum) + "/" + (cnt - (X - sum - 1)));
          break;
        }

      } else {
        sum += cnt;
        cnt++;
      }
    }
  }
}
