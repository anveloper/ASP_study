package day549;

import java.io.*;
import java.util.*;

public class Day507BOJ1620포켓몬마스터 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int n = Integer.parseInt(inputs[0]);
    int m = Integer.parseInt(inputs[1]);

    HashMap<Integer, String> map_int = new HashMap<>();
    HashMap<String, Integer> map_str = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String name = br.readLine();
      map_int.put(i, name);
      map_str.put(name, i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= m; i++) {
      String tmp = br.readLine();
      if (isNum(tmp)) {
        sb.append(map_int.get(Integer.parseInt(tmp)) + "\n");
      } else {
        sb.append(map_str.get(tmp) + "\n");
      }
    }

    System.out.println(sb);
  }

  public static boolean isNum(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}