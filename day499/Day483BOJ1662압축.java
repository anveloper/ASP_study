package day499;

import java.io.*;
import java.util.*;

public class Day483BOJ1662압축 {
  public static void main(String[] args) throws Exception {
    String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int cnt = 0;
    int[] sh = new int[26];
    Stack<Character> stc = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      stc.push(str.charAt(i));
      if (stc.peek() == ')') {
        stc.pop();
        while (stc.pop() != '(')
          sh[cnt]++;
        sh[cnt - 1] += sh[cnt] * (stc.pop() - '0');
        sh[cnt--] = 0;
      } else if (stc.peek() == '(')
        cnt++;
    }
    System.out.println(sh[0] + stc.size());
  }
}
