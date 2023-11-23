package day699;

import java.io.*;

public class Day657BOJ3613JAVAvsC {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] c_arr = br.readLine().toCharArray();
    int flag = 3;

    if (c_arr[0] < 97 || c_arr[0] > 122) {
      flag = 0;
    } else {
      for (int i = 1; i < c_arr.length; i++) {
        char c = c_arr[i];
        if (c == 95) {
          if (flag == 1) {
            flag = 0;
            break;
          } else {
            if (i == c_arr.length - 1) {
              flag = 0;
              break;
            } else if (c_arr[i + 1] == '_') {
              flag = 0;
              break;
            } else {
              flag = 2;
            }
          }
        } else if (c >= 65 && c <= 90) {
          if (flag == 2) {
            flag = 0;
            break;
          } else {
            flag = 1;
          }
        }
      }
    }

    if (flag == 0) {
      System.out.println("Error!");
    } else if (flag == 1) {
      convertToC(c_arr);
    } else if (flag == 2) {
      convertToJava(c_arr);
    } else {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < c_arr.length; i++) {
        sb.append(c_arr[i]);
      }
      System.out.println(sb.toString());
    }

    return;
  }

  private static void convertToJava(char[] c_arr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < c_arr.length; i++) {
      char c = c_arr[i];
      if (c == 95) {
        i++;
        sb.append((char) (c_arr[i] - 32));
      } else {
        sb.append(c);
      }
    }
    System.out.println(sb.toString());
    return;
  }

  private static void convertToC(char[] c_arr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < c_arr.length; i++) {
      char c = c_arr[i];
      if (c >= 65 && c <= 90) {
        sb.append('_');
        sb.append((char) (c + 32));
      } else {
        sb.append(c);
      }
    }
    System.out.println(sb.toString());
    return;
  }
}
