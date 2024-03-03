package day799;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Day762BOJ1252이진수덧셈 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String A = st.nextToken();
    String B = st.nextToken();

    BigInteger A_binary = new BigInteger(A, 2);
    BigInteger B_binary = new BigInteger(B, 2);

    BigInteger sum = A_binary.add(B_binary);

    String sum_binary = sum.toString(2);

    System.out.println(sum_binary);
  }
}