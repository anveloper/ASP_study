package day799;

import java.util.*;

public class Day764BOJ1262알파벳다이아몬드 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int R1 = Integer.parseInt(input[1]);
    int C1 = Integer.parseInt(input[2]);
    int R2 = Integer.parseInt(input[3]);
    int C2 = Integer.parseInt(input[4]);
    int length = 2 * N - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0, s = R1; i < R2 - R1 + 1; i++, s++) {
      for (int j = 0, e = C1; j < C2 - C1 + 1; j++, e++) {
        int x = s % (length);
        int y = e % (length);
        int dis = Math.abs((N - 1) - x) + Math.abs((N - 1) - y);

        if (dis >= N)
          sb.append(".");
        else
          sb.append((char) (((dis % 26)) + 'a'));
      }
      sb.append("\n");
    }
    System.out.println(sb);
    sc.close();
  }
}
