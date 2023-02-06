import java.io.*;
import java.util.*;

class Day365BOJ2263트리의순회 {
    static int N;
    static int[] inOrder, postOrder;
    static int[] getRootIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        inOrder = new int[N];
        postOrder = new int[N];

        getRootIdx = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            inOrder[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            postOrder[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++)
            getRootIdx[inOrder[i]] = i;

        recur(0, N - 1, 0, N - 1);
        System.out.println(sb);
        br.close();
    }

    private static void recur(int inSt, int inEd, int poSt, int poEd) {
        if (inSt > inEd || poSt > poEd)
            return;
        int r = postOrder[poEd];
        sb.append(r + " ");

        int inRoot = getRootIdx[r];
        int l = inRoot - inSt;
        recur(inSt, inRoot - 1, poSt, poSt + l - 1);
        recur(inRoot + 1, inEd, poSt + l, poEd - 1);
    }
}
