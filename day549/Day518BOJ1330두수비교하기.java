package day549;

import java.io.*;
import java.util.*;

public class Day518BOJ1330두수비교하기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    System.out.println((A > B) ? ">" : ((A < B) ? "<" : "=="));
  }
}
