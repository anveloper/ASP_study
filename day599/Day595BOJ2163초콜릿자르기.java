package day599;

import java.io.*;
import java.util.*;

public class Day595BOJ2163초콜릿자르기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    System.out.print(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) - 1);
  }
}