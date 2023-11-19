package day699;

import java.io.*;
import java.math.*;

public class Day653BOJ2935소음 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger a = new BigInteger(br.readLine());
    String op = br.readLine();
    BigInteger b = new BigInteger(br.readLine());
    if (op.equals("*")) {
      System.out.print(a.multiply(b));
    } else {
      System.out.print(a.add(b));
    }
  }
}