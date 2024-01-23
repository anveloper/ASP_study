package day749;

import java.io.*;
import java.util.*;

public class Day722BOJ1141접두사 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] arr = new String[N];

    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());
    List<String> list = new ArrayList<>();

    for (String cur : arr) {
      if (list.size() == 0) {
        list.add(cur);
        continue;
      }

      boolean flag = false;

      for (String str : list) {
        if (str.indexOf(cur) == 0) {
          flag = true;
          break;
        }
      }

      if (!flag) {
        list.add(cur);
      }
    }

    System.out.println(list.size());
  }
}