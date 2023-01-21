package day349;

import java.io.*;
import java.util.*;

public class Day348BOJ2668숫자고르기 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int n, int start) {
        if (arr[n] == start) {
            list.add(n);
            return;
        }

        visited[n] = true;
        if (!visited[arr[n]]) {
            dfs(arr[n], start);
        }
    }
}
