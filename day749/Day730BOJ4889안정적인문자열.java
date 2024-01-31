package day749;

import java.io.*;

public class Day730BOJ4889안정적인문자열 {

  static String line;
  static char[] data = { '{', '}', '{', '}', '{', '}' };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = 1;
    while (true) {
      line = br.readLine();
      if (line.toCharArray()[0] == '-')
        break;
      data = line.toCharArray();

      boolean flag = false;
      int cnt = 0;
      int ans = 0;

      for (int i = 0; i < data.length; i++) {
        if (flag) {
          if (data[i] == '{') {
            ans++;
          }
          continue;
        }

        if (cnt == 0 && data[i] == '}') {
          ans++;
          cnt++;
          continue;
        }

        if (data.length - i == cnt) {
          if (data[i] == '{') {
            ans++;
          }
          flag = true;
          continue;
        }

        if (data[i] == '}') {
          cnt--;
        } else if (data[i] == '{') {
          cnt++;
        }
      }
      sb.append(T++ + ". " + ans + "\n");
    }
    System.out.println(sb);
  }
}