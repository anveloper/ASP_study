package day549;

import java.io.*;
import java.util.*;

public class Day536BOJ2525오븐시계 {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int C = Integer.parseInt(br.readLine());

    int min = 60 * A + B;
    min += C;

    int hour = (min / 60) % 24;
    int minute = min % 60;

    System.out.println(hour + " " + minute);

  }
}