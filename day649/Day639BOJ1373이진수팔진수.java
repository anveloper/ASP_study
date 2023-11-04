package day649;

import java.io.*;

public class Day639BOJ1373이진수팔진수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringBuilder binary = new StringBuilder(br.readLine());
    if (binary.length() % 3 == 1) {
      binary.insert(0, "00");
    } else if (binary.length() % 3 == 2) {
      binary.insert(0, "0");
    }
    int idx = 0;
    int repeat = binary.length() / 3;
    do {
      int num = 0;
      String threeDigit = binary.substring(idx, idx + 3);

      if (threeDigit.charAt(0) == '1')
        num += 4;
      if (threeDigit.charAt(1) == '1')
        num += 2;
      if (threeDigit.charAt(2) == '1')
        num += 1;

      idx = idx + 3;
      sb.append(num);
    } while (--repeat > 0);
    System.out.println(sb);
  }
}