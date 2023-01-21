package day349;

import java.io.*;
import java.util.*;

public class Day349BOJ11050이항계수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(BC(N, K));
    }

    static int BC(int n, int k) {
        if (n == k || k == 0)
            return 1;

        return BC(n - 1, k - 1) + BC(n - 1, k);
    }
}
