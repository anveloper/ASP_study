package day649;

import java.io.*;
import java.util.*;

public class Day642BOJ2914저작권 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    bw.write(String.valueOf(Integer.parseInt(st.nextToken()) * (Integer.parseInt(st.nextToken()) - 1) + 1));
    bw.flush();
    bw.close();
  }
}