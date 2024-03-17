package day799;

import java.io.*;
import java.util.*;

public class Day775BOJ1132합 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] values = new long[10];
    boolean[] flag = new boolean[10];
    for (int i = 0; i < n; i++) {
      String input = br.readLine();

      long pos = 1;
      for (int j = input.length() - 1; j >= 0; j--) {
        if (j == 0)
          flag[input.charAt(j) - 'A'] = true;
        values[input.charAt(j) - 'A'] += pos;
        pos *= 10;
      }

    }

    int find_idx = 0;
    long min_val = Long.MAX_VALUE;
    for (int i = 0; i < values.length; i++) {
      if (!flag[i] && min_val > values[i]) {
        find_idx = i;
        min_val = values[i];
      }
    }

    values[find_idx] = 0;

    Arrays.sort(values);

    long ans = 0;
    int pos = 9;

    for (int i = values.length - 1; i >= 0; i--) {
      if (values[i] == 0)
        break;
      ans += values[i] * pos;
      pos--;
    }
    ans += pos * min_val;

    System.out.println(ans);
  }
}
