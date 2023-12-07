package day699;

import java.io.*;

public class Day671BOJ11005진법변환2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    System.out.println(Integer.toString(n, b).toUpperCase());
  }
}