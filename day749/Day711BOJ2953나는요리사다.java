package day749;

import java.io.*;
import java.util.*;

public class Day711BOJ2953나는요리사다 {
  static StringTokenizer st;

  static int sum(String score) {
    int result = 0;
    st = new StringTokenizer(score);
    while (st.hasMoreTokens())
      result += Integer.parseInt(st.nextToken());
    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int idx = 0, ans = 0;
    for (int i = 0; i < 5; i++) {
      int sum = sum(br.readLine());
      if (ans < sum) {
        ans = sum;
        idx = i + 1;
      }
    }
    System.out.println(idx + " " + ans);
  }
}
