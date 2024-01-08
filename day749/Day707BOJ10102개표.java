package day749;

import java.io.*;

public class Day707BOJ10102개표 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer.parseInt(br.readLine());
    int a = 0, b = 0;
    String str = br.readLine().toLowerCase();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'a')
        a++;
      else
        b++;
    }

    System.out.println((a > b) ? "A" : (a < b) ? "B" : "Tie");
  }
}
