package day599;

import java.io.*;

public class Day572BOJ2444별찍기7 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++)
        bw.write(' ');
      for (int j = 0; j < 2 * i + 1; j++)
        bw.write('*');
      bw.write('\n');
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++)
        bw.write(' ');
      for (int j = 0; j < 2 * (n - i) - 1; j++)
        bw.write('*');
      bw.write('\n');
    }
    bw.flush();
    bw.close();
  }
}
