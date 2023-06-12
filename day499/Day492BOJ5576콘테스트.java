package day499;

import java.io.*;
import java.util.*;

public class Day492BOJ5576콘테스트 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> W = new ArrayList<>();
    ArrayList<Integer> K = new ArrayList<>();
    for (int i = 0; i < 10; i++)
      W.add(Integer.parseInt(br.readLine()));
    for (int i = 0; i < 10; i++)
      K.add(Integer.parseInt(br.readLine()));
    Collections.sort(W);
    Collections.sort(K);
    StringBuilder sb = new StringBuilder();
    sb.append(W.get(7) + W.get(8) + W.get(9)).append(' ').append(K.get(7) + K.get(8) + K.get(9));
    System.out.println(sb);
  }
}