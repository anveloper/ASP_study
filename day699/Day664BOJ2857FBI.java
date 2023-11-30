package day699;

import java.io.*;

public class Day664BOJ2857FBI {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = "";
    for (int i = 1; i <= 5; i++) {
      if (br.readLine().contains("FBI"))
        str += i + " ";
    }
    System.out.println(str != "" ? str.trim() : "HE GOT AWAY!");
  }
}