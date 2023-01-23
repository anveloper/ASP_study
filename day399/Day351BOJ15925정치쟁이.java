package day399;

import java.io.*;
import java.util.*;

public class Day351BOJ15925정치쟁이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] varr = new int[n];
        int[] harr = new int[n];
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != s)
                    continue;
                varr[i]++;
                harr[j]++;
            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (varr[i] < n && varr[i] > n / 2) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] == s)
                            continue;
                        arr[i][j] = s;
                        harr[j]++;
                    }
                    varr[i] = n;
                    if (!flag)
                        flag = true;
                }

                if (harr[i] < n && harr[i] > n / 2) {
                    for (int j = 0; j < n; j++) {
                        if (arr[j][i] == s)
                            continue;
                        arr[j][i] = s;
                        varr[j]++;
                    }
                    harr[i] = n;
                    if (!flag)
                        flag = true;
                }
            }
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            if (varr[i] != n || harr[i] != n) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println(0);
        else
            System.out.println(1);
    }
}