package day649;

import java.io.*;

public class Day615BOJ5543상근날드 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int burger = 2001;
    int drink = 2001;

    for (int i = 0; i < 3; i++) {
      int value = Integer.parseInt(br.readLine());
      if (value < burger) {
        burger = value;
      }
    }

    for (int i = 0; i < 2; i++) {
      int value = Integer.parseInt(br.readLine());
      if (value < drink) {
        drink = value;
      }
    }

    System.out.println(burger + drink - 50);
  }
}