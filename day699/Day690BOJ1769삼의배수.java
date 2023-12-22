package day699;

import java.io.*;

public class Day690BOJ1769삼의배수 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    String str = br.readLine();
    long ans = 0, cnt = 0;
    while (true) {
      ans = 0;
      if (str.length() == 1) {
        break;
      }
      char[] array = str.toCharArray();
      for (int i = 0; i < array.length; i++) {
        ans += (int) (array[i] - '0');
      }
      str = String.valueOf(ans);
      cnt++;
    }
    sb.append(cnt).append('\n').append(Integer.parseInt(String.valueOf(str)) % 3 == 0 ? "YES" : "NO");
    bw.write(sb.toString());
    br.close();
    bw.close();
  }
}