package day499;

import java.util.*;
import java.io.*;

public class Day496BOJ10869사칙연산 {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int A = in.nextInt();
    int B = in.nextInt();

    in.close();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.write((A + B) + "\n");
    bw.write((A - B) + "\n");
    bw.write((A * B) + "\n");
    bw.write((A / B) + "\n");
    bw.write((A % B) + "\n");

    bw.flush();
    bw.close();
  }
}