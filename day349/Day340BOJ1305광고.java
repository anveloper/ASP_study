package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day340BOJ1305광고 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();
        int[] p = new int[L];

        int j = 0;
        for (int i = 1; i < L; i++) {
            while (j > 0 && c[j] != c[i])
                j = p[j - 1];
            if (c[j] == c[i])
                j++;
            p[i] = j;
        }
        System.out.println(L - p[L - 1]);
        br.close();
    }
}
