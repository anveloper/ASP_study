package day649;

import java.io.*;
import java.util.*;

public class Day636BOJ2841외계인의기타연주 {
  static int N, P, ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input;
    input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    P = Integer.parseInt(input[1]);

    Stack<Integer>[] stack = new Stack[7];
    for (int i = 1; i < 7; i++) {
      stack[i] = new Stack<Integer>();
    }

    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      int line = Integer.parseInt(input[0]);
      int fret = Integer.parseInt(input[1]);

      while (!stack[line].isEmpty()) {
        if (stack[line].peek() < fret) {
          stack[line].push(fret);
        } else if (stack[line].peek() > fret) {
          stack[line].pop();
        } else {
          break;
        }
        ans += 1;
      }

      if (stack[line].isEmpty()) {
        stack[line].push(fret);
        ans += 1;
      }
    }
    System.out.println(ans);
  }
}
