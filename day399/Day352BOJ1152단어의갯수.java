package day399;

import java.io.*;
import java.util.*;

public class Day352BOJ1152단어의갯수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.print(st.countTokens());
    }
}
