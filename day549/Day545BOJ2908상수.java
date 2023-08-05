package day549;

import java.io.*;
import java.util.*;

public class Day545BOJ2908상수 {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
    int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

    System.out.print(A > B ? A : B);

  }
}