package day749;

import java.io.*;

public class Day734BOJ2903중앙이동알고리즘 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println((int) Math.pow(Math.pow(2, n) + 1, 2));
  }
}