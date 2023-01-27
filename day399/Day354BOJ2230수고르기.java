import java.io.*;
import java.util.*;

public class Day354BOJ2230수고르기 {
    static int N, M, s, e, tmp, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        for (s = 0; s < N; s++) {
            while (e < N - 1 && arr[e] - arr[s] < M)
                e++;

            if (arr[e] - arr[s] >= M)
                ans = Math.min(ans, arr[e] - arr[s]);
        }
        System.out.println(ans);
        br.close();
    }
}
