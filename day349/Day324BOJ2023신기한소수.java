package day349;

import java.util.Scanner;

public class Day324BOJ2023신기한소수 {
    static int N;
    static int[] pre = { 2, 3, 5, 7 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i : pre)
            dfs(i, 1);

        System.out.println(sb);
        sc.close();
    }

    private static void dfs(int p, int n) {
        if (n == N) {
            if (isPrime(p))
                sb.append(p + "\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            int t = p * 10 + i;
            if (isPrime(t))
                dfs(t, n + 1);
        }
    }

    private static boolean isPrime(int p) {
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0)
                return false;
        }
        return true;
    }
}
