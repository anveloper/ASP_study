package day399;

import java.io.*;

public class Day393BOJ1008AB {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    double a = Double.parseDouble(str[0]);
    double b = Double.parseDouble(str[1]);

    System.out.println(a / b);
  }
}