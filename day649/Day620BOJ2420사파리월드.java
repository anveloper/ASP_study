package day649;

import java.io.*;
import java.util.*;

public class Day620BOJ2420사파리월드 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    long m = Long.parseLong(st.nextToken());
    System.out.print(Math.abs(n - m));
  }
}