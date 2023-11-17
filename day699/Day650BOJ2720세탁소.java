package day699;

import java.io.*;

public class Day650BOJ2720세탁소 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int quarter = 25;
    int dime = 10;
    int nickel = 5;
    int penny = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int c = Integer.parseInt(br.readLine());
      sb.append(c / quarter + " ");
      c %= quarter;
      sb.append(c / dime + " ");
      c %= dime;
      sb.append(c / nickel + " ");
      c %= nickel;
      sb.append(c / penny + "\n");
    }
    System.out.print(sb);
  }
}