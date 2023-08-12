package day599;

import java.io.*;
import java.util.*;

public class Day553BOJ1085직사각형 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int x_min = Math.min(x, w - x);
    int y_min = Math.min(y, h - y);
    System.out.println(Math.min(x_min, y_min));
  }
}
