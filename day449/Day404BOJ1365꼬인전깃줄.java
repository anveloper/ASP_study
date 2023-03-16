package day449;

import java.io.*;
import java.util.*;

public class Day404BOJ1365꼬인전깃줄 {
    static int n, max;
    static int arr[], lis[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        lis[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (lis[max] < arr[i]) {
                lis[++max] = arr[i];
            } else {
                fn(arr[i]);
            }
        }

        System.out.println(n - (max + 1));

    }

    public static void fn(int key) {
        int s = 0;
        int e = max;

        while (s <= e) {
            int m = (s + e) / 2;

            if (lis[m] < key) {
                s = m + 1;
            } else {
                if (lis[m] == key) {
                    return;
                }
                e = m - 1;
            }
        }
        lis[s] = key;
    }
}
