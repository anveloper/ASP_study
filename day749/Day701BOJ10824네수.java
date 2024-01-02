package day749;

import java.io.*;
import java.util.*;

public class Day701BOJ10824네수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    System.out.print(Long.parseLong(st.nextToken() + st.nextToken()) + Long.parseLong(st.nextToken() + st.nextToken()));
  }
}