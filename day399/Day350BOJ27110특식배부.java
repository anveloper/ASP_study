package day399;

import java.io.*;
import java.util.*;

public class Day350BOJ27110특식배부 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        System.out.println(Math.min(Integer.parseInt(st.nextToken()), N) + Math.min(Integer.parseInt(st.nextToken()), N)
                + Math.min(Integer.parseInt(st.nextToken()), N));
        br.close();
    }
}
