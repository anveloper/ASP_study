package day749;

import java.io.*;
import java.util.*;

public class Day736BOJ1544사이클단어 {
  static int N;
  static ArrayList<String>[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new ArrayList[N];
    int ans = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = new ArrayList<>();
      String str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        arr[i].add(str.substring(j) + str.substring(0, j));
      }

      boolean chk = true;
      for (int j = 0; chk && j <= i - 1; j++) {
        for (int k = 0; chk && k < arr[j].size(); k++) {
          if (str.equals(arr[j].get(k)))
            chk = false;
        }
      }
      if (chk)
        ans++;
    }

    System.out.println(ans);
  }
}