package day749;

import java.io.*;
import java.util.*;

public class Day738BOJ1076저항 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] color = { "black", "brown", "red", "orange", "yellow", "green",
        "blue", "violet", "grey", "white" };

    String A = br.readLine();
    String B = br.readLine();
    String C = br.readLine();

    long ans = (Arrays.asList(color).indexOf(A) * 10) + Arrays.asList(color).indexOf(B);
    ans *= Math.pow(10, Arrays.asList(color).indexOf(C));
    System.out.println(ans);
  }
}