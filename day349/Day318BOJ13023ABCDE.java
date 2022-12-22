package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day318BOJ13023ABCDE {
    static int N, M;
    static boolean state = false;
    static List<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        solve();
        br.close();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            check = new boolean[N];
            dfs(i, 1);
            if (state) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int idx, int d) {
        if (d == 5) {
            state = true;
            return;
        }
        check[idx] = true;
        for (int i : list[idx]) {
            if (!check[i]) {
                dfs(i, d + 1);
            }
        }
        check[idx] = false;
    }
}
