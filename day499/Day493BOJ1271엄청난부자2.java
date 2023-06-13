package day499;

import java.math.*;
import java.util.*;

public class Day493BOJ1271엄청난부자2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger n = in.nextBigInteger();
    BigInteger m = in.nextBigInteger();
    in.close();
    System.out.println(n.divide(m));
    System.out.println(n.remainder(m));
  }
}