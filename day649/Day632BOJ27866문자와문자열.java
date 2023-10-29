package day649;

import java.io.*;

public class Day632BOJ27866문자와문자열 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(br.readLine().charAt(Integer.parseInt(br.readLine()) - 1));
    br.close();
  }
}