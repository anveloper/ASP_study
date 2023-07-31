package day549;

import java.io.*;

public class Day541BOJ1100하얀칸 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;
    for (int i = 0; i < 8; i++) {
      String s = br.readLine();
      for (int j = 0; j < 8; j++) {
        if (s.charAt(j) == 'F' && (i + j) % 2 == 0)
          count++;
      }
    }
    System.out.print(count);
  }
}