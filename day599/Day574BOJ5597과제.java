package day599;

import java.util.*;

public class Day574BOJ5597과제 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] student = new int[31];

    for (int i = 1; i < 29; i++) {
      int success = sc.nextInt();
      student[success] = 1;
    }
    for (int i = 1; i < student.length; i++) {
      if (student[i] != 1)
        System.out.println(i);
    }

    sc.close();
  }
}