package day699;

import java.io.*;

public class Day681BOJ2789유학금지 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] w = "CAMBRIDGE".toCharArray();
    String a = br.readLine();

    for (int i = 0; i < w.length; i++) {
      if (a.indexOf(w[i]) > -1) {
        a = a.replace(String.valueOf(w[i]), "");
      }
    }
    System.out.println(a);
  }
}