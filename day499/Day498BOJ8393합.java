package day499;

import java.io.*;

public class Day498BOJ8393합 {
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int s = 0;
    for (int i = 1; i <= N; i++)
      s += i;
    System.out.println(s);
  }
}
