package day649;

import java.io.*;
import java.util.*;

public class Day643BOJ4101크냐 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num1 = Integer.parseInt(st.nextToken());
      int num2 = Integer.parseInt(st.nextToken());

      if (num1 == 0 && num2 == 0)
        break;
      sb.append(num1 > num2 ? "Yes" : "No").append("\n");
    }
    System.out.println(sb);
  }
}