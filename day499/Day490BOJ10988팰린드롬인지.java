package day499;

import java.io.*;

public class Day490BOJ10988팰린드롬인지 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder(br.readLine());
    bw.write(((sb.toString().equals(sb.reverse().toString())) ? 1 : 0) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }
}