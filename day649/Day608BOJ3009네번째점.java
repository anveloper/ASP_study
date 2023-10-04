package day649;

import java.io.*;
import java.util.*;

public class Day608BOJ3009네번째점 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] coord_1 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    st = new StringTokenizer(br.readLine(), " ");
    int[] coord_2 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    st = new StringTokenizer(br.readLine(), " ");
    int[] coord_3 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

    int x;
    int y;

    if (coord_1[0] == coord_2[0])
      x = coord_3[0];
    else if (coord_1[0] == coord_3[0])
      x = coord_2[0];
    else
      x = coord_1[0];

    if (coord_1[1] == coord_2[1])
      y = coord_3[1];
    else if (coord_1[1] == coord_3[1])
      y = coord_2[1];
    else
      y = coord_1[1];

    System.out.println(x + " " + y);
  }
}