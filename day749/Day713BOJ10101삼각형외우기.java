package day749;

import java.io.*;

public class Day713BOJ10101삼각형외우기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    if (a + b + c != 180) {
      System.out.print("Error");
    } else {
      if (a == 60 && b == 60 && c == 60) {
        System.out.print("Equilateral");
      } else if (a == b || b == c || c == a) {
        System.out.print("Isosceles");
      } else {
        System.out.print("Scalene");
      }
    }
  }
}