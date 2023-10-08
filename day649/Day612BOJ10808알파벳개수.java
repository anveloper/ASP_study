package day649;

import java.io.*;

public class Day612BOJ10808알파벳개수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[26];
    String s = br.readLine();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      arr[c - 97]++;
    }
    for (int i = 0; i < 26; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
