package day749;

import java.io.*;

public class Day718BOJ1343폴리오미노 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    str = str.replaceAll("XXXX", "AAAA");
    str = str.replaceAll("XX", "BB");
    System.out.println(str.contains("X") ? -1 : str);
  }
}
