package day699;

import java.io.*;

public class Day667BOJ5598카이사르암호 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    char[] in = br.readLine().trim().toCharArray();
    for (int i = 0; i < in.length; i++) {
      sb.append((char) ((in[i] - 42) % 26 + 'A'));
    }
    System.out.println(sb);
  }
}
