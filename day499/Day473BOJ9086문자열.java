package day499;

import java.io.*;

public class Day473BOJ9086문자열 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int cnt = Integer.parseInt(br.readLine());

    for (int i = 0; i < cnt; i++) {
      String T = br.readLine();
      bw.write(String.valueOf(T.charAt(0)) + T.charAt(T.length() - 1));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
