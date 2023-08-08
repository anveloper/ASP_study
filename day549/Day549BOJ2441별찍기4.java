package day549;

import java.io.*;

public class Day549BOJ2441별찍기4 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++)
      sb.append(" ".repeat(i)).append("*".repeat(N - i)).append('\n');
    System.out.print(sb);
    br.close();
  }
}