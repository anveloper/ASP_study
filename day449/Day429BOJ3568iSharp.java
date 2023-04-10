package day449;

import java.io.*;

public class Day429BOJ3568iSharp {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String in = br.readLine();
    String[] data = in.split(" ");
    for (int i = 1; i < data.length; i++)
      getParam(data[0], data[i]);
    System.out.println(sb);
  }

  public static void getParam(String type, String str) {
    String out = "";
    StringBuilder tmp = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char cur = str.charAt(i);
      if (cur == '*' || cur == '&')
        tmp.append(cur);
      else if (cur == '[')
        tmp.append(']');
      else if (cur == ']')
        tmp.append('[');
      else if (('A' <= cur && cur <= 'Z') || ('a' <= cur && cur <= 'z'))
        out += str.charAt(i);
    }
    sb.append(type + tmp.reverse() + " ").append(out + ";\n");
  }
}