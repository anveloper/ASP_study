package day699;

import java.io.*;
import java.util.*;

public class Day671BOJ11005진법변환2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    List<Character> list = new ArrayList<>();
    while (n > 0) {
      if (n % b < 10) {
        list.add((char) (n % b + '0'));
      } else {
        list.add((char) (n % b - 10 + 'A'));
      }
      n /= b;
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      sb.append(list.get(i));
    }
    System.out.println(sb);
  }
}