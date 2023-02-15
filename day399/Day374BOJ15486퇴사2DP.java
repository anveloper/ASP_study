import java.io.*;
import java.util.*;

public class Day374BOJ15486퇴사2DP {
    static int[] T, P;
    static int N;
    static int max;
    static int[] DP;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        T = new int[N + 2];
        P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        DP = new int[N + 2];

        for (int i = 1; i < N + 2; i++) {
            if (max < DP[i])
                max = DP[i];
            int day = i + T[i];
            if (day < N + 2)
                DP[day] = Math.max(DP[day], max + P[i]);
        }
        System.out.println(max);
    }
}
