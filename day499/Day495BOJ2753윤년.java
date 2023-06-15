package day499;

import java.io.*;

public class Day495BOJ2753윤년 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int y = Integer.parseInt(br.readLine());
    System.out.print((y % 4 == 0) ? ((y % 400 == 0) ? "1" : (y % 100 == 0) ? "0" : "1") : "0");
  }
}