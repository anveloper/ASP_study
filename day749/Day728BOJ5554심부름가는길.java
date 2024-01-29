package day749;

import java.io.*;

public class Day728BOJ5554심부름가는길 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder ans = new StringBuilder();
    int N = 4;
    int time = 0;
    for (int n = 0; n < N; n++) {
      time += Integer.parseInt(br.readLine());
    }
    ans.append(time / 60).append("\n");
    ans.append(time % 60);
    System.out.print(ans);
    br.close();
  }
}