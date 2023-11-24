package day699;

import java.io.*;
import java.util.*;

public class Day658BOJ1264모음의개수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    HashSet<Character> set = new HashSet<Character>() {
      {
        add('a');
        add('A');
        add('e');
        add('E');
        add('i');
        add('I');
        add('o');
        add('O');
        add('u');
        add('U');
      }
    };

    while (true) {
      char[] input = (br.readLine()).toCharArray();
      if (input[0] == '#' && input.length == 1)
        break;
      int cnt = 0;
      for (int i = 0; i < input.length; i++) {
        if (set.contains(input[i]))
          ++cnt;
      }
      sb.append(cnt).append("\n");
    }
    System.out.println(sb);
  }
}