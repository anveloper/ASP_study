package day749;

import java.io.*;
import java.util.*;

public class Day737BOJ5073삼각형과세변 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == b && b == c) {
        if (a == 0) {
          break;
        }
        sb.append("Equilateral" + "\n");
      } else if (a + b <= c || a + c <= b || b + c <= a) {
        sb.append("Invalid" + "\n");
      } else if (a != b && b != c && a != c) {
        sb.append("Scalene" + "\n");
      } else {
        sb.append("Isosceles" + "\n");
      }
    }
    System.out.print(sb);
  }
}