package day649;

import java.io.*;

public class Day623BOJ3053택시기하학 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double R = Double.parseDouble(br.readLine());
    System.out.println(R * R * Math.PI);
    System.out.println(2 * R * R);
  }
}