package day749;

import java.io.*;

public class Day707BOJ10102개표 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    int a = 0, b = 0;
    for (char c : br.readLine().toLowerCase().toCharArray()) {
      if (c == 'a')
        a++;
      else
        b++;
    }
    System.out.println((a > b) ? "A" : (a < b) ? "B" : "Tie");
  }
}
