package day349;

import java.util.Scanner;

public class Day300BOJ2747피보나치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F1 = 0, F2 = 1, F3 = 1;
        for (int i = 2; i <= N; i++) {
            F3 = F1 + F2;
            F1 = F2;
            F2 = F3;
        }
        System.out.println(F3);
        sc.close();
    }
}
