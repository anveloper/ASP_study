package day499;

import java.io.*;
import java.util.*;

public class Day497BOJ10430나머지 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    sb.append((A + B) % C).append('\n');
    sb.append((A % C + B % C) % C).append('\n');
    sb.append((A * B) % C).append('\n');
    sb.append((A % C * B % C) % C);
    System.out.println(sb);
  }
}
