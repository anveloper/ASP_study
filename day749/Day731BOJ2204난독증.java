package day749;

import java.util.*;

public class Day731BOJ2204난독증 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    HashMap<String, String> hashMap = new HashMap<>();
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        break;
      String[] str = new String[n];
      for (int i = 0; i < n; i++) {
        str[i] = sc.next();
      }
      for (int i = 0; i < n; i++) {
        String temp = str[i].toLowerCase();
        hashMap.put(temp, str[i]);
        str[i] = str[i].toLowerCase();
      }
      Arrays.sort(str);
      sb.append(hashMap.get(str[0])).append("\n");
    }
    System.out.println(sb);
    sc.close();
  }
}