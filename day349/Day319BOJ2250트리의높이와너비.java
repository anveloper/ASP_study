package day349;

import java.io.*;
import java.util.*;

public class Day319BOJ2250트리의높이와너비 {
    static int ans, N, row = 1;
    static int[] p, l, r, min, max;
    static boolean[] visited;
    static List<List<Integer>> widths;
    static int ansWidth = 0;
    static int ansLevel = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        l = new int[N + 1];
        r = new int[N + 1];
        min = new int[N + 1];
        Arrays.fill(min, 20000);
        max = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (left != -1) {
                p[left] = cur;
            }
            l[cur] = left;
            if (right != -1) {
                p[right] = cur;
            }
            r[cur] = right;
        }

        int root = findRoot(1);

        inorder(root, 1);
        for (int i = 1; i <= N; i++) {
            if (ansWidth < max[i] - min[i] + 1) {
                ansWidth = max[i] - min[i] + 1;
                ansLevel = i;
            }
        }
        System.out.println(ansLevel + " " + ansWidth);
    }

    static int findRoot(int cur) {
        if (p[cur] != 0)
            return findRoot(p[cur]);
        else
            return cur;
    }

    static void inorder(int cur, int level) {
        if (cur != -1) {
            inorder(l[cur], level + 1);
            min[level] = Math.min(min[level], row);
            max[level] = Math.max(max[level], row);
            row++;
            inorder(r[cur], level + 1);
        }
    }
}
