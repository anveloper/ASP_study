import java.io.*;
import java.util.*;

public class Day373BOJ1722순열의순서 { // gg
    static int N, cmd;
    static long k;
    static int[] arr;
    static long[] facto;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cmd = Integer.parseInt(st.nextToken());

        arr = new int[N];
        facto = new long[N + 1];
        visited = new boolean[N + 1];

        facto[0] = 1;
        for (int i = 1; i < N + 1; i++)
            facto[i] = facto[i - 1] * i;

        if (cmd == 1) {
            k = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (visited[j])
                        continue;
                    if (facto[N - i - 1] < k)
                        k -= facto[N - i - 1];
                    else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(print(arr));
        } else {
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            k = 1L;
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < arr[i]; j++)
                    if (!visited[j])
                        k += facto[N - i - 1];
                visited[arr[i]] = true;
            }
            System.out.println(k);
        }
        br.close();
    }

    private static String print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i] + " ");
        return sb.toString();
    }
}
