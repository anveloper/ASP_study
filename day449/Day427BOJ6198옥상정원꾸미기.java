package day449;

import java.io.*;
import java.util.*;

public class Day427BOJ6198옥상정원꾸미기 {
  static int N;
  static long ans = 0;
  static Stack<Integer> stack;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(br.readLine());
      while (!stack.isEmpty() && stack.peek() <= tmp)
        stack.pop();
      stack.push(tmp);
      ans += stack.size() - 1;
    }
    System.out.println(ans);
    br.close();
  }
}
