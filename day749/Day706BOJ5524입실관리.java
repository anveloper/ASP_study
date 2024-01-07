package day749;

import java.io.*;

public class Day706BOJ5524입실관리 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (n-- > 0) {
      String cur = br.readLine();
      sb.append(cur.toLowerCase()).append('\n');
    }
    System.out.print(sb);
  }
}