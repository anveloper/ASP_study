package day499;

import java.io.*;

public class Day456BOJ1032명령프롬프트 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }
    int len = arr[0].length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      boolean b = true;
      char c = arr[0].charAt(i);
      for (int j = 1; j < n; j++) {
        if (c != arr[j].charAt(i))
          b = false;
      }
      if (b) {
        sb.append(c);
      } else {
        sb.append("?");
      }
    }
    System.out.print(sb);
  }
}
