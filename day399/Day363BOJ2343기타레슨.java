import java.io.*;
import java.util.*;

public class Day363BOJ2343기타레슨 {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int L = -1, R = 1000000000, ans = 0;
        for (int i = 0; i < N; i++)
            L = Math.max(L, A[i]);
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int value) {
        int cnt = 1, sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + A[i] > value) {
                sum = A[i];
                cnt++;
            } else {
                sum += A[i];
            }
        }
        return cnt <= M;
    }
}
