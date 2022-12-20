package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Day316BOJ1327소트게임 {
    static int N, K, ans;
    static String A = "", B = ""; // A: 원본, B: 목표
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            A += arr[i] + "";
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            B += arr[i] + "";
        }

        System.out.println(bfs() ? ans : -1);

        br.close();
    }

    static Queue<String> q;
    static Set<String> visited; // List로 하면 시간초과

    private static boolean bfs() {
        ans = 0;
        q = new LinkedList<>();
        visited = new HashSet<>();

        q.add(A);
        visited.add(A);

        while (!q.isEmpty()) {
            int r = q.size();
            if (find(r))
                return true;
            else
                ans++;
        }
        return false;
    }

    private static boolean find(int r) {
        while (r-- > 0) {
            String a = q.poll();
            if (a.equals(B)) {
                return true;
            }
            for (int i = 0; i <= N - K; i++) {
                String tmp = swap(a, i);
                if (!visited.contains(tmp)) {
                    q.add(tmp);
                    visited.add(tmp);
                }
            }
        }
        return false;
    }

    private static String swap(String s, int i) {
        StringBuilder sb = new StringBuilder(s);
        int st = i;
        int ed = i + K - 1;
        while (st < ed) {
            char c = sb.charAt(st);
            sb.setCharAt(st, sb.charAt(ed));
            sb.setCharAt(ed, c);
            st++;
            ed--;
        }
        return sb.toString();
    }
}
