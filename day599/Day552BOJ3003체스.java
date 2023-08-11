package day599;

import java.io.*;
import java.util.*;

public class Day552BOJ3003체스 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int k = 1, q = 1, r = 2, b = 2, n = 2, p = 8;

    k = k - Integer.parseInt(st.nextToken());
    q = q - Integer.parseInt(st.nextToken());
    r = r - Integer.parseInt(st.nextToken());
    b = b - Integer.parseInt(st.nextToken());
    n = n - Integer.parseInt(st.nextToken());
    p = p - Integer.parseInt(st.nextToken());

    System.out.println(k + " " + q + " " + r + " " + b + " " + n + " " + p + " ");
  }
}